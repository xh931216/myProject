package com.mzrd.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzrd.dao.QuoteSupplyImageInfoDao;
import com.mzrd.pojo.QuoteSupplyImageInfo;
import com.mzrd.service.QuoteSupplyImageInfoService;

@Service("QuoteSupplyImageInfoService")
public class QuoteSupplyImageInfoServiceImpl implements QuoteSupplyImageInfoService{

	@Autowired
	private QuoteSupplyImageInfoDao quoteSupplyImageInfoDao;

	@Override
	public int addQuoteInfo(QuoteSupplyImageInfo qsi) {
		return quoteSupplyImageInfoDao.addImageQuoteInfo(qsi);
	}

	@Override
	public QuoteSupplyImageInfo getImageUrl(int deid,int sid) {
		Map map = new HashMap<>();
		map.put("deid",deid);
		map.put("sid", sid);
		return quoteSupplyImageInfoDao.getImageUrl(map);
	}
	
}
