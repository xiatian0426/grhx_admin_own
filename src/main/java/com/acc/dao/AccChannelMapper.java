package com.acc.dao;

import java.util.List;
import java.util.Map;

import com.acc.exception.SelectException;
import com.acc.model.AccChannel;

public interface AccChannelMapper {

	List<AccChannel> getAll() throws SelectException;
	void delete(Map<String, Object> map) throws Exception;
	void insert(AccChannel accChannel) throws Exception;
	void update(AccChannel accChannel) throws Exception;
	
	/**
	 * 根据行业名称查询行业
	 * @param name
	 * @return
	 * @throws SelectException
	 */
	List<AccChannel> selectByName(String name) throws SelectException;
}
