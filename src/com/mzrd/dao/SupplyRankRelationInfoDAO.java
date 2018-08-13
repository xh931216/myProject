package com.mzrd.dao;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.*;

public interface SupplyRankRelationInfoDAO {
	public List<SupplyRankRelationInfo> getSupplyRankRelation(SupplyRankRelationInfo si);
	public int DeleteSupplyRankRelation(SupplyRankRelationInfo si);
	public int AddSupplyRankRelation(SupplyRankRelationInfo si);
}
