package com.mzrd.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.jmx.snmp.Timestamp;

public class DesiredSupplyInfo {
	private int deid;
	private int sid;
	private int desid;
	public DesiredSupplyInfo() {
		super();
	}
	
	public int getDeid() {
		return deid;
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

	public int getDesid() {
		return desid;
	}

	public void setDesid(int desid) {
		this.desid = desid;
	}

	@Override
	public String toString() {
		return "DesiredSupplyInfo [deid=" + deid + ", sid=" + sid + ", deid=" + deid + "]";
	}
	
	
	
	
}
