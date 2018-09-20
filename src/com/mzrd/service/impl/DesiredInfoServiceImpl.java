package com.mzrd.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.mzrd.service.DesiredSupplyInfoService;
import com.mzrd.util.JSONUtil;
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
	private DesiredSupplyInfoDao desiredSupplyInfoDao;
	JSONUtil jsonUtil = new JSONUtil();

	@Override
	public int addDesiredInfo(DesiredInfo di) {
		return desiredInfoDao.addDesiredInfo(di);
	}

	@Override
	public int updateDesiredInfo(DesiredInfo di,String shareItemDatas) {
		int deid = di.getDeid();
		 desiredDetailsInfoDao.deleteDesiredDetails(deid);
		List<DesiredDetailsInfo> list = jsonUtil.strToList(shareItemDatas,DesiredDetailsInfo.class);
		for (DesiredDetailsInfo ps : list) {
			ps.setDeid(deid);
			 desiredDetailsInfoDao.addDesiredDetailsInfo(ps);
        }
		desiredInfoDao.updateDesiredInfo(di);
		return 1;
		
	}

	@Override
	public int deleteDesiredInfo(DesiredInfo di) {
		int deid = di.getDeid();
		desiredDetailsInfoDao.deleteDesiredDetails(deid);
		 desiredSupplyInfoDao.deleteDesiredSupply(deid);
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

	@Override
	public List<DesiredInfo> getSupllyDesiredAllList(Map map) {
		return desiredInfoDao.getSupllyDesiredAllList(map);
	}

	@Override
	public List<DesiredInfo> getStaffQuoteList(Map map) {
		return desiredInfoDao.getStaffQuoteList(map);
	}
	

}
