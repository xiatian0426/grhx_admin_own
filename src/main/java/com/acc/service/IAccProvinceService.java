package com.acc.service;

import java.util.List;
import java.util.Map;

import com.acc.exception.SelectException;
import com.acc.model.AccProvince;

public interface IAccProvinceService {
	/**
	 * 获取全部省份
	 * @return
	 * @throws SelectException
	 */
	List<AccProvince> getAll () throws SelectException;
	
	/**
	 * 只获取省份
	 * @return
	 * @throws SelectException
	 */
	Map<String, String> getProvince () throws SelectException;
	
	public Map<String, AccProvince> getAllMap() throws SelectException;
	
	/**
	 * 根据省份的名称查询
	 * @param provinceName
	 * @return
	 * @throws SelectException
	 */
	public AccProvince selectByName (String provinceName) throws SelectException;
}
