package com.yc.biz;

import java.util.List;

import com.yc.po.AdminPO;
/**
 * 管理员业务层接口
 * @author liu
 *
 */
public interface IAdminBiz {

	/**
	 * 后台管理员登录
	 * @param af
	 * @return
	 */
	public AdminPO login(AdminPO po);
	
	/**
	 * 添加后台管理信息
	 * @param af
	 * @return
	 */
	public int add(AdminPO po);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<AdminPO> findAll();
	
	/**
	 * 模糊查询
	 * @return
	 */
	public List<AdminPO> findAdmin(String adminname);
	
	/**
	 * 重置密码
	 * @param aid
	 * @return
	 */
	public int updatePwd(Integer aid);
	
	/**
	 * 修改状态
	 * @param status
	 * @return
	 */
	public int updateStatus(AdminPO po);
	
	/**
	 * 分页查询
	 * @param po
	 * @param page
	 * @param row
	 * @return
	 */
	public List<AdminPO> findByPage(int page,int size);
	
	/**
	 * 分页查询总条数
	 * @param po
	 * @return
	 */
	public int totalPage();
}
