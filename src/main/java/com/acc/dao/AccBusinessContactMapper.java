package com.acc.dao;

import java.util.List;
import java.util.Map;

import com.acc.exception.SelectException;
import com.acc.model.AccBusinessContact;

public interface AccBusinessContactMapper {

	List<AccBusinessContact> getAll() throws SelectException;
	void insert(AccBusinessContact accBusinessContact) throws Exception;
	void update(AccBusinessContact accBusinessContact) throws Exception;
	public List<AccBusinessContact> getContactByCustomer(Map<String, Object> map) throws SelectException;
	void delete(Map<String, Object> map) throws Exception;
	List<AccBusinessContact> getContact(Map<String, Object> map) throws Exception;
}
