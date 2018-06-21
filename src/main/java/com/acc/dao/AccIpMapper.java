package com.acc.dao;

import java.util.List;
import java.util.Map;

import com.acc.exception.SelectException;
import com.acc.model.AccIp;

public interface AccIpMapper {

	List<AccIp> getAll() throws SelectException;
	/**
	 * 删除Ip
	 * @param map
	 * @throws Exception
	 */
	void delete(Map<String, Object> map) throws Exception;
	
	/**
	 * 保存Ip
	 * @param accField
	 * @throws Exception
	 */
	void insert (AccIp accIp) throws Exception;
	
	/**
	 * 修改Ip
	 * @param accField
	 * @throws Exception
	 */
	void update (AccIp accIp) throws Exception;
}
