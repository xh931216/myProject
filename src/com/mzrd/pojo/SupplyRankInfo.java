package com.mzrd.pojo;

public class SupplyRankInfo {
	private	int srid;
	private String srname;
	
	public SupplyRankInfo() {
		super();
	}
	public int getSrid() {
		return srid;
	}
	public void setSrid(int srid) {
		this.srid = srid;
	}
	public String getSrname() {
		return srname;
	}
	public void setSrname(String srname) {
		this.srname = srname;
	}
	@Override
	public String toString() {
		return "SupplyRankInfo [srid=" + srid + ", srname=" + srname + "]";
	}
	
}
