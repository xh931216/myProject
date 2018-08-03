package com.mzrd.dao;

import java.util.List;

import com.mzrd.pojo.*;

public interface StaffAccountInfoDAO {
	public StaffAccountInfo getStaffAccount(StaffAccountInfo sa);
	public List<StaffAccountInfo> getStaffAccountByState(StaffAccountInfo sa);
	public int updateStaffAccount(StaffAccountInfo sa);
}
