package com.mzrd.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzrd.pojo.SupplyRankInfo;
import com.mzrd.pojo.SupplyRankRelationInfo;
import com.mzrd.service.SupplyRankRelationInfoService;

@RequestMapping("/admin")
@Controller
public class SupplyRankRelationController {
	@Autowired
	private SupplyRankRelationInfoService supplyRankRelationInfoService;
	//��ȡ��Ӧ���
	@RequestMapping("/getSupplyRankRelation.action")
	@ResponseBody
	public List getSupplyRankRelation(SupplyRankRelationInfo pi){
		return supplyRankRelationInfoService.getSupplyRankRelation(pi);
	}
	//���¹�Ӧ�̵Ĺ�Ӧ���
	@RequestMapping(value="/updateSupplyRankRelation.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateSupplyRank(SupplyRankRelationInfo pi,String[] upRankList){
		int dOK = supplyRankRelationInfoService.updateSupplyRankRelation(pi,upRankList);
		if(dOK == 1){
			return "{\"success\":\"true\",\"message\":\"�޸ĳɹ�\"}";
		}
		return "{\"success\":\"false\",\"message\":\"�޸�ʧ��\"}";
	}
}
