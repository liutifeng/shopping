package shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.biz.IOrderBiz;
import com.yc.biz.impl.OrderBizImpl;
import com.yc.dao.OrderMapper;
import com.yc.po.OrderItemPO;
import com.yc.po.OrderPO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:applicationContext.xml"})
public class OrderMapperTest {
	@Autowired
private OrderBizImpl orderImpl;
	
@Test
public void TestAdd() {
	OrderItemPO po=new OrderItemPO();
	po.setGno(21);
	po.setNum(1);
	po.setReserve(1);
	System.out.println(orderImpl.addItem(po));
}
@Test
public void TestFind() {
	OrderItemPO po=new OrderItemPO();
	po.setGno(21);	
	po.setReserve(1);
	System.out.println(orderImpl.findByItem(po));
}
@Test
public void TestUpdate() {
	
	OrderItemPO po=new OrderItemPO();
	po.setGno(17);	
	po.setReserve(1);
	po.setNum(3);
	System.out.println(orderImpl.update(po));
}

@Test
public void addOrder() {
	OrderPO po=new OrderPO();
	String ono=""+System.currentTimeMillis()+Math.random() * 100 + 1;
	po.setOno(ono);
	po.setMno(1);
	System.out.println(orderImpl.addOrder(po));
}


@Test
public void AddByTremForEach() {
	OrderItemPO po1=new OrderItemPO();
	po1.setGno(17);	
	po1.setReserve(1);
	po1.setNum(3);
	po1.setStatus(2);
	OrderItemPO po2=new OrderItemPO();
	po2.setGno(15);	
	po2.setReserve(1);
	po2.setNum(1);
	po2.setStatus(2);
	OrderItemPO po3=new OrderItemPO();
	po3.setGno(24);	
	po3.setReserve(1);
	po3.setNum(2);
	po3.setStatus(2);
	List<OrderItemPO>list=new ArrayList<>();
	list.add(po1);
	list.add(po2);
	list.add(po3);
	System.out.println(orderImpl.AddByTremForEach(list));
	


}

@Test
public void TestUpdateOrder() {
	String ono="31e4157009401178393226";
	System.out.println(orderImpl.updateOrder(ono));
	
}
@Test
public void TestFindOrder() {
	OrderPO po=new OrderPO();
	po.setMno(1);
	System.out.println(orderImpl.findOrder(po));
	
}
@Test
public void findOrder() {
	OrderPO po=new OrderPO();
	po.setMno(1);
	po.setStatus(2);
	System.out.println(orderImpl.findOrder(po));
}

@Test
public void DelOrder() {
	String ono="71c3157011498178155391";
	
	System.out.println(orderImpl.delOrder(ono));
}
}
