package com.mzrd.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.jmx.snmp.Timestamp;

public class DesiredDetailsInfo {
	private int dedid;
	private int deid;
	private String dename;
	private String guige;
	private String unit;
	private String beizhu;
	private int  number;
	private int qid;
	private int sid;
	private String price;
	private String remark;
	private QuoteSupplyImageInfo quoteSupplyImageInfo;
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
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
	
	public String getDename() {
		return dename;
	}
	public void setDename(String dename) {
		this.dename = dename;
	}
	public DesiredDetailsInfo() {
		super();
	}
	public int getDedid() {
		return dedid;
	}
	public void setDedid(int dedid) {
		this.dedid = dedid;
	}
	public int getDeid() {
		return deid;
	}
	public void setDeid(int deid) {
		this.deid = deid;
	}
	
	public String getGuige() {
		return guige;
	}
	public void setGuige(String guige) {
		this.guige = guige;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public QuoteSupplyImageInfo getQuoteSupplyImageInfo() {
		return quoteSupplyImageInfo;
	}
	public void setQuoteSupplyImageInfo(QuoteSupplyImageInfo quoteSupplyImageInfo) {
		this.quoteSupplyImageInfo = quoteSupplyImageInfo;
	}
	@Override
	public String toString() {
		return "DesiredDetailsInfo [dedid=" + dedid + ", deid=" + deid + ", dename=" + dename + ", guige=" + guige
				+ ", unit=" + unit + ", number=" + number + ", qid=" + qid + ", sid=" + sid + ", price=" + price
				+ ", remark=" + remark + ", quoteSupplyImageInfo=" + quoteSupplyImageInfo + "]";
	}
	
	
	
}
