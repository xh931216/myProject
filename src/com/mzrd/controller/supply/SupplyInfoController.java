package com.mzrd.controller.supply;

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
@RequestMapping("/supply")
@Controller
public class SupplyInfoController {
	@Autowired
	private SupplyAccountInfoService supplyAccountInfoService;
	private SHAUtil shaUitl = new SHAUtil();
	
	//供应商修改密码
	@RequestMapping(value = "/updateSupply.action" , produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateSupplyAccount(String newpass,HttpSession session){
		SupplyAccountInfo supplyInfo = (SupplyAccountInfo) session.getAttribute("userInfo");
		if(supplyInfo == null){
			return "请你先登录";
		}
		String pass = null;
		try {
			pass = shaUitl.getPassword(newpass);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		supplyInfo.setPassword(pass);
		int passOk = supplyAccountInfoService.updateSupply(supplyInfo);
		if(passOk == 1){
			return "密码修改成功";
		}
		return "密码修改失败";
	}
	//供应商修改信息
	@RequestMapping(value = "/updateSupplyMessage.action" , produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateSupplyMessage(SupplyAccountInfo si,HttpSession session){
		SupplyAccountInfo s = (SupplyAccountInfo) session.getAttribute("userInfo");
		si.setSid(s.getSid());
		int upOk = supplyAccountInfoService.updateSupply(si);
		if(upOk == 1){
			return "{\"success\":\"true\",\"message\":\"信息修改成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"信息修改失败\"}";
	}
	//供应商信息
	@RequestMapping("/getSupplyMessage.action")
	@ResponseBody
	public SupplyAccountInfo getSupplyMessage(HttpSession session){
		SupplyAccountInfo si = (SupplyAccountInfo) session.getAttribute("userInfo");
		SupplyAccountInfo sai = new SupplyAccountInfo();
		sai.setUserName(si.getUserName());
		sai.setPassword(si.getPassword());
		SupplyAccountInfo su = supplyAccountInfoService.getSupplyInfoByUserName(sai);
		return su;
	}
	
}
