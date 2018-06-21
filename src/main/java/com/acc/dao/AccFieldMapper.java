package com.acc.dao;

import java.util.List;
import java.util.Map;

import com.acc.exception.SelectException;
import com.acc.model.AccField;

public interface AccFieldMapper {

	List<AccField> getAll() throws SelectException;
	void delete(Map<String, Object> map) throws Exception;
	void insert(AccField accField) throws Exception;
	void update(AccField accField) throws Exception;
}
