package com.yc.biz.impl;

import com.alipay.api.AlipayApiException;


import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.yc.util.AlipayConfig;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wk
 * @date 2019/9/29  15:05
 */
@Service
public class AliPayImpl {

    public String pay(HttpServletResponse response, Double count, String id) throws IOException {
        //获得初始化的AlipayClient
    	//System.out.println("jinru!!!!!!!!");
    	//System.out.println("count:"+count);
    	//System.out.println("id:"+id);
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,
                AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json",
                AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = id;
        //付款金额，必填
        String total_amount = count.toString();
        //订单名称，必填
        String subject = "支付宝测试";
        //商品描述，可空
        String body = "商品描述";

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
            response.setContentType("text/html;charset=" + AlipayConfig.charset);
            //直接将完整的表单html输出到页面
           // System.out.println("result:"+result);
            response.getWriter().write(result);
            response.getWriter().flush();
            response.getWriter().close();

        } catch (AlipayApiException e) {
            e.printStackTrace();
            response.getWriter().write("捕获异常出错");
            response.getWriter().flush();
            response.getWriter().close();
            
        }
        return null;
        //System.out.println("null!!!!!!!!!!!!");
       
    }
}
