package shopping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.biz.IMemberBiz;
import com.yc.po.MemberPO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:applicationContext.xml"})
public class MemberBizTest {
	
	
	@Autowired
	IMemberBiz  memberBiz;

	@Test
	public void testLogin() {
		MemberPO mf = new MemberPO();
		mf.setTel("17347013442");
		mf.setPwd("a");
		System.out.println(memberBiz.login(mf));
	}
	
	@Test
	public void testAdd() {
		MemberPO mf = new MemberPO();
		mf.setTel("13786068599");
		mf.setPwd("a");
		System.out.println(memberBiz.add(mf));
	}

}
