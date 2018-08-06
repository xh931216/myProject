package com.mzrd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzrd.pojo.DepartmentInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.service.PostInfoService;
import com.mzrd.dao.PostInfoDAO;
@Service("PostInfoService")
public class PostInfoServiceImpl implements PostInfoService{
	@Autowired
	private PostInfoDAO postInfoDao;
	

	@Override
	public int addPostInfo(PostInfo di) {
		return postInfoDao.addPostInfo(di);
	}

	@Override
	public int updatePostInfo(PostInfo di) {
		return postInfoDao.updatePostInfo(di);
	}

	@Override
	public int deletePostInfo(PostInfo di) {
		return postInfoDao.deletePostInfo(di);
	}

	@Override
	public List<PostInfo> getPostInfoList(PostInfo di) {
		return postInfoDao.getPostInfoList(di);
	}

	@Override
	public int updatePostInfoPower(PostInfo di) {
		return postInfoDao.updatePostInfoPower(di);
	}

	@Override
	public int updatePostInfoByState(PostInfo di) {
		return postInfoDao.updatePostInfoByState(di);
	}

	@Override
	public List<PostInfo> getPostInfoByStateList(PostInfo di) {
		return postInfoDao.getPostInfoByStateList(di);
	}

	@Override
	public List<PostInfo> getPostInfoPageList(Map di) {
		return postInfoDao.getPostInfoPageList(di);
	}

	@Override
	public List<PostInfo> getPostInfoAndDepartmentInfoList(DepartmentInfo di) {
		// TODO Auto-generated method stub
		return postInfoDao.getPostInfoAndDepartmentInfoList(di);
	}

}
