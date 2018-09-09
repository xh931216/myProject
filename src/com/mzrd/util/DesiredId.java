package com.mzrd.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DesiredId {
	public String  getDeiredId(String dId){
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		String startstr = df.format(calendar.getTime());
		if(dId!=null){
			dId = dId.substring(8);
			int a = Integer.parseInt(dId);
			a=a+1;
			if(a<10){
				dId = startstr+"00"+a;
			}else if(a<100){
				dId = startstr+"0"+a;
			}else 
				dId = startstr+a;
		}else{
			dId = startstr + "000";
		}
		System.out.println(dId);
		return dId;
	}
}
