package com.mzrd.pojo;

public class PostInfo {
	private	int rid;
	private String rname;
	private int did;
	private byte state;
	private DepartmentInfo di;
	public PostInfo() {
		super();
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public DepartmentInfo getDi() {
		return di;
	}

	public void setDi(DepartmentInfo di) {
		this.di = di;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	@Override
	public String toString() {
		return "PostInfo [rid=" + rid + ", rname=" + rname + ", did=" + did + ", state=" + state + ", di=" + di + "]";
	}

	
}
