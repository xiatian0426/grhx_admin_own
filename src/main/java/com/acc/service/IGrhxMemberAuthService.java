package com.acc.service;

import java.util.List;
import java.util.Map;

import com.acc.exception.SelectException;
import com.acc.model.GrhxMemberAuth;

public interface IGrhxMemberAuthService extends IBaseService<GrhxMemberAuth>{
	List<GrhxMemberAuth> getAll () throws SelectException;
	/**
	 * 保存会员信息
	 * @param grhxMemberAuth
	 * @throws Exception
	 */
	void insert (GrhxMemberAuth grhxMemberAuth) throws Exception;
	
	/**
	 * 修改会员信息
	 * @param grhxMemberAuth
	 * @throws Exception
	 */
	void update (GrhxMemberAuth grhxMemberAuth) throws Exception;
	/**
	 * 删除会员信息
	 * @param map
	 * @throws Exception
	 */
	void deleteById(Map<String, Object> map) throws Exception;
	/**
	 * 获取客户字典
	 * @return
	 * @throws Exception
	 */
	Map<String, GrhxMemberAuth> getDictAllMap() throws Exception;
}
