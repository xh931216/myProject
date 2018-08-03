package com.mzrd.service.impl;

import java.util.List;

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
}
