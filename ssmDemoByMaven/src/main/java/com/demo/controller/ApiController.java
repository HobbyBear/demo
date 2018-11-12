package com.demo.controller;

import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.demo.config.AlipayConfig;

@Controller
@RequestMapping("/aliPay")
public class ApiController {

	@RequestMapping("/open")
	public ResponseEntity<HttpEntity> open(Model model, String WIDout_trade_no, String WIDsubject, String WIDtotal_fee,
			String WIDbody) {

		//////////////////////////////////// 请求参数//////////////////////////////////////

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
		model.addAttribute("sHtmlText", result);
		return new ResponseEntity(model, HttpStatus.OK);
	}
}
