package com.yc.biz;

import com.yc.po.MemberPO;

public interface IMemberBiz {
	/**
	 * 登录
	 * @param mf
	 * @return
	 */
	public MemberPO login(MemberPO mf);
	
	/**
	 * 注册
	 * @param mf
	 * @return
	 */
	public int add(MemberPO mf);
	
	/*
	 * 修改个人信息
	 */
	public int updateMember(MemberPO mf);

	/*
	 * 根据mno、密码查询
	 */
	public MemberPO findByMno(MemberPO mf);
	
	
	
	

}
