package com.test.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @Description
 * @author zhangyd
 * @date 2015年11月16日 下午5:58:57
 * @version V1.0
 * @since JDK ： 1.7
 * @modify
 * @Review
 */

public class BaseController {

	/**
	 * @Description 获取项目路径
	 * @author zhangyd
	 * @date 2015年12月1日 下午4:05:31
	 * @return
	 */
	public static String getRealPath() {
		return getSession().getServletContext().getRealPath("/");
	}

	/**
	 * @Description 获取tomcat安装路径
	 * @author zhangyd
	 * @date 2015年12月1日 下午4:05:36
	 * @return
	 */
	public static String getTomcatPath() {
		return System.getProperty("catalina.home").replaceAll("\\\\", "/") + "/";
	}

	/**
	 * @Description 得到request
	 * @author zhangyd
	 * @date 2015年12月1日 下午4:05:41
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request;
	}

	/**
	 * @Description 得到session
	 * @author zhangyd
	 * @date 2015年12月1日 下午4:05:49
	 * @return
	 */
	public static HttpSession getSession() {
		HttpSession session = getRequest().getSession();
		return session;
	}
}
