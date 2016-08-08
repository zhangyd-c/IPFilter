package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.LocationConfig;

/**
 * @author (作者) zhangyd-c 2015年7月31日 下午6:05:16
 * @version (版本) V1.0
 * @since (该版本支持的JDK版本) ： 1.7
 */
public interface ILocationService {

	/**
	 * 查询地区列表
	 * 
	 * @param parentAreaCode
	 * @return
	 */
	public List<LocationConfig> queryListByParentAreaCode(String parentAreaCode);

	public List<LocationConfig> getAllLocation(@SuppressWarnings("rawtypes") Map map);

	/**
	 * 
	 * @Description 获得所有的省
	 * @author zhangyd-c
	 * @date 2015年4月30日 下午2:01:34
	 * @return
	 */
	public List<LocationConfig> selectAllProvinces();

	/**
	 * 
	 * @Description 获得所有的市
	 * @author zhangyd-c
	 * @date 2015年4月30日 下午2:02:40
	 * @return
	 */
	public List<LocationConfig> selectAllCitys();

	/**
	 * 根据areaCode查询地区信息
	 *
	 * @param areaCode
	 * @return
	 */
	public LocationConfig queryLocationByAreaCode(String areaCode);

	public List<LocationConfig> selectProvince();

	public List<LocationConfig> selectProvinceList();

	public List<LocationConfig> getAreasByCompanyId(Long companyId);

	/**
	 * 根据名称获取对应的市的编码
	 * 
	 * @param params{provinceName:"";cityeName:""}
	 *            如果provinceName为空，索取全国的所有二级地市，如果不为null，获取该省份下的所有地市
	 *            如果cityeName不为空，则provinceName必须不为null，根据名称获取地市
	 * @return
	 */
	public List<String> getLocationsByName(Map<String, Object> params);
}
