package com.mzrd.dao;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.*;

public interface SupplyAccountInfoDAO {
	public List<String> getSupplyNameList(Map map);
	public SupplyAccountInfo getSupplyInfoByUserName(SupplyAccountInfo sa);
	public List<SupplyAccountInfo> getSupplyInfoList(Map map);
	public int deleteSupply(SupplyAccountInfo sa);
	public int updateSupply(SupplyAccountInfo sa);
	public int addSupply(SupplyAccountInfo sa);
}
