package com.acc.service;

import java.util.List;
import java.util.Map;

import com.acc.exception.SelectException;
import com.acc.model.GrhxMessageType;

public interface IGrhxMessageTypeService extends IBaseService<GrhxMessageType>{
	List<GrhxMessageType> getAll () throws SelectException;
	List<GrhxMessageType> getAllById (Map<String, Object> map) throws SelectException;
	/**
	 * 保存信息类型
	 * @param grhxMessageType
	 * @throws Exception
	 */
	void insert (GrhxMessageType grhxMessageType) throws Exception;
	
	/**
	 * 修改信息类型
	 * @param grhxMessageType
	 * @throws Exception
	 */
	void update (GrhxMessageType grhxMessageType) throws Exception;
	/**
	 * 删除信息类型
	 * @param map
	 * @throws Exception
	 */
	void deleteById(Map<String, Object> map) throws Exception;
}
