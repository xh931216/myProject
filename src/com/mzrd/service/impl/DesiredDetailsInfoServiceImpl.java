package com.mzrd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzrd.pojo.DesiredDetailsInfo;
import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.pojo.SupplyAccountInfo;
import com.mzrd.service.DesiredDetailsInfoService;
import com.mzrd.service.DesiredInfoService;
import com.mzrd.util.JSONUtil;
import com.mzrd.dao.DesiredDetailsInfoDao;
import com.mzrd.dao.DesiredInfoDao;
@Service("DesiredDetailsInfoService")
public class DesiredDetailsInfoServiceImpl implements DesiredDetailsInfoService{
	@Autowired
	private DesiredDetailsInfoDao desiredDetailsInfoDao;
	JSONUtil jsonUtil = new JSONUtil();
	@Override
	public int addDesiredDetailsInfo(String shareItemDatas,int deid) {
		int dad = 0;
		List<DesiredDetailsInfo> list = jsonUtil.strToList(shareItemDatas,DesiredDetailsInfo.class);
		for (DesiredDetailsInfo ps : list) {
			ps.setDeid(deid);
			dad = desiredDetailsInfoDao.addDesiredDetailsInfo(ps);
        }
		return dad;
	}
	@Override
	public List getStaffDesiredDetailsList(int deid) {
		return desiredDetailsInfoDao.getStaffDesiredDetailsList(deid);
	}
	
}
