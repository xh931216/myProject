package com.mzrd.service;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.SupplyRankInfo;
import com.mzrd.pojo.SupplyRankRelationInfo;

public interface SupplyRankRelationInfoService {
	public List<SupplyRankRelationInfo> getSupplyRankRelation(SupplyRankRelationInfo si);
	public int updateSupplyRankRelation(SupplyRankRelationInfo si,String[] upRankList);
}
