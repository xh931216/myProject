package com.mzrd.dao;

import java.util.List;

import com.mzrd.pojo.DesiredInfo;

public interface DesiredInfoDao {
	public List<DesiredInfo> getPostInfoList(DesiredInfo di);
	public int addDesiredInfo(DesiredInfo di);
	public int updateDesiredInfo(DesiredInfo di);
	public int deleteDesiredInfo(DesiredInfo di);
}
