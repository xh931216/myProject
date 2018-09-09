package com.mzrd.controller.staff;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mzrd.controller.admin.PostInfoController;
import com.mzrd.pojo.DepartmentInfo;
import com.mzrd.pojo.DesiredDetailsInfo;
import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.pojo.SupplyRankInfo;
import com.mzrd.service.AdminInfoService;
import com.mzrd.service.DesiredDetailsInfoService;
import com.mzrd.service.DesiredInfoService;
import com.mzrd.service.DesiredSupplyInfoService;
import com.mzrd.service.PostInfoService;
import com.mzrd.service.SupplyAccountInfoService;
import com.mzrd.service.SupplyRankInfoService;
import com.mzrd.util.DesiredId;
import com.mzrd.util.Image;
import com.mzrd.util.JSONUtil;
import com.mzrd.util.PdfUtils;

import net.sf.json.JSONObject;



@RequestMapping("/staff")
@Controller
public class StaffDesiredInfoController {
	@Autowired
	private DesiredInfoService desiredInfoService;
	@Autowired
	private DesiredDetailsInfoService desiredDetailsInfoService;
	@Autowired
	private DesiredSupplyInfoService desiredSupplyInfoService;
	@Autowired
	private PostInfoService postInfoService;
	PdfUtils pdfUtils = new PdfUtils();
	JSONUtil jsonUtil = new JSONUtil();
	DesiredId desriedId = new DesiredId();
	//获取所有询价
	@RequestMapping("/getStaffDesiredList.action")
	@ResponseBody
	public Map<String, Object> getStaffDesiredList(int page, int rows,String state,
			String overDate,String srid,HttpSession session){
		StaffAccountInfo staffInfo = (StaffAccountInfo) session.getAttribute("userInfo");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("srid", srid);
		params.put("overDate", overDate);
		params.put("state", state);
		params.put("select", staffInfo.getPostInfo().getRselect());
		params.put("id", staffInfo.getId());
		params.put("did", staffInfo.getPostInfo().getDid());
		int totalCount =  desiredInfoService.getStaffDesiredPage(params).size();			
		params.put("start",(page - 1) * rows);
		params.put("limit",rows);
		List<DesiredInfo> dilist = desiredInfoService.getStaffDesiredPage(params);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", totalCount);
		result.put("rows", dilist);
		return result;
	}
	@RequestMapping(value="/getDesiredInfo.action")
	@ResponseBody
	public StaffAccountInfo getDesiredInfo(HttpSession session){
		StaffAccountInfo staffInfo = (StaffAccountInfo) session.getAttribute("userInfo");
		return staffInfo;
	}
	//删除询价
	@RequestMapping(value="/deleteDesiredInfo.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteDesiredInfo(DesiredInfo si,HttpSession session){
		StaffAccountInfo staffInfo = (StaffAccountInfo) session.getAttribute("userInfo");
		int del = staffInfo.getPostInfo().getRdelete();
		//判断权限
		if(del==0){
			return "{\"success\":\"false\",\"message\":\"没有操作权限\"}";
		}
		if(del==1){
			if(si.getId()==staffInfo.getId()){
				int dOK = desiredInfoService.deleteDesiredInfo(si);
				if(dOK == 1){
					return "{\"success\":\"true\",\"message\":\"删除成功\"}";
				}
				return "{\"success\":\"false\",\"message\":\"删除失败\"}";
			}
			return "{\"success\":\"false\",\"message\":\"没有操作权限\"}";
		}
		if(del==2){
			int did = staffInfo.getPostInfo().getDid();
			PostInfo postinfo = desiredInfoService.getPostInfo(si);
			if(did==postinfo.getDid()){
				int dOK = desiredInfoService.deleteDesiredInfo(si);
				if(dOK == 1){
					return "{\"success\":\"true\",\"message\":\"删除成功\"}";
				}
				return "{\"success\":\"false\",\"message\":\"删除失败\"}";
			}
			return "{\"success\":\"false\",\"message\":\"没有操作权限\"}";
		}
		int dOK = desiredInfoService.deleteDesiredInfo(si);
		if(dOK == 1){
			return "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"删除失败\"}";
	}
	
	//添加询价
	@RequestMapping(value="/addStaffDesired.action",method=RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addStaffDesired( HttpSession session,DesiredInfo si, 
			String[] sidList,String shareItemDatas) {
		StaffAccountInfo staffInfo = (StaffAccountInfo) session.getAttribute("userInfo");	
		si.setId(staffInfo.getId());
		DesiredInfo gOk = desiredInfoService.getDesiredInfo(si);
	    if(gOk!=null){
			return "{\"success\":\"true\",\"message\":\"询价单已存在\"}";
	    }
		String desirid =  desriedId.getDeiredId(desiredInfoService.getDesiredIdMax());
		si.setDesiredId(desirid);
		int dOK = desiredInfoService.addDesiredInfo(si);
		boolean inOk = false;
		if(dOK == 1){
			 int deid  =  desiredInfoService.getDesiredInfo(si).getDeid();
			 int ddis =  desiredDetailsInfoService.addDesiredDetailsInfo(shareItemDatas,deid);
			 if(ddis != 0){
				 inOk = true;
			 }
			 int dsuis = desiredSupplyInfoService.addDesiredSupplyInfo(sidList,deid);
			 if(dsuis != 0){
				 inOk = true;
			 }
		}
		if(inOk==true){
			return "{\"success\":\"true\",\"message\":\"添加成功\"}";
		}
		return "{\"success\":\""+inOk+"\",\"message\":\"添加失败\"}";
	}
	//修改询价
	@RequestMapping(value="/updateStaffDesired.action",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateStaffDesired(HttpSession session,DesiredInfo si, 
			String[] sidList,String shareItemDatas) {
		StaffAccountInfo staffInfo = (StaffAccountInfo) session.getAttribute("userInfo");	
		si.setId(staffInfo.getId());
		int del = staffInfo.getPostInfo().getRupdate();
		//判断权限
		if(del==0){
			return "{\"success\":\"false\",\"message\":\"没有操作权限\"}";
		}
		if(del==1){
			if(si.getId()==staffInfo.getId()){
				int dOK = desiredInfoService.updateDesiredInfo(si,sidList,shareItemDatas);
				if(dOK == 1){
					return "{\"success\":\"true\",\"message\":\"修改成功\"}";
				}
				return "{\"success\":\"false\",\"message\":\"修改失败\"}";
			}
			return "{\"success\":\"false\",\"message\":\"没有操作权限\"}";
		}
		if(del==2){
			int did = staffInfo.getPostInfo().getDid();
			PostInfo postinfo = desiredInfoService.getPostInfo(si);
			if(did==postinfo.getDid()){
				int dOK = desiredInfoService.updateDesiredInfo(si,sidList,shareItemDatas);
				if(dOK == 1){
					return "{\"success\":\"true\",\"message\":\"修改成功\"}";
				}
				return "{\"success\":\"false\",\"message\":\"修改失败\"}";
			}
			return "{\"success\":\"false\",\"message\":\"没有操作权限\"}";
		}
		int dOK = desiredInfoService.updateDesiredInfo(si,sidList,shareItemDatas);
		if(dOK == 1){
			return "{\"success\":\"true\",\"message\":\"修改成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"修改失败\"}";
	}
	
	 @org.springframework.web.bind.annotation.InitBinder
	 public void InitBinder(ServletRequestDataBinder bin) {
	        bin.registerCustomEditor(Date.class, new CustomDateEditor(
	                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
	
}
