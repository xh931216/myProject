package com.mzrd.controller.staff;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mzrd.service.DesiredDetailsInfoService;
import com.mzrd.util.DesiredId;
import com.mzrd.util.JSONUtil;
import com.mzrd.util.PdfUtils;




@RequestMapping("/staff")
@Controller
public class StaffDesiredDetailsInfoController {
	@Autowired
	private DesiredDetailsInfoService desiredDetailsInfoService;
	//获取询价
	@RequestMapping("/getStaffDesiredDetailsList.action")
	@ResponseBody
	public List getStaffDesiredDetailsList(int deid){
		return desiredDetailsInfoService.getStaffDesiredDetailsList(deid,0);
	}
	//获取询价
	@RequestMapping("/getStaffDesiredDetaiSupplylsList.action")
	@ResponseBody
	public List getStaffDesiredDetaiSupplylsList(int deid,int sid){
		return desiredDetailsInfoService.getStaffDesiredDetaiSupplylsList(deid, sid);
	}
	 @org.springframework.web.bind.annotation.InitBinder
	 public void InitBinder(ServletRequestDataBinder bin) {
	        bin.registerCustomEditor(Date.class, new CustomDateEditor(
	                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
	
}
