package com.test.entity;

import java.io.Serializable;

/**
 * @author (作者) zhangyd-c 2015年7月31日 下午6:02:11
 * @version (版本) V1.0
 * @since (该版本支持的JDK版本) ： 1.7
 */
public class DictionaryConfig implements Serializable {

	/** @Fields serialVersionUID: */

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String code;

	private String typeName;

	private String typeCode;

	private Boolean isUsing;

	public DictionaryConfig(Long id, String name, String code, String typeName, String typeCode, Boolean isUsing) {
		super();
		this.code = code;
		this.typeCode = typeCode;
		this.isUsing = isUsing;
	}

	public DictionaryConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public Boolean getIsUsing() {
		return isUsing;
	}

	public void setIsUsing(Boolean isUsing) {
		this.isUsing = isUsing;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DictionaryConfig)) {
			return false;
		}
		/*
		 * if(this.getClass()!=obj.getClass()){ return false; }
		 */
		final DictionaryConfig d = (DictionaryConfig) obj;
		if (this.code.trim().equals(d.getCode().trim()) && this.typeCode.trim().equals(d.getTypeCode().trim())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = result * 31 + this.code.hashCode();
		result = result * 31 + this.typeCode.hashCode();
		return result;
	}

}