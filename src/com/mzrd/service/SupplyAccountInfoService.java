package com.mzrd.service;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.pojo.SupplyAccountInfo;

public interface SupplyAccountInfoService {
	public List<String> getSupplyNameList(SupplyAccountInfo sa,String name);
	public SupplyAccountInfo getSupplyInfoByUserName(SupplyAccountInfo sa);
	public List<SupplyAccountInfo> getSupplyInfo();
	public List<SupplyAccountInfo> getSupplyInfoList(Map map);
	public int deleteSupply(SupplyAccountInfo sa);
	public int updateSupply(SupplyAccountInfo sa);
	public int addSupply(SupplyAccountInfo sa,String[] rankList);
}
