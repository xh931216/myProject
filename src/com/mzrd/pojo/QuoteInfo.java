package com.mzrd.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.jmx.snmp.Timestamp;

public class QuoteInfo {
	private int qid;
	private int dedid;
	private int sid;
	private String price;
	private String remark;
	public QuoteInfo() {
		super();
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getDedid() {
		return dedid;
	}
	public void setDedid(int dedid) {
		this.dedid = dedid;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "QuoteInfo [qid=" + qid + ", dedid=" + dedid + ", sid=" + sid + ", price=" + price + ", remark=" + remark
				+ "]";
	}
	
}
