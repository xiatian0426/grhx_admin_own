package com.acc.dao;

import java.util.List;

import com.acc.exception.SelectException;
import com.acc.model.AccCorsource;

public interface AccCorsourceMapper {

	List<AccCorsource> getAll() throws SelectException;

	/**
	 * 根据客户来源名称查询可以来源信息
	 * @param name
	 * @return
	 * @throws SelectException
	 */
	List<AccCorsource> selectByName(String name) throws SelectException;
}
