package com.mzrd.controller.supply;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzrd.pojo.DesiredDetailsInfo;
import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.pojo.SupplyAccountInfo;
import com.mzrd.pojo.SupplyRankInfo;
import com.mzrd.service.AdminInfoService;
import com.mzrd.service.DesiredDetailsInfoService;
import com.mzrd.service.DesiredInfoService;
import com.mzrd.service.PostInfoService;
import com.mzrd.service.StaffAccountInfoService;
import com.mzrd.service.SupplyAccountInfoService;
import com.mzrd.service.SupplyRankInfoService;
import com.mzrd.util.PdfUtils;
@RequestMapping("/supply")
@Controller
public class SupplyDesiredInfoController {
	@Autowired
	private DesiredInfoService desiredInfoService;
	@Autowired
	private DesiredDetailsInfoService desiredDetailsInfoService;
	@Autowired
	private StaffAccountInfoService staffAccountInfoService;
	PdfUtils pdfUtils = new PdfUtils();
	//获取询价单pdf
	@RequestMapping(value="/getSupplyDesiredPdf.action",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getSupplyDesiredPdf(DesiredInfo  di,HttpServletRequest request,HttpSession session){
		
		DesiredInfo dii = desiredInfoService.getDesiredInfoPdf(di);
		System.out.println(dii.toString());
		StaffAccountInfo sa = new StaffAccountInfo();
		//sa.setId(dii.getId());
		StaffAccountInfo staffInfo = staffAccountInfoService.getStaffAccountById(sa);
		List<DesiredDetailsInfo> ddi = desiredDetailsInfoService.getStaffDesiredDetailsList(di.getDeid());
		boolean pdf = pdfUtils.savePdf(dii, staffInfo, ddi, request);
		if(pdf==true){
			return "{\"success\":\"true\",\"message\":\"下载成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"下载失败\"}";
		
	}
	//获取所有询价
	@RequestMapping("/getSupllyDesiredList.action")
	@ResponseBody
	public Map<String, Object> getSupllyDesiredList(int page, int rows,
			String overDate,String srid,HttpSession session){
		SupplyAccountInfo staffInfo = (SupplyAccountInfo) session.getAttribute("userInfo");
		Map<String, Object> params = new HashMap<String, Object>();	
		params.put("sid", staffInfo.getSid());
		params.put("srid", srid);
		params.put("overDate", overDate);
		int totalCount =  desiredInfoService.getSupllyDesiredList(params).size();
		params.put("start",(page - 1) * rows);
		params.put("limit",rows);
		List<DesiredInfo> dilist = desiredInfoService.getSupllyDesiredList(params);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", totalCount);
		result.put("rows", dilist);
		return result;
	}
	
	 @org.springframework.web.bind.annotation.InitBinder
	 public void InitBinder(ServletRequestDataBinder bin) {
	        bin.registerCustomEditor(Date.class, new CustomDateEditor(
	                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
}
