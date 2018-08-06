package com.mzrd.service;

import java.util.List;

import com.mzrd.pojo.AdminInfo;

public interface AdminInfoService {
	public AdminInfo getAdmin(AdminInfo sa);
	public List<AdminInfo> getAdminList();
	public List<String> getAdminNameList(AdminInfo sa);
	public int updateAdmin(AdminInfo sa);
}
