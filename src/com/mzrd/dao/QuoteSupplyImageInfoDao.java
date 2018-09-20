package com.mzrd.dao;

import java.util.Map;

import com.mzrd.pojo.QuoteSupplyImageInfo;

public interface QuoteSupplyImageInfoDao {
	public int addImageQuoteInfo(QuoteSupplyImageInfo qsi);
	public QuoteSupplyImageInfo getImageUrl(Map map);
	public int updateImageQuoteInfo(QuoteSupplyImageInfo qsi);
}
