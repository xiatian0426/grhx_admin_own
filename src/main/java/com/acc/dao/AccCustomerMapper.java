package com.acc.dao;

import java.util.List;
import java.util.Map;

import com.acc.exception.InsertException;
import com.acc.exception.SelectException;
import com.acc.model.AccCustomer;

public interface AccCustomerMapper extends BaseMapper<AccCustomer>{

	List<AccCustomer> getAll() throws SelectException;
	
	AccCustomer getById (String id) throws Exception;
	List<AccCustomer> getByMap (Map<String, Object> map) throws Exception;
	List<AccCustomer> getByMap2 (Map<String, Object> map) throws Exception;
	
	void transferCustomer(Map<String, Object> map) throws Exception;
	
	void deleteCustomer(Map<String, Object> map) throws Exception;
	
	void update(AccCustomer accCustomer) throws Exception;

	void batchInsert(List<AccCustomer> customerList) throws InsertException;

	List<AccCustomer> getByFullName(String fullName)throws Exception;
}
