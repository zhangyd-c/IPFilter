package com.test.interceptor;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.util.IPUtil;

/**
 * 
 * @Description 自定义过滤器，用来处理 判断IP访问次数是否超限
 * @author zhangyd
 * @date 2016年7月28日 下午5:54:51
 * @since JDK ： 1.7
 */
public class MyFilter implements Filter {

	private FilterConfig config;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		ServletContext context = config.getServletContext();
		Map<String, Long[]> ipMap = (Map<String, Long[]>) context.getAttribute("ipMap");
		String ip = IPUtil.getIp(request);
		if (ipMap.containsKey(ip)) {
			Long[] ipInfo = ipMap.get(ip);
			Long count = ipInfo[0];
			ipInfo[0] = count + 1;
			System.out.println("当前第[" + (count + 1) + "]次访问");
			if (count >= 20) {
				Long currentTimeMillis = ipInfo[1];
				Long a = System.currentTimeMillis() - currentTimeMillis;
				if (a <= 5000) {
					response.sendRedirect("/error/overLimitIP");
					return;
				} else {
					initIpVisitsNumber(ipMap, ip);
				}
			}
		} else {
			initIpVisitsNumber(ipMap, ip);
			System.out.println("您首次访问该网站");
		}
		context.setAttribute("ipMap", ipMap);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

	/**
	 * 初始化用户访问次数
	 * 
	 * @author zhangyd
	 * @date 2016年7月29日 上午10:01:39
	 * @param ipMap
	 * @param ip
	 */
	private void initIpVisitsNumber(Map<String, Long[]> ipMap, String ip) {
		Long[] ipInfo = new Long[2];
		ipInfo[0] = 0L;
		ipInfo[1] = System.currentTimeMillis();
		ipMap.put(ip, ipInfo);
	}

}
