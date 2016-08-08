package com.test.common;

/**
 * @author (作者) zhangyd-c 2015年9月8日 下午6:10:19
 * @version (版本) V1.0
 * @since (该版本支持的JDK版本) ： 1.7
 */

public class Constants {
	/** 发送邮件的服务器的IP和端口 smtp.163.com */
	public static final String MAIL_SERVERHOST = "smtp.163.com";

	public static final String MAIL_SERVERPORT = "25";

	/** 邮件发送者的地址 */
	public static final String FROMADDRESS = "rxxzyd1123@163.com";

	/** 登陆邮件发送服务器的用户名和密码 */
	public static final String MAIL_USERNAME = "rxxzyd1123@163.com";

	public static final String MAIL_PASSWORD = "xxxxxx";

	public static final String CODE_500 = "500";
	public static final String CODE_900 = "900";
	public static final String CODE_200 = "200";
	public static final String CODE_404 = "404";

	/** yyyy-MM-dd HH:mm:ss */
	public static final String DATE_FORMAT_REG_S_E = "yyyy-MM-dd HH:mm:ss";
	/** yyyyMMddHHmmss */
	public static final String DATE_FORMAT_REG_S = "yyyyMMddHHmmss";
	/** yyyy-MM-dd */
	public static final String DATE_FORMAT_REG_D_E = "yyyy-MM-dd";
	/** yyyyMMdd */
	public static final String DATE_FORMAT_REG_D = "yyyyMMdd";
	/** yyyy年MM月dd日 HH时mm分ss秒 */
	public static final String DATE_FORMAT_REG_S_C = "yyyy年MM月dd日 HH时mm分ss秒";
	/** yyyy年MM月dd日 */
	public static final String DATE_FORMAT_REG_D_C = "yyyy年MM月dd日";

	/** 过滤的磁盘地址 */
	public static final String[] LOCAL_DISK = { "C:\\", "D:\\", "F:\\", "C:", "D:", "F:", "C", "D", "F" };

	public static final String REQUEST_TYPE_GET = "GET";
	public static final String REQUEST_TYPE_POST = "POST";

	/** 淘宝IP地址查询接口地址 */
	public static final String GET_IP_TAOBAO_URL = "http://ip.taobao.com/service/getIpInfo.php";
	/** 腾讯IP地址查询接口地址 */
	public static final String GET_IP_TENCENT_URL = "http://ip.qq.com/cgi-bin/searchip";
	/** 新浪IP地址查询接口地址 */
	public static final String GET_IP_SINA_URL = "http://int.dpool.sina.com.cn/iplookup/iplookup.php";
	/** 百度IP地址查询接口地址 */
	public static final String GET_IP_BAIDU_URL = "http://apis.baidu.com/apistore/iplookupservice/iplookup";
	/** 调用百度验证IP接口的apikey */
	public static final String BAIDU_APIKEY = "1d87fdaa69e17312cb8b56e3d07dbd86";
}
