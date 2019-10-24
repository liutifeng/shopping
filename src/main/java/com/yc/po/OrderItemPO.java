package com.yc.po;

import java.io.Serializable;

public class OrderItemPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 944863512222004856L;
	private Integer oino ;// 订单详细编号
	private String ono ;// 所属订单
	private Integer gno ;// 商品编号
	private String gname ;// 商品名
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	private Integer num ;// 购买数量
	private Double price ;// 购买单价
	private Integer status ;// 状态: 1:加入购物车,2:添加到大订单列表(立即购买,购物车支付)
	private String spare ;// 备用字段(图片)
	private Integer reserve ;// 备用字段(mno会员编号)
	private Integer comments ;// 评价状态 
	public Integer getOino() {
		return oino;
	}
	public void setOino(Integer oino) {
		this.oino = oino;
	}
	public String getOno() {
		return ono;
	}
	public void setOno(String ono) {
		this.ono = ono;
	}
	public Integer getGno() {
		return gno;
	}
	public void setGno(Integer gno) {
		this.gno = gno;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getSpare() {
		return spare;
	}
	public void setSpare(String spare) {
		this.spare = spare;
	}
	
	public Integer getComments() {
		return comments;
	}
	public void setComments(Integer comments) {
		this.comments = comments;
	}
	public Integer getReserve() {
		return reserve;
	}
	public void setReserve(Integer reserve) {
		this.reserve = reserve;
	}
	@Override
	public String toString() {
		return "OrderItemPO [oino=" + oino + ", ono=" + ono + ", gno=" + gno + ", gname=" + gname + ", num=" + num
				+ ", price=" + price + ", status=" + status + ", spare=" + spare + ", reserve=" + reserve
				+ ", comments=" + comments + "]";
	}

	
	
}
