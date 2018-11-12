package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.GoodsMapper;
import com.demo.pojo.Goods;

@Service
public class GoodService {

	@Autowired
	private GoodsMapper goodsMapper;

	public Goods findById(Integer goodsId) {
		Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
		return goods;
	}

	public List<Goods> findAll() {
		return goodsMapper.findAll();
	}

}
