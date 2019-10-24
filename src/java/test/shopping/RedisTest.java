package shopping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.print.attribute.HashAttributeSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.biz.IMemberBiz;
import com.yc.po.MemberPO;
import com.yc.po.OrderItemPO;
import com.yc.po.OrderPO;
import com.yc.util.JsonUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RedisTest {
@Autowired
private RedisTemplate template;

private HashOperations<String, String, Object> htemplate;
@Autowired
private IMemberBiz memberImpl;



@Test
public void TestList() {
	List<String>list1=new ArrayList<String>();
	list1.add("aaa");
	list1.add("bbb");
	list1.add("ccc");
	list1.add("ddd");
	template.opsForList().rightPopAndLeftPush(list1, list1);
	//template.opsForList().getOperations().delete("list1");
	System.out.println(template.opsForList().rightPopAndLeftPush(list1, list1));
	JedisPool poo=new JedisPool();
	Jedis jedis=poo.getResource();
	jedis.lpush("user", "aaa","bbb","ccc");
	System.out.println(jedis.lrange("user", 0, -1));
	template.opsForList().leftPush("list", list1);
	System.out.println("aa:"+template.opsForList().range("list", 0, -1));
	
	
}

@Test
public void TestAdd() 
{
	
	Set<String> set1=new HashSet<>();
	set1.add("111");
	set1.add("222");
	set1.add("333");
	set1.add("444");
	template.opsForValue().set("set1", set1);
	System.out.println(template.hasKey("set1"));
	System.out.println(template.opsForValue().get("set1"));
	
}

@Test
public void TestObj() {
	MemberPO po=new MemberPO();
	po.setTel("17347013442");
	po.setPwd("a");
	MemberPO po1=new MemberPO();
	po=memberImpl.login(po);
	String key="member:"+po.getMno();
	Map<String, Object>map=new HashMap<String, Object>();
	map.put("memberPO:", po);
	//template.opsForHash().put("member", po.getMno(), po);
	if(template.hasKey(key)) {
		System.out.println("aaa");
		po.setNickname("hahah");
		map.put(key, po);
		//System.out.println("po:"+po);
		template.opsForHash().putAll(key, map);
		System.out.println(template.opsForHash().entries(key));
	}else {
		template.opsForHash().putAll(key, map);
		System.out.println(template.opsForHash().entries(key));
	}
	
}

@Test
public void TestPut() {
	String key="orderMenber";
	int id=1;
OrderItemPO po=new OrderItemPO();
po.setGno(6);
//template.opsForHash().put(key+id, po.getGno().toString(), JsonUtil.serialize(po));
template.opsForHash().put(key+id, "1", po);
}
@Test
public void TestGet() {
	String key="orderMenber";
	String id="5";
	OrderItemPO po=JsonUtil.parse(template.opsForHash().get(key+1, id).toString(), OrderItemPO.class) ;
	System.out.println(po.getGno());
}

@Test
public void TestGetList() {
	String key="orderMenber";

	List<Object> list=template.opsForHash().values(key+1);
	List<OrderItemPO>list2=list.stream().map(orderJson->JsonUtil.parse(orderJson.toString(), OrderItemPO.class)).collect(Collectors.toList());
	for(OrderItemPO po:list2) {
		System.out.println(po);
	}
}

}
