package com.mzrd.service.impl;

import java.util.HashMap;
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
			System.out.println(dad+","+ps);
			dad = desiredDetailsInfoDao.addDesiredDetailsInfo(ps);
        }
		return dad;
	}
	@Override
	public List getStaffDesiredDetailsList(int deid,int sid) {
		Map map = new HashMap<>();
		map.put("deid", deid);
		map.put("sid", sid);
		return desiredDetailsInfoDao.getStaffDesiredDetailsList(map);
	}
	@Override
	public List getStaffDesiredDetaiSupplylsList(int deid, int sid) {
		Map map = new HashMap<>();
		map.put("deid", deid);
		map.put("sid", sid);
		return desiredDetailsInfoDao.getStaffDesiredDetaiSupplylsList(map);
	}
	@Override
	public String getSupplyCount(int deid, int sid) {
		Map map = new HashMap<>();
		map.put("deid", deid);
		map.put("sid", sid);
		return desiredDetailsInfoDao.getSupplyCount(map);
	}
	@Override
	public List getStaffDesiredDetailsList1(int deid, int sid) {
		Map map = new HashMap<>();
		map.put("deid", deid);
		map.put("sid", sid);
		return desiredDetailsInfoDao.getStaffDesiredDetailsList1(map);
	}
	
}
