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
	public List<DesiredInfo> getStaffQuoteList(Map map);
	public List<DesiredInfo> getSupllyDesiredAllList(Map map);
	public DesiredInfo getDesiredInfo(DesiredInfo di);
	public DesiredInfo getDesiredInfoPdf(DesiredInfo di);
	public String getDesiredIdMax();
	public PostInfo getPostInfo(DesiredInfo di);
	public int addDesiredInfo(DesiredInfo di);
	public int updateDesiredInfo(DesiredInfo di,String shareItemDatas);
	public int deleteDesiredInfo(DesiredInfo di);
}
