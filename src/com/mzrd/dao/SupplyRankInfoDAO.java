package com.mzrd.dao;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.DepartmentInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.pojo.SupplyRankInfo;

public interface SupplyRankInfoDAO {
	public List<SupplyRankInfo> getSupplyRankInfoList(Map map);
}
