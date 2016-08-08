package com.test.dao;

import java.util.List;

import com.test.entity.DictionaryConfig;

/**
 * @author (作者) zhangyd-c 2015年7月31日 下午6:00:10 
 * @version (版本) V1.0
 * @since (该版本支持的JDK版本) ： 1.7
 */
public interface IDictionaryDao {
    
    List<DictionaryConfig> getDictionaryList(DictionaryConfig dictionary);
}
