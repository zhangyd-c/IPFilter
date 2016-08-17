#IP访问次数限制器#

**用到的技术** 

`过滤器（Filter）`：统计用户访问次数，记录访问时间、封禁时间  
`监听器（Listener）`：工程运行时初始化IP存储器（此处用的Map）

**我的思路**

工程启动时，创建两个Map，一个（ipMap）用来存放用户Ip和访问时间等主要信息，另一个（limitedIpMap）用来存放被限制的用户IP。Map的key为用户的IP，value为具体内容。当用户访问系统时，通过IPFilter检查limitedIpMap中是否存在当前IP，如果存在说明该IP之前存在过恶意刷新访问，已经被限制，跳转到异常提示页面；如果limitedIpMap中不存在则检查ipMap中是否存在当前IP，如果ipMap中不存在则说明用户初次访问，用户访问次数+1，初始访问时间为当前时间；如果存在则检查用户访问次数是否在规定的短时间内进行了大量的访问操作；如果是，则将当前IP添加到limitedIpMap中，并跳转到异常提示页面，否则不进行操作，直接放行本次请求。
![简单流程图](https://github.com/zhangyd-c/IPFilter/blob/master/doc/IPFilter/IPFilterFlowChart.png)

**配置文件**

    <!-- 配置过滤器 start -->
    <filter>
    	<filter-name>IPFilter</filter-name>
    	<filter-class>com.test.interceptor.IPFilter</filter-class>
    </filter>
    <filter-mapping>
    	<filter-name>IPFilter</filter-name>
    	<url-pattern>/render/*</url-pattern>
    </filter-mapping>
    <!-- 配置过滤器 end -->
    	
    <!-- 配置监听器 start -->
    <listener>
    	<listener-class>com.test.listener.MyListener</listener-class>
    </listener>
    <!-- 配置监听器 start -->

IP过滤器配置信息

    /** 默认限制时间（单位：ms） */
    private static final long LIMITED_TIME_MILLIS = 60 * 1000;
    
    /** 用户连续访问最高阀值，超过该值则认定为恶意操作的IP，进行限制 */
    private static final int LIMIT_NUMBER = 20;
    
    /** 用户访问最小安全时间，在该时间内如果访问次数大于阀值，则记录为恶意IP，否则视为正常访问 */
    private static final int MIN_SAFE_TIME = 5000;

 
查看详细说明：[点击这儿](http://www.yadong0415.cn/render/article/5ff8046c5eb149a394c5f8a9a9906d3f)
