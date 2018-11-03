package com.demo.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * GoodsType entity. @author MyEclipse Persistence Tools
 */

public class GoodsType implements java.io.Serializable {

	// Fields

	private Integer typeId;
	private GoodsType goodsType;
	private String typeName;
	private Integer typeLv;
	private String typePath;
	private Set goodsTypes = new HashSet(0);

	// Constructors

	/** default constructor */
	public GoodsType() {
	}

	/** full constructor */
	public GoodsType(GoodsType goodsType, String typeName, Integer typeLv, String typePath, Set goodsTypes) {
		this.goodsType = goodsType;
		this.typeName = typeName;
		this.typeLv = typeLv;
		this.typePath = typePath;
		this.goodsTypes = goodsTypes;
	}

	// Property accessors

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public GoodsType getGoodsType() {
		return this.goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getTypeLv() {
		return this.typeLv;
	}

	public void setTypeLv(Integer typeLv) {
		this.typeLv = typeLv;
	}

	public String getTypePath() {
		return this.typePath;
	}

	public void setTypePath(String typePath) {
		this.typePath = typePath;
	}

	public Set getGoodsTypes() {
		return this.goodsTypes;
	}

	public void setGoodsTypes(Set goodsTypes) {
		this.goodsTypes = goodsTypes;
	}

}