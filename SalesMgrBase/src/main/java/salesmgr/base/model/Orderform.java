package salesmgr.base.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Orderform {
	private String orderid;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date ordertime;

	private Float orderprice;

	private String userid;

	private String ordernote;

	private Integer ordertype;

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Float getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(Float orderprice) {
		this.orderprice = orderprice;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getOrdernote() {
		return ordernote;
	}

	public void setOrdernote(String ordernote) {
		this.ordernote = ordernote;
	}

	public Integer getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(Integer ordertype) {
		this.ordertype = ordertype;
	}
}