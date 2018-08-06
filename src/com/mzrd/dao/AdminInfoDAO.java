package com.mzrd.dao;

import java.util.List;

import com.mzrd.pojo.*;

public interface AdminInfoDAO {
	public AdminInfo getAdmin(AdminInfo sa);
	public List<AdminInfo> getAdminList();
	public List<String> getAdminNameList(AdminInfo sa);
	public int updateAdmin(AdminInfo sa);
}
