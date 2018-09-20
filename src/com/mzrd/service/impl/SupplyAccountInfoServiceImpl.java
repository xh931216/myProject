package com.mzrd.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzrd.dao.StaffAccountInfoDAO;
import com.mzrd.dao.SupplyAccountInfoDAO;
import com.mzrd.dao.SupplyRankInfoDAO;
import com.mzrd.dao.SupplyRankRelationInfoDAO;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.pojo.SupplyAccountInfo;
import com.mzrd.pojo.SupplyRankInfo;
import com.mzrd.pojo.SupplyRankRelationInfo;
import com.mzrd.service.StaffAccountInfoService;
import com.mzrd.service.SupplyAccountInfoService;
@Service("SupplyAccountInfoService")
public class SupplyAccountInfoServiceImpl implements SupplyAccountInfoService{
	@Autowired
	private SupplyAccountInfoDAO supplyAccountInfoDAO;
	@Autowired
	private SupplyRankRelationInfoDAO supplyRankRelationInfoDAO;

	@Override
	public List<String> getSupplyNameList(SupplyAccountInfo sa,String name) {
		Map<String, String> map = new HashMap<>();
		map.put("userName", sa.getUserName());
		map.put("name", name);
		return supplyAccountInfoDAO.getSupplyNameList(map);
	}

	@Override
	public List<SupplyAccountInfo> getSupplyInfoList(Map map) {
		List<SupplyAccountInfo> sl = supplyAccountInfoDAO.getSupplyInfoList(map);
		for (int i=0;i<sl.size();i++) {
			int sid = sl.get(i).getSid();
			List<String> srriName = sl.get(i).getSrriName();
			SupplyRankRelationInfo srri = new SupplyRankRelationInfo();
			srri.setSid(sid);
			List<SupplyRankRelationInfo> ri = supplyRankRelationInfoDAO.getSupplyRankRelation(srri);
			for(int j=0;j<ri.size();j++){
				srriName.add(ri.get(j).getSupplyRankInfo().getSrname());
			}
		}
		return sl;
	}

	@Override
	public int deleteSupply(SupplyAccountInfo sa) {
		return supplyAccountInfoDAO.deleteSupply(sa);
	}

	@Override
	public int updateSupply(SupplyAccountInfo sa) {
		return supplyAccountInfoDAO.updateSupply(sa);
	}

	@Override
	public int addSupply(SupplyAccountInfo sa,String[] rankList) {
		
		int addOk = 0;
		supplyAccountInfoDAO.addSupply(sa);
		sa = supplyAccountInfoDAO.getSupplyInfoByUserName(sa);
		for(int i=0;i<rankList.length;i++){
			SupplyRankRelationInfo srri = new SupplyRankRelationInfo();
			srri.setSid(sa.getSid());
			srri.setSrid(Integer.parseInt(rankList[i]));
			addOk = supplyRankRelationInfoDAO.AddSupplyRankRelation(srri);
		}
		return addOk;
	}

	@Override
	public SupplyAccountInfo getSupplyInfoByUserName(SupplyAccountInfo sa) {
		return supplyAccountInfoDAO.getSupplyInfoByUserName(sa);
	}

	@Override
	public List<SupplyAccountInfo> getSupplyInfo(int srid) {
		return supplyAccountInfoDAO.getSupplyInfo(srid);
	}

	@Override
	public List<SupplyAccountInfo> getStaffQuoteSupplyList(int deid) {
		return supplyAccountInfoDAO.getStaffQuoteSupplyList(deid);
	}

	@Override
	public SupplyAccountInfo getStaffQuoteSupply(int sid) {
		return supplyAccountInfoDAO.getStaffQuoteSupply(sid);
	}
	
}
