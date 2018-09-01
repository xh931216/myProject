package com.mzrd.controller.supply;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.pojo.SupplyAccountInfo;
import com.mzrd.pojo.SupplyRankInfo;
import com.mzrd.service.AdminInfoService;
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
	private AdminInfoService adminInfoService;
	@Autowired
	private StaffAccountInfoService staffAccountInfoService;
	@Autowired
	private SupplyAccountInfoService supplyAccountInfoService;
	@Autowired
	private SupplyRankInfoService supplyRankInfoService;
	@Autowired
	private PostInfoService postInfoService;
	PdfUtils pdfUtils = new PdfUtils();
	//获取询价单pdf
	@RequestMapping("/getSupplyDesiredPdf.action")
	@ResponseBody
	public void getSupplyDesiredPdf(DesiredInfo di){
		Map<String, String> map = new HashMap<>();
		map.put("id", di.getId()+"");
		String srname = staffAccountInfoService.getStaffNameList(map).get(0);
		Map<String, String> map1 = new HashMap<>();
		map.put("id", di.getSrid()+"");
		String sname =
				supplyRankInfoService.getSupplyRankInfoList(map1).get(0).getSrname();
		pdfUtils.savePdf( di,sname,srname);
	}
	//获取所有询价
	@RequestMapping("/getSupllyDesiredList.action")
	@ResponseBody
	public Map<String, Object> getSupllyDesiredList(int page, int rows,
			String date,String overDate,String srid,HttpSession session){
		SupplyAccountInfo staffInfo = (SupplyAccountInfo) session.getAttribute("userInfo");
		Map<String, Object> params = new HashMap<String, Object>();	
		params.put("sid", staffInfo.getSid());
		params.put("srid", srid);
		params.put("date", date);
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
