package com.mzrd.pojo;

public class PostInfo {
	private	int rid;
	private String rname;
	private int did;
	private int rselect;
	private int rinsert;
	private int rdelete;
	private int rupdate;
	private byte state;
	private DepartmentInfo di;
	public PostInfo() {
		super();
	}

	public PostInfo(int rid, String rname, int did, int select, int insert, int delete, int update) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.did = did;
		this.rselect = select;
		this.rinsert = insert;
		this.rdelete = delete;
		this.rupdate = update;
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

	public int getRselect() {
		return rselect;
	}

	public void setRselect(int rselect) {
		this.rselect = rselect;
	}

	public int getRinsert() {
		return rinsert;
	}

	public void setRinsert(int rinsert) {
		this.rinsert = rinsert;
	}

	public int getRdelete() {
		return rdelete;
	}

	public void setRdelete(int rdelete) {
		this.rdelete = rdelete;
	}

	public int getRupdate() {
		return rupdate;
	}

	public void setRupdate(int rupdate) {
		this.rupdate = rupdate;
	}

	@Override
	public String toString() {
		return "PostInfo [rid=" + rid + ", rname=" + rname + ", did=" + did + ", rselect=" + rselect + ", rinsert="
				+ rinsert + ", rdelete=" + rdelete + ", rupdate=" + rupdate + ", di=" + di + "]";
	}

	

	
	
}
