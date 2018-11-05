package com.oracle.mapper;

import java.util.Date;

public class Goods {
	private Integer goodsId;
	private String goodsName;
	private Float goodsPrice;
	private Integer goodsNum;
	private Integer goodsType;//类型的id
	private GoodsType type1;//关联对象--维护多对一的关系
	private GoodsType type2;//关联对象--维护多对一的关系
	private GoodsType type3;//关联对象--维护多对一的关系
	private Date goodsDate;
	
	
	
	
	
	public GoodsType getType3() {
		return type3;
	}
	public void setType3(GoodsType type3) {
		this.type3 = type3;
	}
	public GoodsType getType2() {
		return type2;
	}
	public void setType2(GoodsType type2) {
		this.type2 = type2;
	}
	public GoodsType getType1() {
		return type1;
	}
	public void setType1(GoodsType type1) {
		this.type1 = type1;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	public Integer getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}
	public Date getGoodsDate() {
		return goodsDate;
	}
	public void setGoodsDate(Date goodsDate) {
		this.goodsDate = goodsDate;
	}
	
	
}
