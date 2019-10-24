package com.yc.biz.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.biz.IMemberBiz;
import com.yc.dao.MemberMapper;
import com.yc.po.MemberPO;
import com.yc.util.StringUtil;
@Service
public class MemberBizImpl implements IMemberBiz{
	
	
	@Autowired
	MemberMapper mapper;
	
	@Override
	public MemberPO login(MemberPO mf) {
	 if(StringUtil.isNull(mf.getTel(),mf.getPwd())){
		
		 return null;
	 }
	 
 		return mapper.login(mf);
	}

	@Override
	public int add(MemberPO mf) {
		if(StringUtil.isNull(mf.getPwd(),mf.getTel())){
			return -1;
		}
		return mapper.add(mf);
	}

	@Override
	public int updateMember(MemberPO mf) {
		
		return mapper.updateMember(mf);
	}

	@Override
	public MemberPO findByMno(MemberPO mf) {
		if(StringUtil.isNull(mf.getPwd())){
			
			 return null;
		 }
		 
	 		return mapper.findByMno(mf);
		}

	


}
