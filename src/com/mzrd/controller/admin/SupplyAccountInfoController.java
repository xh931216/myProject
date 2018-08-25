package com.mzrd.controller.admin;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mzrd.pojo.AdminInfo;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.pojo.SupplyAccountInfo;
import com.mzrd.pojo.SupplyRankInfo;
import com.mzrd.service.AdminInfoService;
import com.mzrd.service.StaffAccountInfoService;
import com.mzrd.service.SupplyAccountInfoService;
import com.mzrd.service.SupplyRankInfoService;
import com.mzrd.util.SHAUtil;
@RequestMapping("/admin")
@Controller
public class SupplyAccountInfoController {
	@Autowired
	private StaffAccountInfoService staffAccountInfoService;
	@Autowired 
	private AdminInfoService adminInfoService;
	@Autowired
	private SupplyAccountInfoService supplyAccountInfoService;
	private SHAUtil shaUitl=new SHAUtil();
	
	//获取供应类别
	@RequestMapping("/getSupplyInfoList.action")
	@ResponseBody
	public Map<String, Object> getSupplyInfoList(int page, int rows,String state,String supplierName,String srid){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("supplierName", supplierName);
		params.put("srid",srid);
		params.put("state", state);
		int totalCount =  supplyAccountInfoService.getSupplyInfoList(params).size();
		params.put("start",(page - 1) * rows);
		params.put("limit",rows);
		List<SupplyAccountInfo> silist = supplyAccountInfoService.getSupplyInfoList(params);
		Map<String, Object> result = new HashMap<String, Object>(2);
		result.put("total", totalCount);
	    result.put("rows", silist);
		return result;
	}
	//删除供应商
	@RequestMapping(value="/deleteSupply.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteSupply(SupplyAccountInfo si){
		int dOK = supplyAccountInfoService.deleteSupply(si);
		if(dOK == 1){
			return "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"删除失败\"}";
	}
	//修改供应商
	@RequestMapping(value="/updateSupply.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateSupply(SupplyAccountInfo si){
		int dOK = supplyAccountInfoService.updateSupply(si);
		if(dOK == 1){
			return "{\"success\":\"true\",\"message\":\"更改成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"更改失败\"}";
	}
	//修改供应商密码
	@RequestMapping(value="/updateSupplyPassword.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateSupplyPassword(SupplyAccountInfo si){
		String pass = null;
		try {
			pass = shaUitl.getPasswordOne();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		si.setPassword(pass);
		int dOK = supplyAccountInfoService.updateSupply(si);
		if(dOK == 1){
			return "{\"success\":\"true\",\"message\":\"更改成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"更改失败\"}";
	}
	//获取所有的登录名
	@RequestMapping(value="/getAllSupplyNameList.action",method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getAllSupplyNameList(SupplyAccountInfo sai,String name){
		boolean isOk = false;
		AdminInfo sa = new AdminInfo();
		sa.setName(sai.getUserName());
		List<String> ai = adminInfoService.getAdminNameList(sa);
		if(ai.size() != 0){
			isOk = true;  
		}
		StaffAccountInfo si = new StaffAccountInfo();
		si.setUserName(sai.getUserName());
		List<String> sil = staffAccountInfoService.getStaffNameList(si,null);
		if(sil.size() != 0){
			isOk = true;  
		}
		List<String> sul = supplyAccountInfoService.getSupplyNameList(sai,name);
		if(sul.size() != 0){
			isOk = true;  
		}
		return "{\"message\":\""+isOk+"\"}";
	}
	//添加供应商
	@RequestMapping(value="/addSupply.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addSupply(SupplyAccountInfo si,String[] rankList){
		String pass = null;
		try {
			pass = shaUitl.getPasswordOne();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		si.setPassword(pass);
		
		int dOK = supplyAccountInfoService.addSupply(si,rankList);
		if(dOK == 1){
			return "{\"success\":\"true\",\"message\":\"添加成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"添加失败\"}";
	}
}
