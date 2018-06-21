package com.acc.dao;

import java.util.List;
import java.util.Map;

import com.acc.exception.SelectException;
import com.acc.model.GrhxMessageType;

public interface GrhxMessageTypeMapper {

	List<GrhxMessageType> getAll() throws SelectException;
	List<GrhxMessageType> getAllById(Map<String, Object> map) throws SelectException;
	void insert(GrhxMessageType grhxMessageType) throws Exception;
	void update(GrhxMessageType grhxMessageType) throws Exception;
	void delete(Map<String, Object> map) throws Exception;
}
