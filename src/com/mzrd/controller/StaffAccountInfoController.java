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
	//Ա����¼�˺�
	@RequestMapping(value = "/staffAccountLogin.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getStaffAccount(StaffAccountInfo sa,HttpSession session){
		
		try {
			sa.setPassword(shaUitl.getPassword(sa.getPassword())); 
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// ��¼��֤
		StaffAccountInfo staffAccountInfo = staffAccountInfoService.getStaffAccount(sa);
		if (staffAccountInfo != null) {
			session.setAttribute("staffAccountInfo", staffAccountInfo);
			//Ա������
			String rank = staffAccountInfo.getPostInfo().getRname(); 
			// ��JSON��ʽ��ҳ�淢�ͳɹ���Ϣ
			return "{\"success\":\"true\",\"message\":\""+rank+"\"}";
		} else
			return "{\"success\":\"false\",\"message\":\"��¼ʧ��\"}";
	}
	
	//�޸�����
	@RequestMapping(value = "/admin/updateStaffAccount.action" , produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateStaffAccount(String newpass,HttpSession session){
		StaffAccountInfo staffAccountInfo = (StaffAccountInfo) session.getAttribute("staffAccountInfo");
		if(staffAccountInfo == null){
			return "�����ȵ�¼";
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
			return "�����޸ĳɹ�";
		}
		return "�����޸�ʧ��";
	}
}
