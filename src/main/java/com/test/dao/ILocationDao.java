package com.test.dao;

import java.util.List;
import java.util.Map;

import com.test.entity.Location;

/**
 * @author (作者) zhangyd-c 2015年7月31日 下午6:00:54
 * @version (版本) V1.0
 * @since (该版本支持的JDK版本) ： 1.7
 */
public interface ILocationDao {

	Location selectByPrimaryKey(String areaCode);

	List<Location> selectAllLocationPage(@SuppressWarnings("rawtypes") Map map);

	// int deleteByPrimaryKey(String areaCode);

	// int insert(Location location);

	// int insertSelective(Location location);

	// int updateByPrimaryKeySelective(Location location);

	// int updateByPrimaryKey(Location location);

	List<Location> selectListByParentAreaCode(String parentAreaCode);

	List<Location> selectProvince();

	List<Location> selectProvinceByAdminId(List<String> list);

	List<Location> selectProvinceList();

	List<Location> getAreasByCompanyId(Long companyId);

	List<String> selectLocationsByName(Map<String, Object> params);

	Map<String, String> selectProvinceNameAndCityName(String code);

	// 通过areaCode查询地区名称
	String selectNameByAreaCode(String areaCode);

	// 获得所有的省
	List<Location> selectAllProvinces();

	// 获得所有的市
	List<Location> selectAllCitys();
}
