package com.mzrd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzrd.dao.StaffAccountInfoDAO;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.service.StaffAccountInfoService;
@Service("StaffAccountInfoService")
public class StaffAccountInfoServiceImpl implements StaffAccountInfoService{
	@Autowired
	private StaffAccountInfoDAO staffAccountInfoDAO;
	
	public StaffAccountInfo getStaffAccount(StaffAccountInfo sa){
		return staffAccountInfoDAO.getStaffAccount(sa);
	}

	@Override
	public int updateStaffAccount(StaffAccountInfo sa) {
		System.out.println(sa.toString());
		return staffAccountInfoDAO.updateStaffAccount(sa);
	}

	@Override
	public List<StaffAccountInfo> getStaffAccountByState(StaffAccountInfo sa) {
		return staffAccountInfoDAO.getStaffAccountByState(sa);
	}

	@Override
	public List<StaffAccountInfo> getStaffAccountPage(Map map) {
		return staffAccountInfoDAO.getStaffAccountPage(map);
	}

	@Override
	public int deleteStaff(StaffAccountInfo si) {
		return staffAccountInfoDAO.deleteStaff(si);
	}

	@Override
	public List<String> getStaffNameList(StaffAccountInfo sa) {
		return staffAccountInfoDAO.getStaffNameList(sa);
	}
}
