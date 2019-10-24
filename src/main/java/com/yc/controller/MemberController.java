package com.yc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.SocketUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.biz.IMemberBiz;
import com.yc.po.AddrPO;
import com.yc.po.MemberPO;


@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private IMemberBiz  biz;
	
	@RequestMapping("/login")
	@ResponseBody
	public int login(MemberPO  mf,HttpSession session){
		MemberPO  info = biz.login(mf);
		if(null!=info){
			session.setAttribute("member", info);
			return 1;
		}
		return 0;
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public int add(MemberPO mf){
		return biz.add(mf);
	}
	
	
	@RequestMapping("/checkLogin")
	@ResponseBody
	public MemberPO checkLogin(HttpSession session){
		MemberPO  info = (MemberPO) session.getAttribute("member");
		if(null!=info){
			
			return info;
		}
		return null;
	}
	
	@RequestMapping("/quit")
	@ResponseBody
	public int quit(HttpSession session){
		session.removeAttribute("member");
		MemberPO  info = (MemberPO) session.getAttribute("member");
		if(null!=info){
			
			return 0;
		}
		return 1;
	}
	
	
	
	

	@RequestMapping("/updateMember")
	@ResponseBody
	public int updateMember(MemberPO po,HttpSession session){
		MemberPO mf=(MemberPO) session.getAttribute("member");
		
		if(mf!=null){
			po.setMno(mf.getMno());
			//System.out.println(mf.getEmail());
			System.out.println(po.getMno()+"!!");
			
			return biz.updateMember(po);
			
		}
		return 0;
	}
	
	
	
	

		
	@RequestMapping("/findByMno")
	@ResponseBody
	public int findByMno(MemberPO  mf,HttpSession session){
		MemberPO po=(MemberPO) session.getAttribute("member");
		mf.setMno(po.getMno());
		MemberPO  info = biz.findByMno(mf);
		if(info!=null){
			
			System.out.println(info.getMno()+"!!");
			System.out.println(info.getMno()+"@@@");
			return 1;
		}
		return 0;
	
}

}
