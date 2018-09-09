package com.mzrd.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.pojo.SupplyAccountInfo;
import com.mzrd.service.DesiredDetailsInfoService;
import com.mzrd.service.DesiredInfoService;
import com.mzrd.service.DesiredSupplyInfoService;
import com.mzrd.dao.DesiredDetailsInfoDao;
import com.mzrd.dao.DesiredInfoDao;
import com.mzrd.dao.DesiredSupplyInfoDao;
@Service("DesiredInfoService")
public class DesiredInfoServiceImpl implements DesiredInfoService{
	@Autowired
	private DesiredInfoDao desiredInfoDao;
	@Autowired
	private DesiredDetailsInfoDao desiredDetailsInfoDao;
	@Autowired
	private DesiredDetailsInfoService desiredDetailsInfoService;
	@Autowired
	private DesiredSupplyInfoDao desiredSupplyInfoDao;
	@Autowired
	private DesiredSupplyInfoService desiredSupplyInfoService;

	@Override
	public int addDesiredInfo(DesiredInfo di) {
		return desiredInfoDao.addDesiredInfo(di);
	}

	@Override
	public int updateDesiredInfo(DesiredInfo di,String[] sidList,String shareItemDatas) {
		int deid = di.getDeid();
		int dd = desiredDetailsInfoDao.deleteDesiredDetails(deid);
		if(dd==0){
			return 0;
		}
		int ds = desiredSupplyInfoDao.deleteDesiredSupply(deid);
		if(ds==0){
			return 0;
		}
		int dei = desiredInfoDao.updateDesiredInfo(di);
		if(dei==0){
			return 0;
		}
		int ddis =  desiredDetailsInfoService.addDesiredDetailsInfo(shareItemDatas,deid);
		if(ddis == 0){
			return 0;
		}
		int dsuis = desiredSupplyInfoService.addDesiredSupplyInfo(sidList,deid);
		if(dsuis == 0){
			return 0;
		 }
		return 1;
		
	}

	@Override
	public int deleteDesiredInfo(DesiredInfo di) {
		int deid = di.getDeid();
		int dd = desiredDetailsInfoDao.deleteDesiredDetails(deid);
		if(dd==0){
			return 0;
		}
		int ds = desiredSupplyInfoDao.deleteDesiredSupply(deid);
		if(ds==0){
			return 0;
		}
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

	@Override
	public String getDesiredIdMax() {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		String dateName = df.format(calendar.getTime());
		return desiredInfoDao.getDesiredIdMax(dateName);
	}

	@Override
	public DesiredInfo getDesiredInfoPdf(DesiredInfo di) {
		return desiredInfoDao.getDesiredInfoPdf(di);
	}
	

}
