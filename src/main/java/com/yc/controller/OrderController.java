package com.yc.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.biz.IGoodBiz;
import com.yc.biz.IOrderBiz;
import com.yc.po.GoodPO;
import com.yc.po.MemberPO;
import com.yc.po.OrderItemPO;
import com.yc.po.OrderPO;
import com.yc.util.JsonUtil;
import com.yc.vo.OrderVO;

@Controller
@RequestMapping("/orderItem")
public class OrderController {
	@Autowired
	private IOrderBiz orderImp;
	@Autowired
	private IGoodBiz goodImp;
@RequestMapping("/addItem")
@ResponseBody

public int addItem(OrderItemPO po,HttpSession session) {
		MemberPO mpo=(MemberPO) session.getAttribute("member");
		if(mpo!=null ) {
			po.setReserve(mpo.getMno());
			po.setStatus(1);
		//	System.out.println(po);
			return orderImp.addItem(po);
		}
		
		
	return 0;
	}

@RequestMapping("/findByMon")
@ResponseBody
@Transactional
public List<OrderItemPO>findByMon(@RequestBody List<OrderItemPO>cars,HttpSession session){
	//System.out.println("list:"+cars.get(0).getGno());
	MemberPO mpo=(MemberPO) session.getAttribute("member");
	int mno=mpo.getMno();
	for(OrderItemPO po:cars) {
		po.setReserve(mno);
		po.setStatus(1);
		orderImp.addItem(po);
	}
	
	
	return orderImp.findByReserve(mpo.getMno());
	
}


@RequestMapping("/showByMno")
@ResponseBody
public List<OrderItemPO>showByMno(HttpSession session){
	MemberPO mpo=(MemberPO) session.getAttribute("member");
	//System.out.println("list:"+orderImp.findByReserve(mpo.getMno()));
	return orderImp.findByReserve(mpo.getMno());
	
}

@RequestMapping("/UpdateOrderItem")
@ResponseBody
public int UpdateOrderItem(OrderItemPO po,HttpSession session){
	MemberPO mpo=(MemberPO) session.getAttribute("member");
	po.setReserve(mpo.getMno());
	return orderImp.update(po);
	
}

@RequestMapping("/delOrderItem")
@ResponseBody
public int delOrderItem(@RequestBody OrderItemPO po,HttpSession session){
	MemberPO mpo=(MemberPO) session.getAttribute("member");
	po.setReserve(mpo.getMno());
	//System.out.println("po:"+po);
	return orderImp.delOrderItem(po);
	
}

@RequestMapping("/insertOrder")
@ResponseBody
@Transactional
public int insertOrder(@RequestBody List<OrderItemPO> cars, HttpSession session){
	//System.out.println("products:"+products);
	MemberPO mpo=(MemberPO) session.getAttribute("member");
	//System.out.println("cars:"+cars);
for(OrderItemPO po:cars) {
	po.setReserve(mpo.getMno());	
	orderImp.delOrderItem(po);
	po.setStatus(2);
	
}
	return orderImp.AddByTremForEach(cars);
	
	
	
}

@RequestMapping("/addOrder")
@ResponseBody
public int addOrder(OrderPO po, HttpSession session){

MemberPO mpo=(MemberPO) session.getAttribute("member");
if(mpo!=null) {
	po.setMno(mpo.getMno());
	//System.out.println("po:"+po);
	  return orderImp.addOrder(po);
}
return 0;

}

@RequestMapping("/updateOrder")
@ResponseBody
public int updateOrder(String ono) {
	System.out.println("ono:"+ono);
	return orderImp.updateOrder(ono);
}
@RequestMapping("/findOrder")
@ResponseBody
public List<OrderVO> findOrder(OrderPO po,HttpSession session){
	//System.out.println("po:"+po);
	MemberPO mpo=(MemberPO) session.getAttribute("member");
	if(mpo!=null) {
		po.setMno(mpo.getMno());
		System.out.println("list:"+orderImp.findOrder(po));
		return orderImp.findOrder(po);
	}
	return null;
	
}


@RequestMapping("/delOrder")
@ResponseBody
//删除order,根据ono
public int delOrder(String ono) {
	
	return orderImp.delOrder(ono);
}
}
