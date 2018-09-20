package com.mzrd.service;
import java.util.List;
import java.util.Map;

import com.mzrd.pojo.*;

public interface QuoteSupplyImageInfoService {
	public int addQuoteInfo(QuoteSupplyImageInfo qsi);
	public QuoteSupplyImageInfo getImageUrl(int deid,int sid);
}
