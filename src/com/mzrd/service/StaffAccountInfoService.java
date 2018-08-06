package com.mzrd.service;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.StaffAccountInfo;

public interface StaffAccountInfoService {
	public StaffAccountInfo getStaffAccount(StaffAccountInfo sa);
	public List<StaffAccountInfo> getStaffAccountByState(StaffAccountInfo sa);
	public List<StaffAccountInfo> getStaffAccountPage(Map map);
	public List<String> getStaffNameList(StaffAccountInfo sa);
	public int updateStaffAccount(StaffAccountInfo sa);
	public int deleteStaff(StaffAccountInfo si);
}
