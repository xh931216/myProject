package com.mzrd.service;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.mzrd.pojo.*;

public interface QuoteInfoService {
	public int addQuoteInfo(String shareItemDatas,SupplyAccountInfo si,
				String imageUrl,int deid,Date quoteDate);
	public List<QuoteInfo> getQuoteInfo(DesiredInfo qi);
	public List<QuoteInfo> getAllQuoteList(QuoteInfo qi);
	public List<QuoteInfo> getQuoteList(Map map);
	public int deleteQuoteInfo(QuoteInfo qi);
	public int updateQuoteInfo(String shareItemDatas,SupplyAccountInfo si,
			String imageUrl,int deid,Date quoteDate);
}
