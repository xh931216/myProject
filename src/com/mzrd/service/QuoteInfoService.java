package com.mzrd.service;
import java.util.List;
import java.util.Map;

import com.mzrd.pojo.*;

public interface QuoteInfoService {
	public int addQuoteInfo(QuoteInfo qi);
	public QuoteInfo getQuoteInfo(QuoteInfo qi);
	public List<QuoteInfo> getAllQuoteList(QuoteInfo qi);
	public List<QuoteInfo> getQuoteList(Map map);
	public int deleteQuoteInfo(QuoteInfo qi);
	public int updateQuoteInfo(QuoteInfo qi);
}
