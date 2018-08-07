package com.mzrd.controller;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzrd.pojo.AdminInfo;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.pojo.SupplierAccountInfo;
import com.mzrd.service.AdminInfoService;
import com.mzrd.service.StaffAccountInfoService;
import com.mzrd.service.SupplierAccountInfoService;
import com.mzrd.util.SHAUtil;
@RequestMapping("/admin")
@Controller
public class StaffAccountInfoController {
	@Autowired
	private StaffAccountInfoService staffAccountInfoService;
	@Autowired 
	private AdminInfoService adminInfoService;
	@Autowired
	private SupplierAccountInfoService supplierAccountInfoService;
	private SHAUtil shaUitl = new SHAUtil();
	//获取所有员工
	@RequestMapping("/getStaffInfoList.action")
	@ResponseBody
	public Map<String, Object> getStaffInfoList(int page, int rows,String state,String sname){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sname", sname);
		params.put("state", state);
		int totalCount =  staffAccountInfoService.getStaffAccountPage(params).size();
		
		params.put("start",(page - 1) * rows);
		params.put("limit",rows);
		System.out.println(state);
		List<StaffAccountInfo> dilist = staffAccountInfoService.getStaffAccountPage(params);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", totalCount);
	    result.put("rows", dilist);
		return result;
	}
	
	//删除员工
	@RequestMapping(value="/deleteStaff.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteStaff(StaffAccountInfo si){
		int dOK = staffAccountInfoService.deleteStaff(si);
		if(dOK == 1){
			return "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"删除失败\"}";
	}
	
	//添加员工
	@RequestMapping(value="/addStaff.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addStaff(StaffAccountInfo si){
		System.out.println(si.toString());
		if(si.getPassword() != null){
			String pass = null;
			try {
				pass = shaUitl.getPassword(si.getPassword());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			si.setPassword(pass);
		}
		int dOK = staffAccountInfoService.addStaff(si);
		if(dOK == 1){
			return "{\"success\":\"true\",\"message\":\"添加成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"添加失败\"}";
	}
	
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
		SupplierAccountInfo supplierAccountInfo = new SupplierAccountInfo();
		supplierAccountInfo.setUserName(si.getUserName());
		List<String> sul = supplierAccountInfoService.getSupplierNameList(supplierAccountInfo);
		if(sul.size() != 0){
			isOk = true;  
		}
		return "{\"message\":\""+isOk+"\"}";
	}
}
