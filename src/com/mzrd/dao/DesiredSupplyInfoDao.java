package com.mzrd.dao;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.DesiredDetailsInfo;
import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.DesiredSupplyInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.pojo.SupplyAccountInfo;

public interface DesiredSupplyInfoDao {
	public int addDesiredSupplyInfo(DesiredSupplyInfo di);
	public int deleteDesiredSupply(int deid);
}
