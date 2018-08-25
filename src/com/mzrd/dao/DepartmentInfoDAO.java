package com.mzrd.dao;

import java.util.List;

import com.mzrd.pojo.DepartmentInfo;
import com.mzrd.pojo.PostInfo;

public interface DepartmentInfoDAO {
	public List<DepartmentInfo> getDepartmentList();
	public DepartmentInfo getDepartment(DepartmentInfo di);
	public int addDepartmentInfo(DepartmentInfo di);
	public int updateDepartmentInfo(DepartmentInfo di);
	public int updateDepartmentInfoByState(DepartmentInfo di);
	public int deleteDepartmentInfo(DepartmentInfo di);
}
