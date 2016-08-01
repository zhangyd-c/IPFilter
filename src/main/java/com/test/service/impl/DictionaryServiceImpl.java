package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.IDictionaryDao;
import com.test.entity.Dictionary;
import com.test.service.IDictionaryService;

/**
 * @author (作者) zhangyd-c 2015年7月31日 下午6:04:48
 * @version (版本) V1.0
 * @since (该版本支持的JDK版本) ： 1.7
 */
@Service
public class DictionaryServiceImpl implements IDictionaryService {

	@Autowired
	private IDictionaryDao dictionaryDao;

	/**
	 * @Description 获取字典列表
	 * @author zhangyd
	 * @date 2015年11月30日 下午4:05:17
	 * @param dictionary
	 * @return
	 */
	@Override
	public List<Dictionary> getDictionaryList(Dictionary dictionary) {
		return dictionaryDao.getDictionaryList(dictionary);
	}
}
