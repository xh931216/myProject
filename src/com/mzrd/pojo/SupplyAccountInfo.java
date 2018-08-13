package com.mzrd.pojo;

import java.util.ArrayList;
import java.util.List;

public class SupplyAccountInfo {
	private	int sid;
	private String userName;
	private String password;
	private String supplierName;
	private String abbreviation;
	private String address;
	private String phone;
	private String contact;
	private String email;
	private int state;
	private List<SupplyRankInfo> srriSet = new ArrayList<SupplyRankInfo>();
	private List<String> srriName = new ArrayList<>();
	 
	public List<String> getSrriName() {
		return srriName;
	}
	public void setSrriName(List<String> srriName) {
		this.srriName = srriName;
	}
	public List<SupplyRankInfo> getSrriSet() {
		return srriSet;
	}
	public void setSrriSet(List<SupplyRankInfo> srriSet) {
		this.srriSet = srriSet;
	}
	public SupplyAccountInfo() {
		super();
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "SupplyAccountInfo [sid=" + sid + ", userName=" + userName + ", password=" + password + ", supplierName="
				+ supplierName + ", abbreviation=" + abbreviation + ", address=" + address + ", phone=" + phone
				+ ", contact=" + contact + ", email=" + email + ", state=" + state + ", srriSet=" + srriSet + "]";
	}
	
	
	
	
	
}
