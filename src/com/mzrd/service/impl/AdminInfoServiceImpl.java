package com.mzrd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzrd.dao.AdminInfoDAO;
import com.mzrd.dao.StaffAccountInfoDAO;
import com.mzrd.pojo.AdminInfo;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.service.AdminInfoService;
import com.mzrd.service.StaffAccountInfoService;
@Service("AdminInfoService")
public class AdminInfoServiceImpl implements AdminInfoService{
	@Autowired
	private AdminInfoDAO adminInfoDAO;
	
	public AdminInfo getAdmin(AdminInfo sa){
		return adminInfoDAO.getAdmin(sa);
	}

	@Override
	public List<AdminInfo> getAdminList() {
		return adminInfoDAO.getAdminList();
	}

	@Override
	public int updateAdmin(AdminInfo sa) {
		return adminInfoDAO.updateAdmin(sa);
	}

	@Override
	public List<String> getAdminNameList(AdminInfo sa) {
		return adminInfoDAO.getAdminNameList(sa);
	}

	
}
