package com.test.listener;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Description 自定义监听器，项目启动时初始化两个全局的ConcurrentHashMap(线程安全)
 *              ipMap(ip存储器，记录IP的访问次数、访问时间)
 *              limitedIpMap(限制IP存储器)用来存储每个访问用户的IP以及访问的次数
 * @author zhangyd
 * @date 2016年7月28日 下午5:47:23
 * @since JDK ： 1.7
 * @version 2.0
 * @modify 改hashMap 为 ConcurrentHashMap
 */
public class MyListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		// IP存储器
		ConcurrentHashMap<String, Long[]> ipMap = new ConcurrentHashMap<String, Long[]>();
		context.setAttribute("ipMap", ipMap);
		// 限制IP存储器：存储被限制的IP信息
		ConcurrentHashMap<String, Long> limitedIpMap = new ConcurrentHashMap<String, Long>();
		context.setAttribute("limitedIpMap", limitedIpMap);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
