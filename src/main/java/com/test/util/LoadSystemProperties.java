package com.test.util;

import java.util.ResourceBundle;

/**
 * 读取资源文件
 * 
 * @author (作者) zhangyd-c 2015年10月10日 下午3:14:06
 * @version (版本) V1.0
 * @since (该版本支持的JDK版本) ： 1.7
 */
public class LoadSystemProperties {

	public static ResourceBundle bundle = ResourceBundle.getBundle("property/init");

	/**
	 * 文件位置
	 */
	public static final String UPLOAD_FILES_PATH = bundle.getString("uploadFilesPath");

	public static final String GENERATION_JAVA_FILE_PATH = bundle.getString("generationJavaFilesPath");
	public static final String GENERATION_XML_FILE_PATH = bundle.getString("generationXmlFilesPath");

	public static final String FILE_TEM_DIR = bundle.getString("fileTemDir");
}
