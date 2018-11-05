package com.oracle.vo;

import com.oracle.mapper.Users;

public class SearchVO {
	private Integer maxNum;
	private Float maxPrice;
	private Integer minNum;
	private Float minPrice;
	private Integer type;
	private String name;
	public Integer getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}
	public Float getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Float maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Integer getMinNum() {
		return minNum;
	}
	public void setMinNum(Integer minNum) {
		this.minNum = minNum;
	}
	public Float getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Float minPrice) {
		this.minPrice = minPrice;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
