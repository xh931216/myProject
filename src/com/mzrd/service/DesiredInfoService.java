package com.mzrd.service;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.DepartmentInfo;
import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.PostInfo;

public interface DesiredInfoService {
	public List<DesiredInfo> getPostInfoList(DesiredInfo di);
	public int addDesiredInfo(DesiredInfo di);
	public int updateDesiredInfo(DesiredInfo di);
	public int deleteDesiredInfo(DesiredInfo di);
}
