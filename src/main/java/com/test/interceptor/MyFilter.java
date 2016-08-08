package com.test.interceptor;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
	
	private static final long LIMITED_TIME_MILLIS = 3 * 60 * 1000;

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
		// IP存储器
		Map<String, Long[]> ipMap = (Map<String, Long[]>) context.getAttribute("ipMap");
		// IP限制存储器：存储被限制的IP信息
		Map<String, Long> limitedIpMap = (Map<String, Long>) context.getAttribute("limitedIpMap");
		filterLimitedIpMap(limitedIpMap);
		String ip = IPUtil.getIp(request);
		
		if(isLimitedIP(limitedIpMap, ip)){
			request.setAttribute("remainingTime", limitedIpMap.get(ip) - System.currentTimeMillis());
			request.getRequestDispatcher("/error/overLimitIP").forward(request, response);
			return;
		}
		if (ipMap.containsKey(ip)) {
			Long[] ipInfo = ipMap.get(ip);
			Long count = ipInfo[0];
			ipInfo[0] = count + 1;
			System.out.println("当前第[" + (count + 1) + "]次访问");
			if (count >= 20) {
				Long ipAccessTime = ipInfo[1];
				Long currentTimeMillis = System.currentTimeMillis();
				if (currentTimeMillis - ipAccessTime <= 5000) {
					limitedIpMap.put(ip, currentTimeMillis + LIMITED_TIME_MILLIS);
					request.setAttribute("remainingTime", LIMITED_TIME_MILLIS);
					request.getRequestDispatcher("/error/overLimitIP").forward(request, response);
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
	 * @Description 是否是被限制的IP
	 * @author zhangyd
	 * @date 2016年8月8日 下午5:39:17 
	 * @param limitedIpMap
	 * @param ip
	 * @return
	 */
	private boolean isLimitedIP(Map<String, Long> limitedIpMap, String ip){
		if(limitedIpMap == null || ip == null){
			// 没有被限制
			return false;
		}
		Set<String> keys = limitedIpMap.keySet();
		Iterator<String> keyIt = keys.iterator();
		while(keyIt.hasNext()){
			String key = keyIt.next();
			if(key.equals(ip)){
				// 被限制的IP
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * @Description 过滤受限的IP，剔除已经到期的限制IP
	 * @author zhangyd
	 * @date 2016年8月8日 下午5:34:33 
	 * @param limitedIpMap
	 */
	private void filterLimitedIpMap(Map<String, Long> limitedIpMap){
		if(limitedIpMap == null){
			return ;
		}
		Set<String> keys = limitedIpMap.keySet();
		Iterator<String> keyIt = keys.iterator();
		long currentTimeMillis = System.currentTimeMillis();
		while(keyIt.hasNext()){
			long expireTimeMillis = limitedIpMap.get(keyIt.next());
			if(expireTimeMillis <= currentTimeMillis){
				keyIt.remove();
			}
		}
		
	}

	/**
	 * 初始化用户访问次数和访问时间
	 * 
	 * @author zhangyd
	 * @date 2016年7月29日 上午10:01:39
	 * @param ipMap
	 * @param ip
	 */
	private void initIpVisitsNumber(Map<String, Long[]> ipMap, String ip) {
		Long[] ipInfo = new Long[2];
		ipInfo[0] = 0L;// 访问次数
		ipInfo[1] = System.currentTimeMillis();// 初次访问时间
		ipMap.put(ip, ipInfo);
	}

}
