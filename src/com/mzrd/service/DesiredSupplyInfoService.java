package com.mzrd.service;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.DepartmentInfo;
import com.mzrd.pojo.DesiredDetailsInfo;
import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.DesiredSupplyInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.pojo.SupplyAccountInfo;

public interface DesiredSupplyInfoService {
	public int addDesiredSupplyInfo(String[] sidList,int deids);
}
