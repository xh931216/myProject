package com.mzrd.dao;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.*;

public interface StaffAccountInfoDAO {
	public StaffAccountInfo getStaffAccount(StaffAccountInfo sa);
	public StaffAccountInfo getStaffAccountById(StaffAccountInfo sa);
	public List<StaffAccountInfo> getStaffAccountByState(StaffAccountInfo sa);
	public List<String> getStaffNameList(Map map);
	public List<StaffAccountInfo> getStaffAccountPage(Map map);
	public int updateStaffAccount(StaffAccountInfo sa);
	public int deleteStaff(StaffAccountInfo si);
	public int addStaff(StaffAccountInfo si);
}
