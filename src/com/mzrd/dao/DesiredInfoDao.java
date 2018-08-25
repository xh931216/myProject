package com.mzrd.dao;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.pojo.StaffAccountInfo;

public interface DesiredInfoDao {
	public List<DesiredInfo> getStaffDesiredPage(Map map);
	public PostInfo getPostInfo(DesiredInfo di);
	public int addDesiredInfo(DesiredInfo di);
	public int updateDesiredInfo(DesiredInfo di);
	public int deleteDesiredInfo(DesiredInfo di);
}
