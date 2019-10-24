package com.yc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.biz.IOrderBiz;
import com.yc.dao.OrderMapper;
import com.yc.po.OrderItemPO;
import com.yc.po.OrderPO;
import com.yc.vo.OrderVO;
@Service()
public class OrderBizImpl implements IOrderBiz {
@Autowired
private OrderMapper mapper;
//@Autowired
//private HashOperations<String, String, Object> hTemlate;
//添加进mysql

	@Override
	public int addItem(OrderItemPO po) {
		OrderItemPO tpo=new OrderItemPO();
		tpo.setReserve(po.getReserve());
		tpo.setStatus(1);
		tpo.setGno(po.getGno());
		OrderItemPO opo=mapper.findSingleByItem(tpo);
		//System.out.println("opo:"+opo);
		if(opo!=null) {
			int num=po.getNum()+opo.getNum();
			System.out.println("po:"+po.getNum()+"opo:"+opo.getNum()+"num:"+num);
			po.setNum(num);
			return mapper.update(po);
		}
		
		return mapper.addItem(po);
	}
	
	
	
	//登录状态在redis中添加购物车订单订单
//public int addInRedis(OrderItemPO po) {
	
	
	//return 0;
//}



@Override
public List<OrderItemPO> findByItem(OrderItemPO po) {
	List<OrderItemPO> list=mapper.findByItem(po);
	if(list!=null) {
		return list;
	}
	return null;
}



@Override
public List<OrderItemPO> findByMon() {
	
	return null;
}



@Override
public int update(OrderItemPO po) {
	
	return mapper.update(po);
}






@Override
public List<OrderItemPO> findByReserve(Integer reserve) {
	List<OrderItemPO> list=mapper.findByReserve(reserve);
	if(list !=null) {
		return list;
	}
	return null;
}



@Override
public int delOrderItem(OrderItemPO po) {
	// TODO Auto-generated method stub
	return mapper.delOrderItem(po);
}

//添加订单order
public int addOrder(OrderPO po) {
	return mapper.addOrder(po);
}



@Override
public int addOrderItem(OrderItemPO po) {
	// TODO Auto-generated method stub
	return mapper.addItem(po);
}



@Override
public int AddByTremForEach(List<OrderItemPO> list) {
	
	return mapper.AddByTremForEach(list);
}



@Override
public int updateOrder(String ono) {
	
	return mapper.updateOrder(ono);
}



@Override
public List<OrderVO> findOrder(OrderPO po) {
	List<OrderVO> list=mapper.findOrder(po);
	if(list!=null) {
		return list;
	}
	return null;
}



@Override

public int delOrder(String ono) {
	mapper.delItemByOno(ono);
	return mapper.delOrder(ono);
}



@Override
public int addToOrder(OrderItemPO po) {
	// TODO Auto-generated method stub
	return 0;
}






}
