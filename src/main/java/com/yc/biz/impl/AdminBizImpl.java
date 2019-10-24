package com.yc.biz.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.biz.IAdminBiz;
import com.yc.dao.AdminMapper;
import com.yc.po.AdminPO;
import com.yc.util.StringUtil;
/**
 * 后台管理员业务层实现
 * @author liu
 *
 */
@Service
public class AdminBizImpl implements IAdminBiz {

	@Autowired
	AdminMapper mapper;
	
	@Override
	public AdminPO login(AdminPO po) {
		if(StringUtil.isNull(po.getAname(),po.getPwd())){
			return null;
		}
		return mapper.login(po);
	}

	@Override
	public int add(AdminPO po) {
		if(StringUtil.isNull(po.getAname(),po.getPwd(),po.getTel())){
			return -1;
		}
		return mapper.add(po);
	}

	@Override
	public List<AdminPO> findAll() {
		return mapper.findAll();
	}

	@Override
	public int updatePwd(Integer aid) {
		if(null==aid){
			return -1;
		}
		return mapper.updatePwd(aid);
	}

	@Override
	public List<AdminPO> findAdmin(String adminname) {
		return mapper.findAdmin(adminname);
	}

	@Override
	public int updateStatus(AdminPO po) {
		if(po.getStatus()==1){
			po.setStatus(0);
		}else{
			po.setStatus(1);
		}
		return mapper.updateStatus(po);
	}

	@Override
	public List<AdminPO> findByPage(int page, int size) {
		return mapper.findByPage(page, size);
	}

	@Override
	public int totalPage() {
		return mapper.totalPage();
	}

}
