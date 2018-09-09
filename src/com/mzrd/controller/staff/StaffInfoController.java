package com.mzrd.controller.staff;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzrd.pojo.AdminInfo;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.service.AdminInfoService;
import com.mzrd.service.StaffAccountInfoService;
import com.mzrd.util.SHAUtil;
@RequestMapping("/staff")
@Controller
public class StaffInfoController {
	@Autowired
	private StaffAccountInfoService staffAccountInfoService;
	private SHAUtil shaUitl = new SHAUtil();
	
	//员工修改密码
	@RequestMapping(value = "/updateStaff.action" , produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateStaffAccount(StaffAccountInfo si,HttpSession session){
		StaffAccountInfo staffInfo = (StaffAccountInfo) session.getAttribute("userInfo");
		
		String pass = null;
		try {
			pass = shaUitl.getPassword(si.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		staffInfo.setPassword(pass);
		int passOk = staffAccountInfoService.updateStaffAccount(staffInfo);
		if(passOk == 1){
			return "密码修改成功";
		}
		return "密码修改失败";
	}
	//员工修改信息
	@RequestMapping(value = "/updateStaffMessage.action" , produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateStaffAccountMessage(StaffAccountInfo si,HttpSession session){
		StaffAccountInfo staffInfo = (StaffAccountInfo) session.getAttribute("userInfo");
		
		staffInfo.setPhone(si.getPhone());
		staffInfo.setSname(si.getSname());
		staffInfo.setEmail(si.getEmail());
		int upOk = staffAccountInfoService.updateStaffAccount(staffInfo);

		if(upOk == 1){
			return "{\"success\":\"true\",\"message\":\"信息修改成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"信息修改失败\"}";
	}
	//员工信息
	@RequestMapping("/getStaffMessage.action")
	@ResponseBody
	public StaffAccountInfo getStaffAccountMessage(HttpSession session){
		StaffAccountInfo si = (StaffAccountInfo) session.getAttribute("userInfo");
		StaffAccountInfo si1 = new StaffAccountInfo();
		si1.setUserName(si.getUserName());
		si1.setPassword(si.getPassword());
		StaffAccountInfo staffAccountInfo = staffAccountInfoService.getStaffAccount(si1);
		return staffAccountInfo;
	}
	
}
