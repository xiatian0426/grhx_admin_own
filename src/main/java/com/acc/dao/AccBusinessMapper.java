package com.acc.dao;

import java.util.List;
import java.util.Map;

import com.acc.exception.SelectException;
import com.acc.model.AccBusiness;

public interface AccBusinessMapper {

	List<AccBusiness> getAll() throws SelectException;
	void insert(AccBusiness accBusiness) throws Exception;
	void update(AccBusiness accBusiness) throws Exception;
	List<AccBusiness> getByCustomerId (Map<String, Object> map) throws Exception;
	void delete(Map<String, Object> map) throws Exception;
	List<AccBusiness> getBusiness(Map<String, Object> map) throws Exception;
}
