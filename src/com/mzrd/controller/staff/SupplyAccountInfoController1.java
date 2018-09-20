package com.mzrd.controller.staff;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzrd.pojo.DesiredInfo;
import com.mzrd.service.SupplyAccountInfoService;
@RequestMapping("/staff")
@Controller
public class SupplyAccountInfoController1 {
	@Autowired
	private SupplyAccountInfoService supplyAccountInfoService;
	
	//��ȡ���еĹ�˾
	@RequestMapping("/getSupplyInfo.action")
	@ResponseBody
	public List getSupplyInfo(int srid){
		return supplyAccountInfoService.getSupplyInfo(srid);
	}
	//��ȡ���б����۵�Ա��
	@RequestMapping("/getStaffQuoteSupplyList.action")
	@ResponseBody
	public List getStaffQuoteSupplyList(int deid){
		return supplyAccountInfoService.getStaffQuoteSupplyList(deid);
  }
		
	
	
}