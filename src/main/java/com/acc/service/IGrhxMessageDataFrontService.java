package com.acc.service;

import java.util.Map;

import com.acc.model.GrhxMessageDataFront;

public interface IGrhxMessageDataFrontService extends IBaseService<GrhxMessageDataFront>{
	/**
	 * 保存信息类型
	 * @param grhxMessageType
	 * @throws Exception
	 */
	void insert (GrhxMessageDataFront grhxMessageData) throws Exception;
	
	/**
	 * 修改信息类型
	 * @param grhxMessageType
	 * @throws Exception
	 */
	void update (GrhxMessageDataFront grhxMessageData) throws Exception;
	/**
	 * 删除信息类型
	 * @param map
	 * @throws Exception
	 */
	void deleteById(Map<String, Object> map) throws Exception;
	/**
	 * 查询信息类型
	 * @param map
	 * @throws Exception
	 */
	GrhxMessageDataFront getById(Map<String, Object> map) throws Exception;

	void deleteByMap(Map<String, Object> map) throws Exception;
	
}
