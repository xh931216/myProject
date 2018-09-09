package com.mzrd.service.impl;

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
	public QuoteSupplyImageInfo getImageUrl(int deid) {
		
		return quoteSupplyImageInfoDao.getImageUrl(deid);
	}
	
}
