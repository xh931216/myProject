package com.mzrd.controller.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mzrd.service.SupplyAccountInfoService;
@RequestMapping("/staff")
@Controller
public class SupplyAccountInfoController1 {
	@Autowired
	private SupplyAccountInfoService supplyAccountInfoService;
	
	//获取所有的公司
	@RequestMapping("/getSupplyInfo.action")
	@ResponseBody
	public List getSupplyInfo(){
		return supplyAccountInfoService.getSupplyInfo();
	}
	
}
