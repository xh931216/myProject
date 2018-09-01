package com.mzrd.service;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.DepartmentInfo;
import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.pojo.SupplyAccountInfo;

public interface DesiredInfoService {
	public List<DesiredInfo> getStaffDesiredPage(Map map);
	public List<DesiredInfo> getSupllyDesiredList(Map map);
	public DesiredInfo getDesiredInfo(DesiredInfo di);
	public PostInfo getPostInfo(DesiredInfo di);
	public int addDesiredInfo(DesiredInfo di);
	public int updateDesiredInfo(DesiredInfo di);
	public int deleteDesiredInfo(DesiredInfo di);
}
