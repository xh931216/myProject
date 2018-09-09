package com.mzrd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzrd.pojo.DesiredDetailsInfo;
import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.DesiredSupplyInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.pojo.SupplyAccountInfo;
import com.mzrd.service.DesiredDetailsInfoService;
import com.mzrd.service.DesiredInfoService;
import com.mzrd.service.DesiredSupplyInfoService;
import com.mzrd.util.JSONUtil;
import com.mzrd.dao.DesiredDetailsInfoDao;
import com.mzrd.dao.DesiredInfoDao;
import com.mzrd.dao.DesiredSupplyInfoDao;
@Service("DesiredSupplyInfoService")
public class DesiredSupplyInfoServiceImpl implements DesiredSupplyInfoService{
	@Autowired
	private DesiredSupplyInfoDao desiredSupplyInfoDao;

	@Override
	public int addDesiredSupplyInfo(String[] sidList,int deid) {
		int j=0;
		for(int i=0;i<sidList.length;i++){
			DesiredSupplyInfo di = new DesiredSupplyInfo();
			di.setDeid(deid);
			String sid = sidList[i];
			di.setSid(Integer.parseInt(sid));
			j = desiredSupplyInfoDao.addDesiredSupplyInfo(di);
		}
		return j;
	}
}
