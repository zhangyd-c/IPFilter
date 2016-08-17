package com.test.listener;

import java.util.Hashtable;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Description 自定义监听器，项目启动时初始化两个全局的hashTable(线程安全)
 * ipTable(ip存储器，记录IP的访问次数、访问时间)
 * limitedIpTable(限制IP存储器)用来存储每个访问用户的IP以及访问的次数
 * @author zhangyd
 * @date 2016年7月28日 下午5:47:23 
 * @since JDK ： 1.7
 * @version 2.0
 * @modify
 * 		改hashMap 为 hashTable
 */
public class MyListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		// IP存储器
		Hashtable<String, Long[]> ipTable = new Hashtable<String, Long[]>();
		context.setAttribute("ipTable", ipTable);
		// 限制IP存储器：存储被限制的IP信息
		Hashtable<String, Long> limitedIpTable = new Hashtable<String, Long>();
		context.setAttribute("limitedIpTable", limitedIpTable);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}


