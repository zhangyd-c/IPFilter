package com.test.dao;

import java.util.List;
import java.util.Map;

import com.test.entity.LocationConfig;

/**
 * @author (作者) zhangyd-c 2015年7月31日 下午6:00:54
 * @version (版本) V1.0
 * @since (该版本支持的JDK版本) ： 1.7
 */
public interface ILocationDao {

	LocationConfig selectByPrimaryKey(String areaCode);

	List<LocationConfig> selectAllLocationPage(@SuppressWarnings("rawtypes") Map map);

	List<LocationConfig> selectListByParentAreaCode(String parentAreaCode);

	List<LocationConfig> selectProvince();

	List<LocationConfig> selectProvinceByAdminId(List<String> list);

	List<LocationConfig> selectProvinceList();

	List<LocationConfig> getAreasByCompanyId(Long companyId);

	List<String> selectLocationsByName(Map<String, Object> params);

	Map<String, String> selectProvinceNameAndCityName(String code);

	// 通过areaCode查询地区名称
	String selectNameByAreaCode(String areaCode);

	// 获得所有的省
	List<LocationConfig> selectAllProvinces();

	// 获得所有的市
	List<LocationConfig> selectAllCitys();
}
