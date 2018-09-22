package com.mzrd.controller.staff;

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
import com.mzrd.service.DesiredDetailsInfoService;
import com.mzrd.service.DesiredInfoService;
import com.mzrd.service.QuoteInfoService;
import com.mzrd.service.QuoteSupplyImageInfoService;
import com.mzrd.service.StaffAccountInfoService;
import com.mzrd.service.SupplyAccountInfoService;
import com.mzrd.util.Image1;
import com.mzrd.util.PdfUtils;
import com.sun.org.apache.bcel.internal.generic.FMUL;
@RequestMapping("/staff")
@Controller
public class StaffQuoteInfoController {
	@Autowired
	private QuoteInfoService quoteInfoService;
	@Autowired
	private DesiredInfoService desiredInfoService;
	@Autowired
	private DesiredDetailsInfoService desiredDetailsInfoService;
	@Autowired
	private StaffAccountInfoService staffAccountInfoService;
	@Autowired
	private SupplyAccountInfoService supplyAccountInfoService;
	@Autowired
	private QuoteSupplyImageInfoService quoteSupplyImageInfoService;
	Image1 image = new Image1();
	PdfUtils pdfUtils = new PdfUtils();
	//获取所有报价
	@RequestMapping("/getStaffQuoteList.action")
	@ResponseBody
	public Map<String, Object> getStaffQuoteList(int page, int rows,String userName,
			String overDate,String srid,HttpSession session){
			StaffAccountInfo staffInfo = (StaffAccountInfo) session.getAttribute("userInfo");
			System.out.println(staffInfo.toString());
			Map<String, Object> params = new HashMap<String, Object>();	
			params.put("srid", srid);
			params.put("overDate", overDate);
			params.put("userName", userName);
			if(staffInfo.getPostInfo().getRname().equals("采购员")){
				params.put("id", staffInfo.getId());
			}
			if(staffInfo.getPostInfo().getRname().equals("经理")){
				params.put("did", staffInfo.getPostInfo().getDid());
			}
			System.out.println(params.get("select")+","+params.get("did")+","+params.get("id"));
			int totalCount =  desiredInfoService.getStaffQuoteList(params).size();
			params.put("start",(page - 1) * rows);
			params.put("limit",rows);
			List<DesiredInfo> dilist = desiredInfoService.getStaffQuoteList(params);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("total", totalCount);
			result.put("rows", dilist);
			return result;
	}
		//获取报价单pdf
		@RequestMapping(value="/getSupplyQuotePdf.action")
		@ResponseBody
		public ResponseEntity<byte[]> getSupplyQuotePdf(int deid,int sid,int state,HttpServletResponse response,
				HttpServletRequest request,HttpSession session) throws IOException{
			List<DesiredDetailsInfo> list = desiredDetailsInfoService.getStaffDesiredDetaiSupplylsList(deid, sid);
			DesiredInfo di = new DesiredInfo();
			di.setDeid(deid);
			di = desiredInfoService.getDesiredInfoPdf(di);
			StaffAccountInfo sa = new StaffAccountInfo();
			sa.setId(di.getId());
			StaffAccountInfo staffInfo = staffAccountInfoService.getStaffAccountById(sa);
		    QuoteSupplyImageInfo qsi =	quoteSupplyImageInfoService.getImageUrl(deid, sid);
		    SupplyAccountInfo supplyAccountInfo = supplyAccountInfoService.getStaffQuoteSupply(sid);
			return pdfUtils.saveStaffQuotePdf(response,list,di,staffInfo,supplyAccountInfo,state,request,qsi);	
		}
	//获取所有类别
	@RequestMapping("/getAllQuoteList.action")
	@ResponseBody
	public List getRankAllNameList(QuoteInfo qi){
		return quoteInfoService.getAllQuoteList(qi);
	}
	
	 @org.springframework.web.bind.annotation.InitBinder
	 public void InitBinder(ServletRequestDataBinder bin) {
	        bin.registerCustomEditor(Date.class, new CustomDateEditor(
	                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
}
