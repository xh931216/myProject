package com.mzrd.controller.supply;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.QuoteInfo;
import com.mzrd.pojo.SupplyAccountInfo;
import com.mzrd.service.DesiredDetailsInfoService;
import com.mzrd.service.QuoteInfoService;
import com.mzrd.util.DesiredId;
import com.mzrd.util.JSONUtil;
import com.mzrd.util.PdfUtils;

@RequestMapping("/supply")
@Controller
public class SupplyDesiredDetailsInfoController {
	@Autowired
	private DesiredDetailsInfoService desiredDetailsInfoService;
	//获取所有询价
	@RequestMapping("/getStaffDesiredDetailsList.action")
	@ResponseBody
	public List getStaffDesiredDetailsList(int deid,HttpSession session){
		SupplyAccountInfo supplyInfo = (SupplyAccountInfo) session.getAttribute("userInfo");
		int sid = supplyInfo.getSid();
		return desiredDetailsInfoService.getStaffDesiredDetailsList(deid,sid);
	}
	
	 @org.springframework.web.bind.annotation.InitBinder
	 public void InitBinder(ServletRequestDataBinder bin) {
	        bin.registerCustomEditor(Date.class, new CustomDateEditor(
	                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
	
}
