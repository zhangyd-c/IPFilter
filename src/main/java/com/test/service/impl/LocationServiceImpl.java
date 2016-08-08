package com.test.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.ILocationDao;
import com.test.entity.LocationConfig;
import com.test.service.ILocationService;

/**
 * @author (作者) zhangyd-c 2015年7月31日 下午6:05:16
 * @version (版本) V1.0
 * @since (该版本支持的JDK版本) ： 1.7
 */
@Service
public class LocationServiceImpl implements ILocationService {

	@Autowired
	private ILocationDao locationDao;

	/**
	 * 查询地区列表
	 * 
	 * @param parentAreaCode
	 * @return
	 */
	@Override
	public List<LocationConfig> queryListByParentAreaCode(String parentAreaCode) {
		return locationDao.selectListByParentAreaCode(parentAreaCode);
	}

	@Override
	public List<LocationConfig> getAllLocation(@SuppressWarnings("rawtypes") Map map) {
		return locationDao.selectAllLocationPage(map);
	}

	/**
	 * 
	 * @Description 获得所有的省
	 * @author zhangyd-c
	 * @date 2015年4月30日 下午2:01:34
	 * @return
	 */
	@Override
	public List<LocationConfig> selectAllProvinces() {
		return locationDao.selectAllProvinces();
	}

	/**
	 * 
	 * @Description 获得所有的市
	 * @author zhangyd-c
	 * @date 2015年4月30日 下午2:02:40
	 * @return
	 */
	@Override
	public List<LocationConfig> selectAllCitys() {
		return locationDao.selectAllCitys();
	}

	/**
	 * 根据areaCode查询地区信息
	 *
	 * @param areaCode
	 * @return
	 */
	@Override
	public LocationConfig queryLocationByAreaCode(String areaCode) {
		return locationDao.selectByPrimaryKey(areaCode);
	}

	@Override
	public List<LocationConfig> selectProvince() {
		return locationDao.selectProvince();
	}

	@Override
	public List<LocationConfig> selectProvinceList() {
		return locationDao.selectProvinceList();
	}

	@Override
	public List<LocationConfig> getAreasByCompanyId(Long companyId) {
		return locationDao.getAreasByCompanyId(companyId);
	}

	/**
	 * 根据名称获取对应的市的编码
	 * 
	 * @param params{provinceName:"";cityeName:""}
	 *            如果provinceName为空，索取全国的所有二级地市，如果不为null，获取该省份下的所有地市
	 *            如果cityeName不为空，则provinceName必须不为null，根据名称获取地市
	 * @return
	 */
	@Override
	public List<String> getLocationsByName(Map<String, Object> params) {
		return locationDao.selectLocationsByName(params);
	}
}
