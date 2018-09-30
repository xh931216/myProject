package com.mzrd.service;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.DepartmentInfo;
import com.mzrd.pojo.DesiredDetailsInfo;
import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.pojo.SupplyAccountInfo;

public interface DesiredDetailsInfoService {
	public List getStaffDesiredDetailsList(int deid,int sid);
	public List getStaffDesiredDetaiSupplylsList(int deid,int sid);
	public int addDesiredDetailsInfo(String shareItemDatas,int deid);
	public String getSupplyCount(int deid,int sid);
}
