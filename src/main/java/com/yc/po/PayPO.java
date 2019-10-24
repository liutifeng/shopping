package com.yc.po;

import java.io.Serializable;

public class PayPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1531516477011917431L;
	private Integer pno ;// 支付方式编号
	private String pname ;// 支付方式名称
	private String url ;// 接口地址
	private Integer status ;// 状态
	public Integer getPno() {
		return pno;
	}
	public void setPno(Integer pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PayPO [pno=" + pno + ", pname=" + pname + ", url=" + url + ", status=" + status + "]";
	}
	
	
}
