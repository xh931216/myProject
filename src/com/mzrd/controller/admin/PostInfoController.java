package com.mzrd.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzrd.pojo.DepartmentInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.service.PostInfoService;
import com.mzrd.service.StaffAccountInfoService;
@RequestMapping("/admin")
@Controller
public class PostInfoController {
	@Autowired
	private PostInfoService postInfoService;
	@Autowired
	private StaffAccountInfoService staffAccountInfoService;
	
	//��ȡְλ
	@RequestMapping("/getPostInfoList.action")
	@ResponseBody
	public Map<String, Object> getPostInfoList(int page, int rows,PostInfo pi){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("did", pi.getDid());
		params.put("rname", pi.getRname());
		int totalCount =  postInfoService.getPostInfoPageList(params).size();
		params.put("start",(page - 1) * rows);
		params.put("limit",rows);
		List<PostInfo> dilist = postInfoService.getPostInfoPageList(params);
		Map<String, Object> result = new HashMap<String, Object>(2);
		result.put("total", totalCount);
	    result.put("rows", dilist);
		return result;
	}
	//��ȡְλ
	@RequestMapping("/getPostInfoAndDepartmentInfoList.action")
	@ResponseBody
	public List getPostInfoAndDepartmentInfoList(DepartmentInfo di){
		return postInfoService.getPostInfoAndDepartmentInfoList(di);
	}
	//���ְλ
	@RequestMapping(value="/addPostInfo.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addPost(PostInfo di){
		List<PostInfo> diList =  postInfoService.getPostInfoList(di);
		if(diList.size() != 0){
			return "{\"success\":\"false\",\"message\":\"ְλ�Ѵ���\"}";
		}
		int addOk = postInfoService.addPostInfo(di);
		if(addOk == 1){
			return "{\"success\":\"true\",\"message\":\"��ӳɹ�\"}";
		}
		return "{\"success\":\"false\",\"message\":\"���ʧ��\"}";
	}
	//�޸�ְλ
	@RequestMapping(value="/updatePostInfo.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updatePostInfo(PostInfo di){
		List<PostInfo> diList =  postInfoService.getPostInfoList(di);
		if(diList.size() != 0){
			return "{\"success\":\"false\",\"message\":\"ְλ�Ѵ���\"}";
		}
		int updateOk = postInfoService.updatePostInfo(di);
		if(updateOk == 1){
			return "{\"success\":\"true\",\"message\":\"�޸ĳɹ�\"}";
		}
		return "{\"success\":\"true\",\"message\":\"�޸�ʧ��\"}";
	}
	//�޸�ְλȨ��
	@RequestMapping(value="/updatePostInfoPower.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updatePostInfoPower(PostInfo di){
		int updateOk = postInfoService.updatePostInfoPower(di);
		if(updateOk == 1){
			return "{\"success\":\"true\",\"message\":\"Ȩ���޸ĳɹ�\"}";
		}
		return "{\"success\":\"true\",\"message\":\"Ȩ���޸�ʧ��\"}";
	}
	//ɾ������
	@RequestMapping(value="/deletePostInfo.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deletePostInfo(PostInfo di){
		//�Ȳ�ѯԱ��������û������ְλ
		//��ְ�У�����ɾ��
		StaffAccountInfo si = new StaffAccountInfo();
		si.setRid(di.getRid());
		si.setState(1);
		List<StaffAccountInfo> sil = staffAccountInfoService.getStaffAccountByState(si);
		if(sil.size() != 0){
			return "{\"success\":\"true\",\"message\":\"������ְ��Ա������ɾ����������Ա������ɾ��Ա��\"}";
		}
		//��ְ���У��޸�״̬
		si.setState(0);
		List<StaffAccountInfo> sil1 = staffAccountInfoService.getStaffAccountByState(si);
		if(sil1.size() != 0){
			byte b=0;
			di.setState(b);
			int uOK = postInfoService.updatePostInfoByState(di);
			if(uOK == 1){
				return "{\"success\":\"true\",\"message\":\"ɾ���ɹ�\"}";
			}
			return "{\"success\":\"true\",\"message\":\"ɾ��ʧ��\"}";
		}
		//ֱ��ɾ��
		int deleteOk = postInfoService.deletePostInfo(di);
		if(deleteOk == 1){
			return "{\"success\":\"true\",\"message\":\"ɾ���ɹ�\"}";
		}
		return "{\"success\":\"true\",\"message\":\"ɾ��ʧ��\"}";
	}
}
