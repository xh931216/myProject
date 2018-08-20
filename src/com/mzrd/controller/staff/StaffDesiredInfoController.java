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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.service.AdminInfoService;
import com.mzrd.service.DesiredInfoService;
import com.mzrd.service.SupplyAccountInfoService;
import com.mzrd.util.Image;
@RequestMapping("/staff")
@Controller
public class StaffDesiredInfoController {
	@Autowired
	private DesiredInfoService desiredInfoService;
	@Autowired 
	private AdminInfoService adminInfoService;
	@Autowired
	private SupplyAccountInfoService supplyAccountInfoService;
	Image image = new Image();
	
	/*//删除询价
	@RequestMapping(value="/deleteStaff.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteStaff(StaffAccountInfo si){
		int dOK = staffAccountInfoService.deleteStaff(si);
		if(dOK == 1){
			return "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"删除失败\"}";
	}*/
	
	//添加询价
	@RequestMapping(value="/addStaffDesired.action",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addStaffDesired( @RequestParam(value = "file_upload", required = false) MultipartFile file,
			HttpSession session,DesiredInfo si,HttpServletRequest request) throws Exception{
		StaffAccountInfo staffInfo = (StaffAccountInfo) session.getAttribute("userInfo");
		si.setId(staffInfo.getId());
		String imagePath = null;
		 
		if (file != null && file.getSize() > 0) {  
        	imagePath = image.saveFile(file); 
        	si.setDesiredImage(imagePath);
        }  
		System.out.println(file + si.toString());
		int dOK = desiredInfoService.addDesiredInfo(si);
		if(dOK == 1){
			return "{\"success\":\"true\",\"message\":\"添加成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"添加失败\"}";
	}
	/*
	//更改员工信息
	@RequestMapping(value="/updateStaff.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateStaffPost(StaffAccountInfo si){
		if(si.getPassword() != null){
			String pass = null;
			try {
				pass = shaUitl.getPassword(si.getPassword());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			si.setPassword(pass);
		}
		int dOK = staffAccountInfoService.updateStaffAccount(si);
		if(dOK == 1){
			return "{\"success\":\"true\",\"message\":\"修改成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"修改失败\"}";
	}
	//获取所有的登录名
	@RequestMapping(value="/getAllNameList.action",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getAllNameList(StaffAccountInfo si,String name){
		 boolean isOk = false;
		AdminInfo sa = new AdminInfo();
		sa.setName(si.getUserName());
		List<String> ai = adminInfoService.getAdminNameList(sa);
		if(ai.size() != 0){
			isOk = true;  
		}
		List<String> sil = staffAccountInfoService.getStaffNameList(si,name);
		if(sil.size() != 0){
			isOk = true;  
		}
		SupplyAccountInfo supplyAccountInfo = new SupplyAccountInfo();
		supplyAccountInfo.setUserName(si.getUserName());
		List<String> sul = supplyAccountInfoService.getSupplyNameList(supplyAccountInfo,null);
		if(sul.size() != 0){
			isOk = true;  
		}
		return "{\"message\":\""+isOk+"\"}";
	}*/
	 @org.springframework.web.bind.annotation.InitBinder
	 public void InitBinder(ServletRequestDataBinder bin) {
	        bin.registerCustomEditor(Date.class, new CustomDateEditor(
	                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
}
