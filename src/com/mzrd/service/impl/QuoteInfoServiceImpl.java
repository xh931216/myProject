package com.mzrd.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzrd.dao.QuoteInfoDao;
import com.mzrd.dao.QuoteSupplyImageInfoDao;
import com.mzrd.pojo.DesiredDetailsInfo;
import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.QuoteInfo;
import com.mzrd.pojo.QuoteSupplyImageInfo;
import com.mzrd.pojo.SupplyAccountInfo;
import com.mzrd.service.QuoteInfoService;
import com.mzrd.util.JSONUtil;

@Service("QuoteInfoService")
public class QuoteInfoServiceImpl implements QuoteInfoService{

	@Autowired
	private QuoteInfoDao quoteInfoDao;
	@Autowired
	private QuoteSupplyImageInfoDao quoteSupplyImageInfoDao;
	JSONUtil jsonUtil = new JSONUtil();
	@Override
	public int addQuoteInfo(String shareItemDatas,SupplyAccountInfo si,
			String imageUrl,int deid,Date quoteDate) {
		
		
		int dad = 0;
		List<DesiredDetailsInfo> list = jsonUtil.strToList(shareItemDatas,DesiredDetailsInfo.class);
		for (DesiredDetailsInfo ps : list) {
			QuoteInfo qi = new QuoteInfo();
			qi.setDedid(ps.getDedid());
			qi.setPrice(ps.getPrice());
			qi.setQid(ps.getQid());
			qi.setRemark(ps.getRemark());
			qi.setSid(si.getSid());
			dad = quoteInfoDao.addQuoteInfo(qi);
		}
		if(dad==0){
			return 0;
		}
		QuoteSupplyImageInfo qsii = new QuoteSupplyImageInfo();
		qsii.setSid(si.getSid());
		qsii.setImageUrl(imageUrl);
		qsii.setQuoteDate(quoteDate);
		qsii.setDeid(deid);
		int qid =  quoteSupplyImageInfoDao.addImageQuoteInfo(qsii);
		
		return qid;
	}
	@Override
	public List<QuoteInfo> getQuoteInfo(int deid,int sid) {
		Map map = new HashMap<>();
		map.put("sid", sid);
		map.put("deid", deid);
		return quoteInfoDao.getQuoteInfo(map);
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
	public int updateQuoteInfo(String shareItemDatas,SupplyAccountInfo si,
			String imageUrl,int deid,Date quoteDate) {
		int dad=0;
		List<DesiredDetailsInfo> list = jsonUtil.strToList(shareItemDatas,DesiredDetailsInfo.class);
		for (DesiredDetailsInfo ps : list) {
			QuoteInfo qi = new QuoteInfo();
			qi.setDedid(ps.getDedid());
			qi.setPrice(ps.getPrice());
			qi.setQid(ps.getQid());
			qi.setRemark(ps.getRemark());
			qi.setSid(ps.getSid());
			dad = quoteInfoDao.updateQuoteInfo(qi);
        }
		QuoteSupplyImageInfo qsii = new QuoteSupplyImageInfo();
		qsii.setSid(si.getSid());
		qsii.setImageUrl(imageUrl);
		qsii.setQuoteDate(quoteDate);
		qsii.setDeid(deid);
		int qid =  quoteSupplyImageInfoDao.updateImageQuoteInfo(qsii);
		return dad;
	}
	@Override
	public List<QuoteInfo> getAllQuoteList(QuoteInfo qi) {
		return quoteInfoDao.getAllQuoteList(qi);
	}
}
