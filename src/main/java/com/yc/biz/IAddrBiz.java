package com.yc.biz;

import java.util.List;

import com.yc.po.AddrPO;

public interface IAddrBiz {
	/**
	 * 添加地址
	 * @param bf
	 * @return
	 */
	public int add(AddrPO ap);
	
	/*
	 * 根据会员编号查询地址信息
	 */
	public List<AddrPO> findByMno(Integer mno);
	
//
//	/*
//	 * 修改地址信息
//	 */
//	public int updateAddr(AddrPO ap);
	
	

}
