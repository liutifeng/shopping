

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.biz.IAddrBiz;
import com.yc.po.AddrPO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:applicationContext.xml"})
public class AddrBizTest {
	
	@Autowired
	IAddrBiz  addrBiz;
	
	@Test
	public void testAdd() {
		AddrPO ap = new AddrPO();
		ap.setMno(1);
		ap.setName("aaa");
		ap.setTel("17822557867");
		ap.setProvince("湖南省");
		ap.setCity("长沙市");
		ap.setArea("芙蓉区区");
		ap.setAddr("解放路");
		System.out.println(addrBiz.add(ap));
	}
	
	@Test
	public void testFindByMno() {
		
		System.out.println(addrBiz.findByMno(1));
	}


}
