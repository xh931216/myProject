package com.mzrd.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class QuoteSupplyImageInfo {
	private int qiid;
	private int deid;
	private int sid;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date quoteDate;
	private String imageUrl;
	private int state;
	public QuoteSupplyImageInfo() {
		super();
	}
	public int getQiid() {
		return qiid;
	}
	public void setQiid(int qiid) {
		this.qiid = qiid;
	}
	public int getDeid() {
		return deid;
	}
	
	public Date getQuoteDate() {
		return quoteDate;
	}
	public void setQuoteDate(Date quoteDate) {
		this.quoteDate = quoteDate;
	}
	public void setDeid(int deid) {
		this.deid = deid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "QuoteSupplyImageInfo [qiid=" + qiid + ", deid=" + deid + ", sid=" + sid + ", imageUrl=" + imageUrl
				+ "]";
	};
	
}
