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
	
	//获取职位
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
	//获取职位
	@RequestMapping("/getPostInfoAndDepartmentInfoList.action")
	@ResponseBody
	public List getPostInfoAndDepartmentInfoList(DepartmentInfo di){
		return postInfoService.getPostInfoAndDepartmentInfoList(di);
	}
	//添加职位
	@RequestMapping(value="/addPostInfo.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addPost(PostInfo di){
		List<PostInfo> diList =  postInfoService.getPostInfoList(di);
		if(diList.size() != 0){
			return "{\"success\":\"false\",\"message\":\"职位已存在\"}";
		}
		int addOk = postInfoService.addPostInfo(di);
		if(addOk == 1){
			return "{\"success\":\"true\",\"message\":\"添加成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"添加失败\"}";
	}
	//修改职位
	@RequestMapping(value="/updatePostInfo.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updatePostInfo(PostInfo di){
		List<PostInfo> diList =  postInfoService.getPostInfoList(di);
		if(diList.size() != 0){
			return "{\"success\":\"false\",\"message\":\"职位已存在\"}";
		}
		int updateOk = postInfoService.updatePostInfo(di);
		if(updateOk == 1){
			return "{\"success\":\"true\",\"message\":\"修改成功\"}";
		}
		return "{\"success\":\"true\",\"message\":\"修改失败\"}";
	}
	//修改职位权限
	@RequestMapping(value="/updatePostInfoPower.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updatePostInfoPower(PostInfo di){
		int updateOk = postInfoService.updatePostInfoPower(di);
		if(updateOk == 1){
			return "{\"success\":\"true\",\"message\":\"权限修改成功\"}";
		}
		return "{\"success\":\"true\",\"message\":\"权限修改失败\"}";
	}
	//删除部门
	@RequestMapping(value="/deletePostInfo.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deletePostInfo(PostInfo di){
		//先查询员工表中有没有引用职位
		//在职有，不能删除
		StaffAccountInfo si = new StaffAccountInfo();
		si.setRid(di.getRid());
		si.setState(1);
		List<StaffAccountInfo> sil = staffAccountInfoService.getStaffAccountByState(si);
		if(sil.size() != 0){
			return "{\"success\":\"true\",\"message\":\"还有在职人员，不能删除，请先在员工管理删除员工\"}";
		}
		//离职中有，修改状态
		si.setState(0);
		List<StaffAccountInfo> sil1 = staffAccountInfoService.getStaffAccountByState(si);
		if(sil1.size() != 0){
			byte b=0;
			di.setState(b);
			int uOK = postInfoService.updatePostInfoByState(di);
			if(uOK == 1){
				return "{\"success\":\"true\",\"message\":\"删除成功\"}";
			}
			return "{\"success\":\"true\",\"message\":\"删除失败\"}";
		}
		//直接删除
		int deleteOk = postInfoService.deletePostInfo(di);
		if(deleteOk == 1){
			return "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}
		return "{\"success\":\"true\",\"message\":\"删除失败\"}";
	}
}
