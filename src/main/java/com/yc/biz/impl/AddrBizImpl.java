package com.yc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.biz.IAddrBiz;
import com.yc.dao.AddrMapper;
import com.yc.po.AddrPO;
import com.yc.util.StringUtil;
@Service
public class AddrBizImpl implements IAddrBiz{
	@Autowired
	AddrMapper mapper;

	@Override
	public int add(AddrPO ap) {
		if(StringUtil.isNull(ap.getName(),ap.getTel(),ap.getProvince(),ap.getCity(),ap.getArea(),ap.getAddr())){
			return -1;
		}
		return mapper.add(ap);
	}

	@Override
	public List<AddrPO> findByMno(Integer mno) {
		// TODO Auto-generated method stub
		return mapper.findByMno(mno);
	}

//	@Override
//	public int updateAddr(AddrPO ap) {
//		if(StringUtil.isNull(ap.getName(),ap.getTel(),ap.getProvince(),ap.getCity(),ap.getArea(),ap.getAddr())){
//			return -1;
//		}
//		return mapper.updateAddr(ap);
//	}
	
	

	
	

}
