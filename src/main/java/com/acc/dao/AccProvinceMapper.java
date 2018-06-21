package com.acc.dao;

import java.util.List;

import com.acc.exception.SelectException;
import com.acc.model.AccProvince;

public interface AccProvinceMapper {

	List<AccProvince> getAll() throws SelectException;
	List<AccProvince> getProvince () throws SelectException;

	/**
	 * 根据省份名称查询省份
	 * @param provinceName
	 */
	List<AccProvince> selectByName(String provinceName) throws SelectException;
}
