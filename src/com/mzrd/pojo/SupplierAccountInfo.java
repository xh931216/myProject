package com.mzrd.pojo;

public class SupplierAccountInfo {
	private	int sid;
	private String userName;
	private String password;
	private String supplierName;
	private String address;
	private long phone;
	private String contact;
	private String email;
	private int state;
	private String sridList;
	public SupplierAccountInfo() {
		super();
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
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
	public String getSridList() {
		return sridList;
	}
	public void setSridList(String sridList) {
		this.sridList = sridList;
	}
	@Override
	public String toString() {
		return "SupplierAccountInfo [sid=" + sid + ", userName=" + userName + ", password=" + password
				+ ", supplierName=" + supplierName + ", address=" + address + ", phone=" + phone + ", contact="
				+ contact + ", email=" + email + ", state=" + state + ", sridList=" + sridList + "]";
	}
	
	
	
}
