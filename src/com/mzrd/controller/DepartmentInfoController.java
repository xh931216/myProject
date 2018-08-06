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
	
	//获取所有部门
	@RequestMapping("/getDepartmentInfoList.action")
	@ResponseBody
	public List<DepartmentInfo> getDepartmentInfoList(){
		List<DepartmentInfo> diList =  departmentInfoService.getDepartmentList();
		return diList;
	}
	//添加部门
	@RequestMapping(value="/addDepartmentInfoList.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addDepartmentInfo(DepartmentInfo di){
	    DepartmentInfo dinfo =	departmentInfoService.getDepartment(di);
		if(dinfo != null){
			return "{\"success\":\"false\",\"message\":\"部门已存在\"}";
		}
		int addOk = departmentInfoService.addDepartmentInfo(di);
		if(addOk == 1){
			return "{\"success\":\"true\",\"message\":\"添加成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"添加失败\"}";
	}
	//修改部门
	@RequestMapping(value="/updateDepartmentInfo.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateDepartmentInfo(DepartmentInfo di){
	    DepartmentInfo dinfo =	departmentInfoService.getDepartment(di);
		if(dinfo != null){
			return "{\"success\":\"false\",\"message\":\"部门已存在·\"}";
		}
		int updateOk = departmentInfoService.updateDepartmentInfo(di);
		if(updateOk == 1){
			return "{\"success\":\"true\",\"message\":\"修改成功\"}";
		}
		return "{\"success\":\"true\",\"message\":\"修改失败\"}";
	}
	//删除部门
	@RequestMapping(value="/deleteDepartmentInfo.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteDepartmentInfo(DepartmentInfo di){
		//先查询职位中有没有引用部门
		//职位 状态为1，先删除职位
		PostInfo pi = new PostInfo();
		pi.setDid(di.getDid());
		byte b=1;
		pi.setState(b);
	    List<PostInfo> pil = postInfoService.getPostInfoByStateList(pi);
	    if(pil.size()!=0){
			return "{\"success\":\"true\",\"message\":\"部门中存在职位，不能删除，先删除职位\"}";
	    }
	    b=0;
	    pi.setState(b);
	    List<PostInfo> pil1 = postInfoService.getPostInfoByStateList(pi);
	    if(pil1.size()!=0){
	    	di.setState(b);
	    	int dOk = departmentInfoService.updateDepartmentInfoByState(di);
	    	if(dOk == 1){
				return "{\"success\":\"true\",\"message\":\"删除成功\"}";
			}
			return "{\"success\":\"true\",\"message\":\"删除失败\"}";
	    }
		//职位 状态为0，修改状态
		//直接删除
		int deleteOk = departmentInfoService.deleteDepartmentInfo(di);
		if(deleteOk == 1){
			return "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}
		return "{\"success\":\"true\",\"message\":\"删除失败\"}";
	}
}
