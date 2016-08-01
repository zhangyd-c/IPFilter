package com.test.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author (作者) zhangyd-c 2015年7月31日 下午6:05:32
 * @version (版本) V1.0
 * @since (该版本支持的JDK版本) ： 1.7
 */
public class SessionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		// 防止网页被Frame嵌套，SAMEORIGIN：frame页面的地址只能为同源域名下的页面
		response.addHeader("x-frame-options", "SAMEORIGIN");
		// String path = request.getRequestURI();
		// // 拼接请求参数
		// if (null != request.getQueryString()) {
		// path = path + "?" + request.getQueryString();
		// }

		// 获取session
		HttpSession session = request.getSession();
		if (session == null) {
			// TODO 处理逻辑
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {

	}
}
