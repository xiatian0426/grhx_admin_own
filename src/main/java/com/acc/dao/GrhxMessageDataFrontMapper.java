package com.acc.dao;

import java.util.Map;

import com.acc.model.GrhxMessageDataFront;

public interface GrhxMessageDataFrontMapper {

	void insert(GrhxMessageDataFront grhxMessageData) throws Exception;
	void update(GrhxMessageDataFront grhxMessageData) throws Exception;
	void delete(Map<String, Object> map) throws Exception;
	GrhxMessageDataFront getById(Map<String, Object> map) throws Exception;
}
