package com.mzrd.dao;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.DesiredDetailsInfo;
import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.pojo.SupplyAccountInfo;

public interface DesiredDetailsInfoDao {
	public List getStaffDesiredDetailsList(Map map);
	public List getStaffDesiredDetailsList1(Map map);
	public List getStaffDesiredDetaiSupplylsList(Map map);
	public int addDesiredDetailsInfo(DesiredDetailsInfo di);
	public String getSupplyCount(Map map);
	public int deleteDesiredDetails(int deid);
}
