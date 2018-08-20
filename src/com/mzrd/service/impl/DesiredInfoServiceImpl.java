package com.mzrd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzrd.pojo.DepartmentInfo;
import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.service.DesiredInfoService;
import com.mzrd.service.PostInfoService;
import com.mzrd.dao.DesiredInfoDao;
import com.mzrd.dao.PostInfoDAO;
@Service("DesiredInfoService")
public class DesiredInfoServiceImpl implements DesiredInfoService{
	@Autowired
	private DesiredInfoDao desiredInfoDao;

	@Override
	public List<DesiredInfo> getPostInfoList(DesiredInfo di) {
		return desiredInfoDao.getPostInfoList(di);
	}

	@Override
	public int addDesiredInfo(DesiredInfo di) {
		return desiredInfoDao.addDesiredInfo(di);
	}

	@Override
	public int updateDesiredInfo(DesiredInfo di) {
		return desiredInfoDao.updateDesiredInfo(di);
	}

	@Override
	public int deleteDesiredInfo(DesiredInfo di) {
		return desiredInfoDao.deleteDesiredInfo(di);
	}
	

}
