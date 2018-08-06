package com.mzrd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzrd.dao.StaffAccountInfoDAO;
import com.mzrd.dao.SupplierAccountInfoDAO;
import com.mzrd.pojo.StaffAccountInfo;
import com.mzrd.pojo.SupplierAccountInfo;
import com.mzrd.service.StaffAccountInfoService;
import com.mzrd.service.SupplierAccountInfoService;
@Service("SupplierAccountInfoService")
public class SupplierAccountInfoServiceImpl implements SupplierAccountInfoService{
	@Autowired
	private SupplierAccountInfoDAO supplierAccountInfoDAO;

	@Override
	public List<String> getSupplierNameList(SupplierAccountInfo sa) {
		return supplierAccountInfoDAO.getSupplierNameList(sa);
	}
	
}
