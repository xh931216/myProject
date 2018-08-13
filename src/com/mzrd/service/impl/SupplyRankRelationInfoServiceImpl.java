package com.mzrd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzrd.dao.SupplyRankRelationInfoDAO;
import com.mzrd.pojo.SupplyRankRelationInfo;
import com.mzrd.service.SupplyRankRelationInfoService;

@Service("SupplyRankRelationInfoService")
public class SupplyRankRelationInfoServiceImpl implements SupplyRankRelationInfoService {
	@Autowired
	private SupplyRankRelationInfoDAO supplyRankRelationInfoDAO;
	@Override
	public List<SupplyRankRelationInfo> getSupplyRankRelation(SupplyRankRelationInfo si) {
		return supplyRankRelationInfoDAO.getSupplyRankRelation(si);
	}
	@Override
	public int updateSupplyRankRelation(SupplyRankRelationInfo si, String[] upRankList) {
		supplyRankRelationInfoDAO.DeleteSupplyRankRelation(si);
		int upOk = 0;
		for(int i=0;i<upRankList.length;i++){
			si.setSrid(Integer.parseInt(upRankList[i]));
			upOk = supplyRankRelationInfoDAO.AddSupplyRankRelation(si);
		}
		return upOk;
	}

}
