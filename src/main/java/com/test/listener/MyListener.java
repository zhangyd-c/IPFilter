package com.test.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Description 自定义监听器，项目启动时声明一个全局的map，用来存储每个访问用户的IP以及访问的次数
 * @author zhangyd
 * @date 2016年7月28日 下午5:47:23 
 * @since JDK ： 1.7
 */
public class MyListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		// IP存储器
		Map<String,Long[]> ipMap = new HashMap<String,Long[]>();
		context.setAttribute("ipMap", ipMap);
		// IP限制存储器：存储被限制的IP信息
		Map<String,Long> limitedIpMap = new HashMap<String,Long>();
		context.setAttribute("limitedIpMap", limitedIpMap);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
