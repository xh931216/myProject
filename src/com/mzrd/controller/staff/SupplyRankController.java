package com.mzrd.controller.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzrd.pojo.SupplyRankInfo;
import com.mzrd.service.SupplyRankInfoService;
@RequestMapping("/staff")
@Controller
public class SupplyRankController {
	@Autowired
	private SupplyRankInfoService supplyRankInfoService;	
	
	//获取所有类别
	@RequestMapping("/getRankAllNameList.action")
	@ResponseBody
	public List getRankAllNameList(){
		SupplyRankInfo pi = new SupplyRankInfo();
		String lodName = "";
		return supplyRankInfoService.getRankAllNameList(pi,lodName);
	}
	
}
