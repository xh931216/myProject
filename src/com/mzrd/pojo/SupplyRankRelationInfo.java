package com.mzrd.pojo;

public class SupplyRankRelationInfo {
	private int arid;
	private int sid;
	private int srid;
	private SupplyAccountInfo supplyAccountInfo;
	private SupplyRankInfo supplyRankInfo;
	
	public SupplyRankInfo getSupplyRankInfo() {
		return supplyRankInfo;
	}
	public void setSupplyRankInfo(SupplyRankInfo supplyRankInfo) {
		this.supplyRankInfo = supplyRankInfo;
	}
	public SupplyAccountInfo getSupplyAccountInfo() {
		return supplyAccountInfo;
	}
	public SupplyRankRelationInfo(){
	}
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public int getArid() {
		return arid;
	}

	public void setArid(int arid) {
		this.arid = arid;
	}
	public int getSrid() {
		return srid;
	}

	public void setSrid(int srid) {
		this.srid = srid;
	}
	public SupplyAccountInfo getySupplyAccountInfo(){
		return supplyAccountInfo;
	}
	public void setSupplyAccountInfo(SupplyAccountInfo supplyAccountInfo){
		this.supplyAccountInfo=supplyAccountInfo;
	}
}