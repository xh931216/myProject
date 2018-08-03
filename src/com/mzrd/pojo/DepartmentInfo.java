package com.mzrd.pojo;

public class DepartmentInfo {
	private int did;
	private String dname;
	private byte state;
	public byte isState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	public DepartmentInfo() {
		// TODO Auto-generated constructor stub
	}
	public DepartmentInfo(int did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "DepartmentInfo [did=" + did + ", dname=" + dname + "]";
	}
	
}
