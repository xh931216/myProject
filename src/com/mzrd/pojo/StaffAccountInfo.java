package com.mzrd.pojo;

public class StaffAccountInfo {
	private	int id;
	private String userName;
	private String password;
	private int rid;
	private String sname;
	private String phone;
	private String email;
	private int state;
	private int did;
	private PostInfo postInfo;
	private DepartmentInfo departmentInfo;
	
	public DepartmentInfo getDepartmentInfo() {
		return departmentInfo;
	}
	public void setDepartmentInfo(DepartmentInfo departmentInfo) {
		this.departmentInfo = departmentInfo;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public PostInfo getPostInfo() {
		return postInfo;
	}
	public void setPostInfo(PostInfo postInfo) {
		this.postInfo = postInfo;
	}
	public StaffAccountInfo(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "StaffAccountInfo [id=" + id + ", userName=" + userName + ", password=" + password + ", rid=" + rid
				+ ", sname=" + sname + ", phone=" + phone + ", email=" + email + ", state=" + state + ", postInfo="
				+ postInfo + ", departmentInfo=" + departmentInfo + "]";
	}
	
}
