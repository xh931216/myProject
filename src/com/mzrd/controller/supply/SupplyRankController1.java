package com.mzrd.controller.supply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzrd.pojo.SupplyRankInfo;
import com.mzrd.service.SupplyRankInfoService;
@RequestMapping("/supply")
@Controller
public class SupplyRankController1 {
	@Autowired
	private SupplyRankInfoService supplyRankInfoService;	
	
	//获取所有类别
	@RequestMapping("/getRankAllNameList.action")
	@ResponseBody
	public List getRankAllNameList1(){
		SupplyRankInfo pi = new SupplyRankInfo();
		String lodName = "";
		return supplyRankInfoService.getRankAllNameList(pi,lodName);
	}
	
}
