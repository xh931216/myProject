package com.mzrd.dao;

import com.mzrd.pojo.QuoteSupplyImageInfo;

public interface QuoteSupplyImageInfoDao {
	public int addImageQuoteInfo(QuoteSupplyImageInfo qsi);
	public QuoteSupplyImageInfo getImageUrl(int deid);
	public int updateImageQuoteInfo(QuoteSupplyImageInfo qsi);
}
