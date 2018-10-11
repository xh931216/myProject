package com.mzrd.service.impl;

import java.util.HashMap;
import java.util.List;
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
		QuoteSupplyImageInfo qsii = quoteSupplyImageInfoDao.getImageUrl(map);

		return qsii;
	}

	@Override
	public List<QuoteSupplyImageInfo> getImageUrlList(int deid, int sid) {
		Map map = new HashMap<>();
		map.put("deid",deid);
		map.put("sid", sid);
		System.out.println(deid+"fdsfdsf"+sid);
		return quoteSupplyImageInfoDao.getImageUrlList(map);
	}
	
}
