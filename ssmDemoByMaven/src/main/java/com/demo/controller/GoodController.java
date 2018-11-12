package com.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.demo.config.AlipayConfig;
import com.demo.mapper.GoodsMapper;
import com.demo.mapper.OrderDetailsMapper;
import com.demo.mapper.OrdersMapper;
import com.demo.pojo.Goods;
import com.demo.pojo.OrderDetails;
import com.demo.pojo.Orders;
import com.demo.service.GoodService;

@Controller
public class GoodController {

	@Autowired
	private GoodService goodService;

	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private OrdersMapper ordersMapper;

	@Autowired
	private OrderDetailsMapper orderDetailsMapper;

	@RequestMapping("alipayServlet")
	public String buyGoods(HttpServletRequest request, HttpServletResponse response) {
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);
		// 设置请求参数
		AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
		aliPayRequest.setReturnUrl(AlipayConfig.return_url);
		aliPayRequest.setNotifyUrl(AlipayConfig.notify_url);

		// 商户订单号，必填
		String order_number = new String(UUID.randomUUID().toString());
		// 付款金额，必填
		String total_amount = new String("10.00");
		// 订单名称，必填
		String subject = new String("简书");
		aliPayRequest.setBizContent("{\"out_trade_no\":\"" + order_number + "\"," + "\"total_amount\":\"" + total_amount
				+ "\"," + "\"subject\":\"" + subject + "\"," + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		// 请求
		String result = "没东西";
		try {
			result = alipayClient.pageExecute(aliPayRequest).getBody();
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		// 输出
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		return result;// 以下写自己的订单代码
	}

	@RequestMapping("createOrder")
	public String createOrder(String[] goodsId) {
		for (String integer2 : goodsId) {
			Integer integer = Integer.valueOf(integer2);
			Orders orders = new Orders();
			orders.setOrderAddress("订单地址");
			String orderId = UUID.randomUUID().toString().replace("-", "");
			orders.setOrderId(orderId);
			orders.setOrderPhone("1208820");
			orders.setOrderName("测试订单");
			orders.setOrderUser(8);
			ordersMapper.insert(orders);
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setDetailGoods(integer);
			orderDetails.setDetailNum(1);
			orderDetails.setDetailOrder(orderId);
			orderDetails.setDetailPrice(10f);
			orderDetailsMapper.insert(orderDetails);
		}
		return "redirect:toOrderList";

	}

	@RequestMapping("/toOrderList")
	public String toOrderList(Model model) {
		// 准备order数据
		model.addAttribute("orderList", orderDetailsMapper.findAll());
		return "orderList";
	}

	@RequestMapping("toCart")
	public String toCart(Model model) {
		return "cart";
	}

	@RequestMapping("addCart")
	@ResponseBody
	public String addCart(Integer goodsId, HttpSession session) {

		List<Goods> list = null;
		if (session.getAttribute("cart") == null) {
			list = new ArrayList<Goods>();
		} else {
			list = (List<Goods>) session.getAttribute("cart");
		}
		Goods g = goodService.findById(goodsId);
		list.add(g);
		session.setAttribute("cart", list);
		return "add Success";
	}

	@RequestMapping("/toGoodsList")
	public String toGoodsList(Model model) {
		List<Goods> list = goodService.findAll();
		model.addAttribute("goodsList", list);
		return "index";
	}

	@ResponseBody
	@RequestMapping("/goods/findGoodsByGoodsId")
	public Goods findGoodsByGoodsId(Integer goodsId) {
		Goods goods = goodService.findById(goodsId);
		return goods;
	}

}
