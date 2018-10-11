package com.mzrd.controller.supply;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mzrd.pojo.DesiredDetailsInfo;
import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.QuoteInfo;
import com.mzrd.pojo.QuoteSupplyImageInfo;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.pojo.SupplyAccountInfo;
import com.mzrd.pojo.SupplyRankInfo;
import com.mzrd.service.QuoteInfoService;
import com.mzrd.service.QuoteSupplyImageInfoService;
import com.mzrd.util.Image1;
import com.sun.org.apache.bcel.internal.generic.FMUL;
@RequestMapping("/supply")
@Controller
public class SupplyQuoteInfoController {
	@Autowired
	private QuoteInfoService quoteInfoService;
	@Autowired
	private QuoteSupplyImageInfoService quoteSupplyImageInfoService;
	Image1 image = new Image1();
	//获取所有类别
	@RequestMapping("/getQuoteList.action")
	@ResponseBody
	public Map<String, Object> getQuoteList(int page, int rows,String state,String srid,HttpSession session){
		SupplyAccountInfo supplyAccountInfo = (SupplyAccountInfo) session.getAttribute("userInfo");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sid", supplyAccountInfo.getSid());
		params.put("srid", srid);
		params.put("state", state);
		int totalCount =  quoteInfoService.getQuoteList(params).size();
		params.put("start",(page - 1) * rows);
		params.put("limit",rows);
		List<QuoteInfo> dilist = quoteInfoService.getQuoteList(params);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", totalCount);
		result.put("rows", dilist);
		return result;
	}
	//添加报价单
	@RequestMapping(value="/addQuote.action",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addQuote( @RequestParam(value = "file_upload", required = false) MultipartFile file,Date quoteDate,
			HttpSession session,String shareItemDatas,int deid,HttpServletRequest request)throws Exception{
		SupplyAccountInfo staffInfo = (SupplyAccountInfo) session.getAttribute("userInfo");
		DesiredInfo di = new DesiredInfo();
		di.setDeid(deid);
		String imagePath = null;
		if (file != null && file.getSize() > 0) {  
        	imagePath = image.saveFile(file,request); 
        } 
		System.out.println(deid+""+staffInfo.getSid());
		List<QuoteSupplyImageInfo> ql =  quoteSupplyImageInfoService.getImageUrlList(deid,staffInfo.getSid());
		if(ql.size()!=0){
			System.out.println(imagePath+";"+quoteDate);
			 int qu = quoteInfoService.updateQuoteInfo(shareItemDatas,staffInfo,imagePath,deid,quoteDate);
			 if(qu == 1){
				return "{\"success\":\"true\",\"message\":\"报价修改成功\"}";
			}
			return "{\"success\":\"false\",\"message\":\"报价修改失败\"}";
		}
		int dOK = quoteInfoService.addQuoteInfo(shareItemDatas,staffInfo,imagePath,deid,quoteDate);
		if(dOK == 1){
			return "{\"success\":\"true\",\"message\":\"报价添加成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"报价添加失败\"}";
	}
	
	//删除报价
	@RequestMapping(value="/deleteQuoteInfo.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteQuoteInfo(QuoteInfo si){
		int dOK = quoteInfoService.deleteQuoteInfo(si);
		if(dOK == 1){
			return "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}
		return "{\"success\":\"false\",\"message\":\"删除失败\"}";
	}
	
	 @org.springframework.web.bind.annotation.InitBinder
	 public void InitBinder(ServletRequestDataBinder bin) {
	        bin.registerCustomEditor(Date.class, new CustomDateEditor(
	                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
}
