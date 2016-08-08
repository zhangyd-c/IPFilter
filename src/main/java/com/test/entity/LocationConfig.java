package com.test.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Description
 * @author (作者) zhangyd-c 2015年7月31日 下午6:02:25
 * @version (版本) V1.0
 * @since (该版本支持的JDK版本) ： 1.7
 */
public class LocationConfig {
	private String areaCode;

	private String name;

	// 没用
	private Long sort;

	// 没用
	private String remark;

	// 简称
	private String abbreviation;

	// 创建时间
	private Timestamp createdAt;

	// 更新时间
	private Timestamp updatedAt;

	// / 父id
	private String parentAreaCode;

	// 没用
	private Boolean containInfoPrice;

	// 大区
	private String area;

	// 不管
	private Boolean searchable;

	// 不管
	// 以下字段与数据库不对应

	// 非表字段
	private List<LocationConfig> childList = new ArrayList<LocationConfig>();

	private String parentAreaName;

	private List<LocationConfig> childs;

	public List<LocationConfig> getChilds() {
		return childs;
	}

	public void setChilds(List<LocationConfig> childs) {
		this.childs = childs;
	}

	public String getParentAreaName() {
		return parentAreaName;
	}

	public void setParentAreaName(String parentAreaName) {
		this.parentAreaName = parentAreaName;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getParentAreaCode() {
		return parentAreaCode;
	}

	public void setParentAreaCode(String parentAreaCode) {
		this.parentAreaCode = parentAreaCode;
	}

	public Boolean getContainInfoPrice() {
		return containInfoPrice;
	}

	public void setContainInfoPrice(Boolean containInfoPrice) {
		this.containInfoPrice = containInfoPrice;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Boolean getSearchable() {
		return searchable;
	}

	public void setSearchable(Boolean searchable) {
		this.searchable = searchable;
	}

	public List<LocationConfig> getChildList() {
		return childList;
	}

	public void setChildList(List<LocationConfig> childList) {
		this.childList = childList;
	}

}