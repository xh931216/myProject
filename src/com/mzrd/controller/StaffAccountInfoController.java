package com.mzrd.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.service.StaffAccountInfoService;
import com.mzrd.util.SHAUtil;

@Controller
public class StaffAccountInfoController {
	@Autowired
	private StaffAccountInfoService staffAccountInfoService;
	private SHAUtil shaUitl = new SHAUtil();
	//员工登录账号
	@RequestMapping(value = "/staffAccountLogin.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getStaffAccount(StaffAccountInfo sa,HttpSession session){
		
		try {
			sa.setPassword(shaUitl.getPassword(sa.getPassword())); 
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 登录验证
		StaffAccountInfo staffAccountInfo = staffAccountInfoService.getStaffAccount(sa);
		if (staffAccountInfo != null) {
			session.setAttribute("staffAccountInfo", staffAccountInfo);
			//员工级别
			String rank = staffAccountInfo.getPostInfo().getRname(); 
			// 以JSON格式向页面发送成功信息
			return "{\"success\":\"true\",\"message\":\""+rank+"\"}";
		} else
			return "{\"success\":\"false\",\"message\":\"登录失败\"}";
	}
	
	//修改密码
	@RequestMapping(value = "/admin/updateStaffAccount.action" , produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateStaffAccount(String newpass,HttpSession session){
		StaffAccountInfo staffAccountInfo = (StaffAccountInfo) session.getAttribute("staffAccountInfo");
		if(staffAccountInfo == null){
			return "请你先登录";
		}
		String pass = null;
		try {
			pass = shaUitl.getPassword(newpass);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		staffAccountInfo.setPassword(pass);
		int passOk = staffAccountInfoService.updateStaffAccount(staffAccountInfo);
		if(passOk == 1){
			return "密码修改成功";
		}
		return "密码修改失败";
	}
}
