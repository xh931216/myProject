package com.mzrd.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.jmx.snmp.Timestamp;

public class QuoteInfo {
	private int qid;
	private int deid;
	private String unit;
	private int number;
	private int sid;
	private String price;
	private String remark;
	private int  state;
	private String quoteImage;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date quoteDate;
	private SupplyRankInfo supplyRankInfo;
	private SupplyAccountInfo supplyAccountInfo;
	public QuoteInfo() {
		super();
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public int getDeid() {
		return deid;
	}

	public void setDeid(int deid) {
		this.deid = deid;
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

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}


	public Date getQuoteDate() {
		return quoteDate;
	}

	public void setQuoteDate(Date quoteDate) {
		this.quoteDate = quoteDate;
	}

	public String getQuoteImage() {
		return quoteImage;
	}

	public void setQuoteImage(String quoteImage) {
		this.quoteImage = quoteImage;
	}

	public SupplyRankInfo getSupplyRankInfo() {
		return supplyRankInfo;
	}

	public void setSupplyRankInfo(SupplyRankInfo supplyRankInfo) {
		this.supplyRankInfo = supplyRankInfo;
	}
	
	public SupplyAccountInfo getSupplyAccountInfo() {
		return supplyAccountInfo;
	}

	public void setSupplyAccountInfo(SupplyAccountInfo supplyAccountInfo) {
		this.supplyAccountInfo = supplyAccountInfo;
	}

	@Override
	public String toString() {
		return "QuoteInfo [qid=" + qid + ", deid=" + deid + ", unit=" + unit + ", number=" + number + ", sid=" + sid
				+ ", price=" + price + ", remark=" + remark + ", state=" + state + ", quoteImage=" + quoteImage
				+ ", quotedate=" + quoteDate + ", supplyRankInfo=" + supplyRankInfo + "]";
	}

	
	
	
}
