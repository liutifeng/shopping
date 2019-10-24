package com.yc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.yc.biz.impl.AliPayImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wk
 */
@Controller
@RequestMapping("/ali")
public class AliPay {
	@Autowired
	private AliPayImpl aliPay;

	/**
	 * 支付方法
	 * @param response
	 * @param count 金额
	 * @param id  订单号
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/pay")
	protected String pay(HttpServletResponse response,Double count,String id) throws IOException {
		System.out.println("count:"+count);
		System.out.println("id:"+id);
		return aliPay.pay(response,count,id);
}
}
