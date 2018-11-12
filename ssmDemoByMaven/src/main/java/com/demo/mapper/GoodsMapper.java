package com.demo.mapper;

import java.util.List;

import com.demo.pojo.Goods;

public interface GoodsMapper {

	List<Goods> findAll();

	int deleteByPrimaryKey(Integer goodsId);

	int insert(Goods record);

	int insertSelective(Goods record);

	Goods selectByPrimaryKey(Integer goodsId);

	int updateByPrimaryKeySelective(Goods record);

	int updateByPrimaryKey(Goods record);
}