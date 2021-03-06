package com.mzrd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzrd.pojo.*;
import com.mzrd.service.PostInfoService;
import com.mzrd.service.SupplyRankInfoService;
import com.mzrd.dao.SupplyRankRelationInfoDAO;
import com.mzrd.dao.SupplyRankInfoDAO;
@Service("SupplyRankInfoService")
public class SupplyRankInfoServiceImpl implements SupplyRankInfoService{
	@Autowired
	private SupplyRankInfoDAO supplyRankInfoDAO;
	@Autowired
	private SupplyRankRelationInfoDAO supplyRankRelationInfoDAO;

	@Override
	public List<SupplyRankInfo> getSupplyRankInfoList(Map map) {
		return supplyRankInfoDAO.getSupplyRankInfoList(map);
	}
	@Override
	public List<SupplyRankInfo> getRankAllNameList(SupplyRankInfo si,String lodName){
		Map<String, String> map = new HashMap<>();
		if(lodName != null && lodName != " "){
			map.put("name", lodName);
		}
		map.put("srname", si.getSrname());
		return supplyRankInfoDAO.getRankAllNameList(map);
	}
	@Override
	public int deleteSupplyRankInfo(SupplyRankInfo pi){
		SupplyRankRelationInfo srri = new SupplyRankRelationInfo();
		srri.setSrid(pi.getSrid());
		supplyRankRelationInfoDAO.DeleteSupplyRankRelation(srri);
		return supplyRankInfoDAO.deleteSupplyRankInfo(pi);
	}
	@Override
	public int updateSupplyRankInfo(SupplyRankInfo pi){
		return supplyRankInfoDAO.updateSupplyRankInfo(pi);
	}
	@Override
	public int addSuplyRankInfo(SupplyRankInfo pi){
		return supplyRankInfoDAO.addSuplyRankInfo(pi);
	}
}
