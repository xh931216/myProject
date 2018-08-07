package com.mzrd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzrd.pojo.DepartmentInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.pojo.SupplyRankInfo;
import com.mzrd.service.PostInfoService;
import com.mzrd.service.SupplyRankInfoService;
import com.mzrd.dao.PostInfoDAO;
import com.mzrd.dao.SupplyRankInfoDAO;
@Service("SupplyRankInfoService")
public class SupplyRankInfoServiceImpl implements SupplyRankInfoService{
	@Autowired
	private SupplyRankInfoDAO supplyRankInfoDAO;

	@Override
	public List<SupplyRankInfo> getSupplyRankInfoList(Map map) {
		return supplyRankInfoDAO.getSupplyRankInfoList(map);
	}
	
}
