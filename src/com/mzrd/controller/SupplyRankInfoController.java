package com.mzrd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzrd.pojo.SupplyRankInfo;
import com.mzrd.service.SupplyRankInfoService;
@RequestMapping("/admin")
@Controller
public class SupplyRankInfoController {
	@Autowired
	private SupplyRankInfoService supplyRankInfoService;
	
	//��ȡ��Ӧ���
	@RequestMapping("/getSupplyRankInfoList.action")
	@ResponseBody
	public Map<String, Object> getPostInfoList(int page, int rows,SupplyRankInfo pi){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("srname", pi.getSrname());
		int totalCount =  supplyRankInfoService.getSupplyRankInfoList(params).size();
		params.put("start",(page - 1) * rows);
		params.put("limit",rows);
		List<SupplyRankInfo> silist = supplyRankInfoService.getSupplyRankInfoList(params);
		Map<String, Object> result = new HashMap<String, Object>(2);
		result.put("total", totalCount);
	    result.put("rows", silist);
		return result;
	}
	//������
	@RequestMapping(value="/addSuplyRankInfo.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addSuplyRankInfo(SupplyRankInfo pi){
		String lodName = "";
		List<String> sil = supplyRankInfoService.getRankAllNameList(pi,lodName);
		if(sil.size() != 0){
			return "{\"success\":\"false\",\"message\":\"����Ѵ���\"}";
		}
		int addOk = supplyRankInfoService.addSuplyRankInfo(pi);
		if(addOk == 1){
			return "{\"success\":\"true\",\"message\":\"�����ӳɹ�\"}";
		}
		return "{\"success\":\"false\",\"message\":\"������ʧ��\"}";
	}
	//�޸����
	@RequestMapping(value="/updateSupplyRankInfo.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateSupplyRankInfo(SupplyRankInfo pi, String lodName){
		List<String> sil = supplyRankInfoService.getRankAllNameList(pi,lodName);
		if(sil.size() != 0){
			return "{\"success\":\"false\",\"message\":\"����Ѵ���\"}";
		}
		int updateOk = supplyRankInfoService.updateSupplyRankInfo(pi);
		if(updateOk == 1){
			return "{\"success\":\"true\",\"message\":\"����޸ĳɹ�\"}";
		}
		return "{\"success\":\"true\",\"message\":\"����޸�ʧ��\"}";
	}
	//ɾ�����
	@RequestMapping(value="/deleteSupplyRankInfo.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteSupplyRankInfo(SupplyRankInfo pi){
		int deleteOk = supplyRankInfoService.deleteSupplyRankInfo(pi);
		if(deleteOk == 1){
			return "{\"success\":\"true\",\"message\":\"���ɾ���ɹ�\"}";
		}
		return "{\"success\":\"true\",\"message\":\"���ɾ��ʧ��\"}";
	}
	
}
