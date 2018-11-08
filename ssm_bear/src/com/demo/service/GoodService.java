package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.annotations.MyAnnotation;
import com.demo.mapper.GoodsMapper;
import com.demo.pojo.Goods;

@Service
public class GoodService {

	@Autowired
	private GoodsMapper goodsMapper;

	@MyAnnotation(desc = "这是测试")
	public Goods findById(Integer goodsId) {
		Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
		return goods;
	}
}
