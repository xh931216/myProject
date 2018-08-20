package com.mzrd.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.jmx.snmp.Timestamp;

public class DesiredInfo {
	private int deid;
	private int srid;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startDate;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date overDate;
	private String desiredImage;
	private int id;
	private int  state;
	public DesiredInfo() {
		super();
	}
	public int getDeid() {
		return deid;
	}
	public void setDeid(int deid) {
		this.deid = deid;
	}
	public int getSrid() {
		return srid;
	}
	public void setSrid(int srid) {
		this.srid = srid;
	}
	
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getOverDate() {
		return overDate;
	}
	public void setOverDate(Date overDate) {
		this.overDate = overDate;
	}
	public String getDesiredImage() {
		return desiredImage;
	}
	public void setDesiredImage(String desiredImage) {
		this.desiredImage = desiredImage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "DesiredInfo [deid=" + deid + ", srid=" + srid + ", startDate=" + startDate + ", overDate=" + overDate
				+ ", desiredImage=" + desiredImage + ", id=" + id + ", state=" + state + "]";
	}
	
}
