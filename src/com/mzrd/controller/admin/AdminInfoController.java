package com.mzrd.controller.admin;

import java.security.NoSuchAlgorithmException;

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
@RequestMapping("/admin")
@Controller
public class AdminInfoController {
	@Autowired
	private StaffAccountInfoService staffAccountInfoService;
	@Autowired
	private AdminInfoService adminInfoService;
	private SHAUtil shaUitl = new SHAUtil();
	
	//管理员修改密码
	@RequestMapping(value = "/updateAdmin.action" , produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateStaffAccount(String newpass,HttpSession session){
		AdminInfo adminInfo = (AdminInfo) session.getAttribute("userInfo");
		if(adminInfo == null){
			return "请你先登录";
		}
		String pass = null;
		try {
			pass = shaUitl.getPassword(newpass);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		adminInfo.setPassword(pass);
		int passOk = adminInfoService.updateAdmin(adminInfo);
		if(passOk == 1){
			return "密码修改成功";
		}
		return "密码修改失败";
	}
	
	
}
