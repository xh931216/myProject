package com.mzrd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzrd.dao.QuoteInfoDao;
import com.mzrd.pojo.QuoteInfo;
import com.mzrd.service.QuoteInfoService;

@Service("QuoteInfoService")
public class QuoteInfoServiceImpl implements QuoteInfoService{

	@Autowired
	private QuoteInfoDao quoteInfoDao;
	@Override
	public int addQuoteInfo(com.mzrd.pojo.QuoteInfo qi) {
		return quoteInfoDao.addQuoteInfo(qi);
	}
	@Override
	public QuoteInfo getQuoteInfo(QuoteInfo qi) {
		return quoteInfoDao.getQuoteInfo(qi);
	}
	@Override
	public List<QuoteInfo> getQuoteList(Map map) {
		return quoteInfoDao.getQuoteList(map);
	}
	@Override
	public int deleteQuoteInfo(QuoteInfo qi) {
		return quoteInfoDao.deleteQuoteInfo(qi);
	}
	@Override
	public int updateQuoteInfo(QuoteInfo qi) {
		return quoteInfoDao.updateQuoteInfo(qi);
	}
	@Override
	public List<QuoteInfo> getAllQuoteList(QuoteInfo qi) {
		return quoteInfoDao.getAllQuoteList(qi);
	}
}
