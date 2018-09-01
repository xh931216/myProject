package com.mzrd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.pojo.SupplyAccountInfo;
import com.mzrd.service.DesiredInfoService;
import com.mzrd.dao.DesiredInfoDao;
@Service("DesiredInfoService")
public class DesiredInfoServiceImpl implements DesiredInfoService{
	@Autowired
	private DesiredInfoDao desiredInfoDao;

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

	@Override
	public List<DesiredInfo> getStaffDesiredPage(Map map) {
		return desiredInfoDao.getStaffDesiredPage(map);
	}

	@Override
	public PostInfo getPostInfo(DesiredInfo di) {
		return desiredInfoDao.getPostInfo(di);
	}

	@Override
	public List<DesiredInfo> getSupllyDesiredList(Map map) {
		return desiredInfoDao.getSupllyDesiredList(map);
	}

	@Override
	public DesiredInfo getDesiredInfo(DesiredInfo di) {
		return desiredInfoDao.getDesiredInfo(di);
	}
	

}
