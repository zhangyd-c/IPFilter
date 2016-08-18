package com.test.task;

import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoaderListener;

/**
 * @Description IP限制过滤器定时任务，过滤受限的IP，剔除已经到期的限制IP
 * @author zhangyd
 * @date 2016年8月18日 上午9:39:19
 * @version V1.0
 * @since JDK ： 1.7
 * @modify 将IP限制过滤手动触发改为定时任务
 */
@Component
public class IPFilterTask {

	/**
	 * @Description 30s执行一次过滤操作
	 * @author zhangyd
	 * @date 2016年8月17日 下午5:49:55
	 */
	@Scheduled(cron = "0/30 * *  * * ? ")
	public void filterLimitedIpMap() {
		ServletContext context = ContextLoaderListener.getCurrentWebApplicationContext().getServletContext();
		@SuppressWarnings("unchecked")
		ConcurrentHashMap<String, Long> limitedIpMap = (ConcurrentHashMap<String, Long>) context
				.getAttribute("limitedIpMap");
		if (limitedIpMap.isEmpty()) {
			return;
		}
		Iterator<Entry<String, Long>> it = limitedIpMap.entrySet().iterator();
		long currentTimeMillis = System.currentTimeMillis();
		while (it.hasNext()) {
			Entry<String, Long> e = it.next();
			long expireTimeMillis = e.getValue();
			if (expireTimeMillis <= currentTimeMillis) {
				it.remove();
				System.out.println(new Date() + "时，去掉了一个限制用户[" + e.getKey() + "]");
			}
		}
	}
}
