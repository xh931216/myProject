package com.mzrd.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzrd.pojo.DepartmentInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.service.DepartmentInfoService;
import com.mzrd.service.PostInfoService;
@RequestMapping("/admin")
@Controller
public class DepartmentInfoController {
	@Autowired
	private DepartmentInfoService departmentInfoService;
	@Autowired
	private PostInfoService postInfoService;
	
	//��ȡ���в���
	@RequestMapping("/getDepartmentInfoList.action")
	@ResponseBody
	public List<DepartmentInfo> getDepartmentInfoList(){
		List<DepartmentInfo> diList =  departmentInfoService.getDepartmentList();
		return diList;
	}
	//��Ӳ���
	@RequestMapping(value="/addDepartmentInfoList.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addDepartmentInfo(DepartmentInfo di){
	    DepartmentInfo dinfo =	departmentInfoService.getDepartment(di);
		if(dinfo != null){
			return "{\"success\":\"false\",\"message\":\"�����Ѵ���\"}";
		}
		int addOk = departmentInfoService.addDepartmentInfo(di);
		if(addOk == 1){
			return "{\"success\":\"true\",\"message\":\"��ӳɹ�\"}";
		}
		return "{\"success\":\"false\",\"message\":\"���ʧ��\"}";
	}
	//�޸Ĳ���
	@RequestMapping(value="/updateDepartmentInfo.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateDepartmentInfo(DepartmentInfo di){
	    DepartmentInfo dinfo =	departmentInfoService.getDepartment(di);
		if(dinfo != null){
			return "{\"success\":\"false\",\"message\":\"�����Ѵ��ڡ�\"}";
		}
		int updateOk = departmentInfoService.updateDepartmentInfo(di);
		if(updateOk == 1){
			return "{\"success\":\"true\",\"message\":\"�޸ĳɹ�\"}";
		}
		return "{\"success\":\"true\",\"message\":\"�޸�ʧ��\"}";
	}
	//ɾ������
	@RequestMapping(value="/deleteDepartmentInfo.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteDepartmentInfo(DepartmentInfo di){
		//�Ȳ�ѯְλ����û�����ò���
		//ְλ ״̬Ϊ1����ɾ��ְλ
		PostInfo pi = new PostInfo();
		pi.setDid(di.getDid());
		byte b=1;
		pi.setState(b);
	    List<PostInfo> pil = postInfoService.getPostInfoByStateList(pi);
	    if(pil.size()!=0){
			return "{\"success\":\"true\",\"message\":\"�����д���ְλ������ɾ������ɾ��ְλ\"}";
	    }
	    b=0;
	    pi.setState(b);
	    List<PostInfo> pil1 = postInfoService.getPostInfoByStateList(pi);
	    if(pil1.size()!=0){
	    	di.setState(b);
	    	int dOk = departmentInfoService.updateDepartmentInfoByState(di);
	    	if(dOk == 1){
				return "{\"success\":\"true\",\"message\":\"ɾ���ɹ�\"}";
			}
			return "{\"success\":\"true\",\"message\":\"ɾ��ʧ��\"}";
	    }
		//ְλ ״̬Ϊ0���޸�״̬
		//ֱ��ɾ��
		int deleteOk = departmentInfoService.deleteDepartmentInfo(di);
		if(deleteOk == 1){
			return "{\"success\":\"true\",\"message\":\"ɾ���ɹ�\"}";
		}
		return "{\"success\":\"true\",\"message\":\"ɾ��ʧ��\"}";
	}
}
