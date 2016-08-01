package com.test.service;

import java.util.List;

import com.test.entity.DictionaryConfig;

/**
 * @Description
 * @author zhangyd
 * @date 2015年12月9日 上午10:59:40
 * @version V1.0
 * @since JDK ： 1.7
 * @modify
 * @Review
 */

public interface IDictionaryService {
	/**
	 * @Description 获取字典列表
	 * @author zhangyd
	 * @date 2015年11月30日 下午4:05:17
	 * @param dictionary
	 * @return
	 */
	public List<DictionaryConfig> getDictionaryList(DictionaryConfig dictionary);

}
