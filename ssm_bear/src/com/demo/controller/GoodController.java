package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.exceptions.GoodsException;
import com.demo.pojo.Goods;
import com.demo.service.GoodService;

@Controller
public class GoodController {

	@Autowired
	private GoodService goodService;

	@ResponseBody
	@RequestMapping("/goods/findGoodsByGoodsId")
	public Goods findGoodsByGoodsId(Integer goodsId) {
		if (goodsId == 1) {
			throw new GoodsException("这是商品错误信息");
		}
		Goods goods = goodService.findById(goodsId);
		return goods;
	}

}
