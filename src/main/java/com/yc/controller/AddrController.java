package com.yc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.biz.IAddrBiz;
import com.yc.po.AddrPO;
import com.yc.po.MemberPO;


@Controller
@RequestMapping("/addr")
public class AddrController {
	
	@Autowired
	private IAddrBiz  biz;
	
	@RequestMapping("/addAddr")
	@ResponseBody
	public int add(AddrPO ap,HttpSession session){
		
		MemberPO po=(MemberPO) session.getAttribute("member");
		ap.setMno(po.getMno());
		if(po!=null){
			
			System.out.println(ap.getMno()+"!!");
		return biz.add(ap);
		}
		return 0;
	}

//	public int findByMno(MemberPO  mf,HttpSession session){
//		MemberPO po=(MemberPO) session.getAttribute("member");
//		mf.setMno(po.getMno());
//		MemberPO  info = biz.findByMno(mf);
//		if(info!=null){
//			
//			System.out.println(info.getMno()+"!!");
//			System.out.println(info.getMno()+"@@@");
//			return 1;
//		}
//		return 0;
//	
//}
	
	
	
	@RequestMapping("/findByMno")
	@ResponseBody
	public List<AddrPO> findByMno(HttpSession session){
		MemberPO po=(MemberPO) session.getAttribute("member");
		if(po!=null){
			
			System.out.println(po.getMno()+"!!");
			return biz.findByMno(po.getMno());
		}
		return null;
	}
	
	
//	@RequestMapping("/updateAddr")
//	@ResponseBody
//	public int updateAddr(AddrPO ap){
//		return biz.updateAddr(ap);
//	}
	

	
	

}
