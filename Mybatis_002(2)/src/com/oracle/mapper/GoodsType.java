package com.oracle.mapper;

import java.util.List;

public class GoodsType {
	private Integer typeId;
	private String typeName;
	private Integer typeLv;
	private Integer typePid;
	private String typePath;
	//关联对象的集合
	private List<Goods> goodsList;
	private List<Goods> goodsList2;
	
	
	
	public List<Goods> getGoodsList2() {
		return goodsList2;
	}
	public void setGoodsList2(List<Goods> goodsList2) {
		this.goodsList2 = goodsList2;
	}
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getTypeLv() {
		return typeLv;
	}
	public void setTypeLv(Integer typeLv) {
		this.typeLv = typeLv;
	}
	public Integer getTypePid() {
		return typePid;
	}
	public void setTypePid(Integer typePid) {
		this.typePid = typePid;
	}
	public String getTypePath() {
		return typePath;
	}
	public void setTypePath(String typePath) {
		this.typePath = typePath;
	}
	
	
}
