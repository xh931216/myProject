package com.mzrd.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.jmx.snmp.Timestamp;

public class DesiredInfo {
	private int deid;
	private int srid;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date date;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date overDate;
	private String supplier;
	private String guige;
	private String unit;
	private int number;
	private String remark;
	private int id;
	private int  state;
	private int desiredId;
	private StaffAccountInfo staffAccountInfo;
	private SupplyRankInfo supplyRankInfo;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getOverDate() {
		return overDate;
	}
	public void setOverDate(Date overDate) {
		this.overDate = overDate;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public int getDesiredId() {
		return desiredId;
	}
	public void setDesiredId(int desiredId) {
		this.desiredId = desiredId;
	}
	
	public StaffAccountInfo getStaffAccountInfo() {
		return staffAccountInfo;
	}
	public void setStaffAccountInfo(StaffAccountInfo staffAccountInfo) {
		this.staffAccountInfo = staffAccountInfo;
	}
	public SupplyRankInfo getSupplyRankInfo() {
		return supplyRankInfo;
	}
	public void setSupplyRankInfo(SupplyRankInfo supplyRankInfo) {
		this.supplyRankInfo = supplyRankInfo;
	}
	@Override
	public String toString() {
		return "DesiredInfo [deid=" + deid + ", srid=" + srid + ", date=" + date + ", overDate=" + overDate
				+ ", supplier=" + supplier + ", guige=" + guige + ", unit=" + unit + ", number=" + number + ", remark="
				+ remark + ", id=" + id + ", state=" + state + ", desiredId=" + desiredId + ", staffAccountInfo="
				+ staffAccountInfo + ", supplyRankInfo=" + supplyRankInfo + "]";
	}
	
	
	
}
