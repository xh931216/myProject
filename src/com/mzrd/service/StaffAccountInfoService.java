package com.mzrd.service;

import java.util.List;

import com.mzrd.pojo.StaffAccountInfo;

public interface StaffAccountInfoService {
	public StaffAccountInfo getStaffAccount(StaffAccountInfo sa);
	public List<StaffAccountInfo> getStaffAccountByState(StaffAccountInfo sa);
	public int updateStaffAccount(StaffAccountInfo sa);
}