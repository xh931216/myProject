package com.mzrd.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.jmx.snmp.Timestamp;

public class DesiredInfo {
	private int deid;
	private int srid;
	private int id;
	private String supplyId;
	private String desiredId;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date overDate;
	private String supplier;
	private String remark;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date date;
	private int  state;
	private SupplyRankInfo supplyRankInfo;
	private StaffAccountInfo staffAccountInfo;
	private List<SupplyAccountInfo> supplyAccountInfo = new ArrayList<SupplyAccountInfo>();
	public DesiredInfo() {
		super();
	}
	public int getDeid() {
		return deid;
	}
	public void setDeid(int deid) {
		this.deid = deid;
	}
	public String getSupplyId() {
		return supplyId;
	}
	public void setSupplyId(String supplyId) {
		this.supplyId = supplyId;
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
	public String getDesiredId() {
		return desiredId;
	}
	public void setDesiredId(String desiredId) {
		this.desiredId = desiredId;
	}
	
	public SupplyRankInfo getSupplyRankInfo() {
		return supplyRankInfo;
	}
	public void setSupplyRankInfo(SupplyRankInfo supplyRankInfo) {
		this.supplyRankInfo = supplyRankInfo;
	}
	public StaffAccountInfo getStaffAccountInfo() {
		return staffAccountInfo;
	}
	public void setStaffAccountInfo(StaffAccountInfo staffAccountInfo) {
		this.staffAccountInfo = staffAccountInfo;
	}
	
	public List<SupplyAccountInfo> getSupplyAccountInfo() {
		return supplyAccountInfo;
	}
	public void setSupplyAccountInfo(List<SupplyAccountInfo> supplyAccountInfo) {
		this.supplyAccountInfo = supplyAccountInfo;
	}
	@Override
	public String toString() {
		return "DesiredInfo [deid=" + deid + ", srid=" + srid + ", id=" + id + ", desiredId=" + desiredId
				+ ", overDate=" + overDate + ", supplier=" + supplier + ", remark=" + remark + ", state=" + state
				+ ", supplyRankInfo=" + supplyRankInfo + ", staffAccountInfo=" + staffAccountInfo + "]";
	}
}
