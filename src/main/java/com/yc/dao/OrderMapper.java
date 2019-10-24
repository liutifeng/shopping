package com.yc.dao;

import java.util.List;

import com.yc.po.OrderItemPO;
import com.yc.po.OrderPO;
import com.yc.vo.OrderVO;


public interface OrderMapper {

	//点击加入购物车后生成一条orderitem记录
	public int addItem(OrderItemPO po);
	
	//查询订单
	public List<OrderItemPO>findByItem(OrderItemPO po);
	
	
	
	
	//订单存在,更新数量
			public int update(OrderItemPO po);
			
			//根据条件查询单条订单,判断订单是否存在
			public OrderItemPO findSingleByItem(OrderItemPO po);
			//根据reserve(用户id)查询orderItem
			public List<OrderItemPO> findByReserve(Integer reserve);
			
			//删除记录
			public int delOrderItem(OrderItemPO po);
			//调价订单order
			public int addOrder(OrderPO po);
			//添加订单order集合
			public int AddByTremForEach(List<OrderItemPO> list);
			
			//付款成功更新订单order
			public int updateOrder(String ono);
			
			
			//根据条件查询所有订单
			public List<OrderVO>findOrder(OrderPO po);
			
			
			//删除order,根据ono
			public int delOrder(String ono);
			
			//删除order对应的orderItem
			public int delItemByOno(String ono);
			
			
}
