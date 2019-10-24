package shopping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.biz.IAdminBiz;
import com.yc.po.AdminPO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:applicationContext.xml"})
public class AdminBizTest {

	@Autowired
	IAdminBiz adminBiz;
	
	@Test
	public void testLogin() {
		AdminPO po = new AdminPO();
		po.setAname("张三");
		po.setPwd("582547");
		System.out.println(adminBiz.login(po));
	}

	@Test
	public void testAdd() {
		AdminPO po = new AdminPO();
		po.setAname("admin");
		po.setPwd("a");
		po.setTel("17347013442");
		System.out.println(adminBiz.add(po));
	}

	@Test
	public void testFindAll() {
		System.out.println(adminBiz.findAll());
	}

	@Test
	public void testUpdatePwd() {//2
		System.out.println(adminBiz.updatePwd(2));
	}

	@Test
	public void testFindAdmin() {
		System.out.println(adminBiz.findAdmin("b"));
	}
	
	@Test
	public void testUpdateStatus() {
		AdminPO po = new AdminPO();
		po.setAid(2);
		po.setStatus(0);
		System.out.println(adminBiz.updateStatus(po));
	}
	
	@Test
	public void testFindByPage() {
		System.out.println(adminBiz.findByPage(1,2));
	}
	
	@Test
	public void testTotalPage() {
		System.out.println(adminBiz.totalPage());
	}
}
