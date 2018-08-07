package com.mzrd.service;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.SupplyRankInfo;

public interface SupplyRankInfoService {
	public List<SupplyRankInfo> getSupplyRankInfoList(Map map);
	public List<String> getRankAllNameList(SupplyRankInfo si,String lodName);
	public int deleteSupplyRankInfo(SupplyRankInfo pi);
	public int updateSupplyRankInfo(SupplyRankInfo pi);
	public int addSuplyRankInfo(SupplyRankInfo pi);
}
