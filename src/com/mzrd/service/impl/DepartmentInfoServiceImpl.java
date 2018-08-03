package com.mzrd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzrd.dao.DepartmentInfoDAO;
import com.mzrd.pojo.DepartmentInfo;
import com.mzrd.service.DepartmentInfoService;
@Service("DepartmentInfoService")
public class DepartmentInfoServiceImpl implements DepartmentInfoService {
	@Autowired
	private DepartmentInfoDAO departmentInfoDao;
	
	@Override
	public List<DepartmentInfo> getDepartmentList() {
		return departmentInfoDao.getDepartmentList();
	}

	@Override
	public int addDepartmentInfo(DepartmentInfo di) {
		return departmentInfoDao.addDepartmentInfo(di);
	}

	@Override
	public int updateDepartmentInfo(DepartmentInfo di) {
		return departmentInfoDao.updateDepartmentInfo(di);
	}

	@Override
	public int deleteDepartmentInfo(DepartmentInfo di) {
		return departmentInfoDao.deleteDepartmentInfo(di);
	}
	@Override
	public DepartmentInfo getDepartment(DepartmentInfo di){
		return departmentInfoDao.getDepartment(di);
	}

	@Override
	public int updateDepartmentInfoByState(DepartmentInfo di) {
		return departmentInfoDao.updateDepartmentInfoByState(di);
	}
}
