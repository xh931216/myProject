package com.mzrd.dao;

import java.util.List;
import java.util.Map;

import com.mzrd.pojo.DesiredInfo;
import com.mzrd.pojo.PostInfo;
import com.mzrd.pojo.QuoteInfo;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.pojo.SupplyAccountInfo;

public interface QuoteInfoDao {
	public int addQuoteInfo(QuoteInfo qi);
	public List<QuoteInfo> getQuoteInfo(DesiredInfo qi);
	public List<QuoteInfo> getAllQuoteList(QuoteInfo qi);
	public List<QuoteInfo> getQuoteList(Map map);
	public int deleteQuoteInfo(QuoteInfo qi);
	public int updateQuoteInfo(QuoteInfo qi);
}
