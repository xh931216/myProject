package com.mzrd.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzrd.pojo.AdminInfo;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.pojo.SupplyAccountInfo;
import com.mzrd.service.AdminInfoService;
import com.mzrd.service.StaffAccountInfoService;
import com.mzrd.service.SupplyAccountInfoService;
import com.mzrd.util.SHAUtil;

@Controller
public class LoginController {
	@Autowired
	private AdminInfoService adminInfoService;
	@Autowired
	private StaffAccountInfoService staffAccountInfoService;
	@Autowired
	private SupplyAccountInfoService supplyAccountInfoService;
	private SHAUtil shaUitl = new SHAUtil();
	//µÇÂ¼ÕËºÅ
	@RequestMapping(value = "/login.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getAdmin(String userName,String password,HttpSession session){
		password = shaUitl.getPassword(password);
		System.out.println("fffffffffffff");
		// µÇÂ¼ÑéÖ¤
		AdminInfo ai = new AdminInfo();
		ai.setName(userName);
		ai.setPassword(password);
		AdminInfo adminInfo = adminInfoService.getAdmin(ai);
		if (adminInfo != null) {
			session.setAttribute("userInfo", adminInfo);
			return "{\"success\":\"true\",\"message\":\"admin/adminIndex.html\"}";
		}
		
		StaffAccountInfo si = new StaffAccountInfo();
		si.setUserName(userName);
		si.setPassword(password);
		StaffAccountInfo staffAccountInfo = staffAccountInfoService.getStaffAccount(si);
		if (staffAccountInfo != null) {
			session.setAttribute("userInfo", staffAccountInfo);
			return "{\"success\":\"true\",\"message\":\"staff/staffIndex.html\"}";
		}
		
		SupplyAccountInfo sai = new SupplyAccountInfo();
		sai.setUserName(userName);
		sai.setPassword(password);
		SupplyAccountInfo su = supplyAccountInfoService.getSupplyInfoByUserName(sai);
		if(su != null){
			session.setAttribute("userInfo", su);
			return "{\"success\":\"true\",\"message\":\"supply/supplyIndex.html\"}";
		}
			return "{\"success\":\"false\",\"message\":\"µÇÂ¼Ê§°Ü\"}";
	}
	
	
}
