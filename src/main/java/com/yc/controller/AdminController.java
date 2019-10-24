package com.yc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.biz.IAdminBiz;
import com.yc.po.AdminPO;

@Controller
@RequestMapping("/back")
public class AdminController {

	@Autowired
	private IAdminBiz biz;
	
	@RequestMapping("/login")
	@ResponseBody
	public int login(AdminPO po,HttpSession session){
		AdminPO info = biz.login(po);
		if(null!=info){
			session.setAttribute("admin", info);
			return 1;
		}
		return 0;
	}
	
	@RequestMapping("/admin/findAll")
	@ResponseBody
	public List<AdminPO> findAll(){
		return biz.findAll();
	}
	@RequestMapping("/admin/findAdmin")
	@ResponseBody
	public List<AdminPO> findAdmin(String adminname){
		
		return biz.findAdmin(adminname);
	}
	
	@RequestMapping("/admin/add")
	@ResponseBody
	public int add(AdminPO po){
		return biz.add(po);
	}
	
	@RequestMapping("/admin/update")
	@ResponseBody
	public int update(int aid){
		return biz.updatePwd(aid);
	}
	
	@RequestMapping("/admin/updateSta")
	@ResponseBody
	public int updateSta(AdminPO po){
		return biz.updateStatus(po);
	}
	
	@RequestMapping("/admin/findByPage")
	@ResponseBody
	public List<AdminPO> findByPage(int page,int size){
		return biz.findByPage(page, size);
	}
	
	@RequestMapping("/admin/totalPage")
	@ResponseBody
	public int totalPage(){
		return biz.totalPage();
	}
	
	// op
	@RequestMapping("/manager")
	public String loginSuccess(){
		return "index";
	}
}