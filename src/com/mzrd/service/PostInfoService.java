package com.mzrd.service;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.DepartmentInfo;
import com.mzrd.pojo.PostInfo;

public interface PostInfoService {

	public List<PostInfo> getPostInfoList(PostInfo di);
	public List<PostInfo> getPostInfoAndDepartmentInfoList(DepartmentInfo di);
	public List<PostInfo> getPostInfoPageList(Map di);
	public List<PostInfo> getPostInfoByStateList(PostInfo di);
	public int addPostInfo(PostInfo di);
	public int updatePostInfo(PostInfo di);
	public int updatePostInfoPower(PostInfo di);
	public int updatePostInfoByState(PostInfo di);
	public int deletePostInfo(PostInfo di);
}
