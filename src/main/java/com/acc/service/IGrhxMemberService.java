package com.acc.service;

import java.util.List;
import java.util.Map;

import com.acc.exception.SelectException;
import com.acc.model.GrhxMember;

public interface IGrhxMemberService extends IBaseService<GrhxMember>{
	
	List<GrhxMember> getAll () throws SelectException;
	/**
	 * 保存会员信息
	 * @param grhxMember
	 * @throws Exception
	 */
	void insert (GrhxMember grhxMember) throws Exception;
	
	/**
	 * 修改会员信息
	 * @param grhxMember
	 * @throws Exception
	 */
	void update (GrhxMember grhxMember) throws Exception;
	/**
	 * 删除会员信息
	 * @param map
	 * @throws Exception
	 */
	void deleteById(Map<String, Object> map) throws Exception;
	/**
	 * 根据用户ID查询用户
	 * @param userId
	 * @return
	 * @throws SelectException
	 */
	GrhxMember getById (String userId) throws SelectException;
}
