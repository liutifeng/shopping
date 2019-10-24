package com.yc.controller;

import java.io.File;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yc.biz.IGoodBiz;
import com.yc.biz.ITypeBiz;
import com.yc.biz.impl.GoodBizImpl;
import com.yc.biz.impl.TypeBizImpl;
import com.yc.po.GoodPO;

import com.yc.po.TypeItemPO;
import com.yc.po.TypePO;

@Controller
@RequestMapping("/good")
public class GoodController {
@Autowired
private IGoodBiz gooodBizImpl;
@Autowired
private ITypeBiz TypeBizImpl;

@RequestMapping("/findByItem")
@ResponseBody
public List<GoodPO> findByItem(GoodPO po){
	List<GoodPO> list=new ArrayList<GoodPO>();
	list=gooodBizImpl.findByItem(po);
	
	return list;
}

@RequestMapping("/findByTno")
@ResponseBody
public List<TypePO> findByTno(TypeItemPO po){
	List<TypePO> list=new ArrayList<TypePO>();
	list=gooodBizImpl.findByTno(po);
	return list;
}

@RequestMapping("/addGood")
@ResponseBody
public  int  addGood(MultipartFile upload1[],HttpServletRequest request,GoodPO po) {
	
	String fpath=request.getSession().getServletContext().getRealPath("/");	
	System.out.println("fpath:"+fpath);
	String path=fpath+"../sp_imgs/";
	//System.out.println("path:"+path);
	File file=new File(path);
	if(!file.exists()) {
		file.mkdir();
	}
	//List<MultipartFile> list=new ArrayList<>();
	//list.add(upload1);
	//list.add(upload2);
	
	//System.out.println("po1:"+po.toString());
		//if(list!=null && list.size()>0) {
	int i=0;
	String name="";
	String filePath="";
	String fileName="";
	if(upload1!=null && upload1.length>0 &&upload1[0]!=null ) {
		System.out.println("-----------");
		for(MultipartFile upload:upload1 ) {
			//System.out.println("upload1:"+upload1);
			 name=upload.getOriginalFilename();
			 filePath=UUID.randomUUID().toString().replace("-", "")+name;
			 try {
				upload.transferTo(new File(path,filePath));
				fileName+=("../sp_imgs/"+filePath+",");
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		
	}
	System.out.println("fileName:"+fileName);
	po.setPics(fileName);
	System.out.println("po2:"+po.toString());
	 i=gooodBizImpl.add(po);
	
	return i;
	
}
	
@RequestMapping("/findByPage")
@ResponseBody
public List<GoodPO> findByPage(int page, int size, GoodPO po) {
	//System.out.println("page:"+page);
	//System.out.println("size:"+size);
	//System.out.println("po:"+po);
	List<GoodPO> list=new ArrayList<GoodPO>();
	list=gooodBizImpl.findByPage(page, size, po);
	
	return list;
}	


@RequestMapping("/findPageByTno")
@ResponseBody
public List<GoodPO> findPageByTno(int page, int size, TypeItemPO po) {

	List<GoodPO> list=new ArrayList<GoodPO>();
	list=gooodBizImpl.findPageByTno(page, size, po);
	
	return list;
}	


@RequestMapping("/goodsNum")
@ResponseBody
public int goodsNum(TypeItemPO po) {
	
	
	int i= gooodBizImpl.goodsNum(po);
	
	return i;
}



	
}



