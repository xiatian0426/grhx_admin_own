package com.acc.service;

import java.util.List;
import java.util.Map;

import com.acc.exception.InsertException;
import com.acc.exception.SelectException;
import com.acc.exception.UpdateException;
import com.acc.model.Proprietor;

public interface IProprietorService extends IBaseService<Proprietor> {
	
	/**
	 * 保存 业主
	 * @param userInfo
	 * @throws InsertException
	 * @author TANGCY
	 */
	void  insert (Proprietor proprietor) throws InsertException;
	void  delete (String id) throws Exception;
	
	/**
	 * 获取全部业主信息
	 * @param userId
	 * @return
	 * @throws SelectException
	 */
	List<Proprietor> getAll () throws SelectException;
	/**
	 * 根据用户ID查询业主
	 * @param userId
	 * @return
	 * @throws SelectException
	 */
	Proprietor getById (String id) throws SelectException;
	
	/**
	 * 修改业主-根据ID
	 * @param userInfo
	 * @throws UpdateException
	 */
	void update (Proprietor proprietor) throws UpdateException;
	
	
	public Map<Integer, Proprietor> getAllMap() throws SelectException;
	
}
