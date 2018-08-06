package com.mzrd.dao;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.*;

public interface StaffAccountInfoDAO {
	public StaffAccountInfo getStaffAccount(StaffAccountInfo sa);
	public List<StaffAccountInfo> getStaffAccountByState(StaffAccountInfo sa);
	public List<String> getStaffNameList(StaffAccountInfo sa);
	public List<StaffAccountInfo> getStaffAccountPage(Map map);
	public int updateStaffAccount(StaffAccountInfo sa);
	public int deleteStaff(StaffAccountInfo si);
}
