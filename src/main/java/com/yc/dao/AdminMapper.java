package com.yc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.po.AdminPO;

public interface AdminMapper {

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
	public List<AdminPO> findByPage(@Param("page")int page,@Param("size")int size);
	
	/**
	 * 分页查询总条数
	 * @param po
	 * @return
	 */
	public int totalPage();
}
