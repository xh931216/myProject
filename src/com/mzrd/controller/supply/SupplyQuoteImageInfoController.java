package com.mzrd.controller.supply;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.QuoteInfo;
import com.mzrd.pojo.QuoteSupplyImageInfo;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.pojo.SupplyAccountInfo;
import com.mzrd.pojo.SupplyRankInfo;
import com.mzrd.service.QuoteInfoService;
import com.mzrd.service.QuoteSupplyImageInfoService;
import com.mzrd.util.Image;
import com.sun.org.apache.bcel.internal.generic.FMUL;
@RequestMapping("/supply")
@Controller
public class SupplyQuoteImageInfoController {
	@Autowired
	private QuoteSupplyImageInfoService quoteSupplyImageInfoService;
	
	//获取所有类别
	@RequestMapping("/getImageUrl.action")
	@ResponseBody
	public QuoteSupplyImageInfo getImageUrl(int deid){
		QuoteSupplyImageInfo qi = quoteSupplyImageInfoService.getImageUrl(deid);
		if(qi!=null){
			return qi;
		}
		return new QuoteSupplyImageInfo();
	}

}
