package com.mzrd.dao;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.QuoteSupplyImageInfo;

public interface QuoteSupplyImageInfoDao {
	public int addImageQuoteInfo(QuoteSupplyImageInfo qsi);
	public QuoteSupplyImageInfo getImageUrl(Map map);
	public List<QuoteSupplyImageInfo> getImageUrlList(Map map);
	public int updateImageQuoteInfo(QuoteSupplyImageInfo qsi);
}
