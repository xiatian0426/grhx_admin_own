package com.acc.service;

import java.util.List;
import java.util.Map;

import com.acc.exception.InsertException;
import com.acc.exception.SelectException;
import com.acc.exception.UpdateException;
import com.acc.model.FrontData;

public interface IFrontDataService extends IBaseService<FrontData> {
	
	/**
	 * 保存 业主
	 * @param userInfo
	 * @throws InsertException
	 * @author TANGCY
	 */
	void  insert (FrontData frontData) throws InsertException;
	void  delete (String id,String isdelete) throws Exception;
	
	/**
	 * 获取全部业主信息
	 * @param userId
	 * @return
	 * @throws SelectException
	 */
	List<FrontData> getAll () throws SelectException;
	/**
	 * 根据用户ID查询业主
	 * @param userId
	 * @return
	 * @throws SelectException
	 */
	FrontData getById (String id) throws SelectException;
	
	/**
	 * 修改业主-根据ID
	 * @param userInfo
	 * @throws UpdateException
	 */
	void update (FrontData frontData) throws UpdateException;
	
	
	public Map<Integer, FrontData> getAllMap() throws SelectException;
	
}
