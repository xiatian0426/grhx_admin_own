package com.acc.dao;

import java.util.List;
import java.util.Map;

import com.acc.exception.SelectException;
import com.acc.model.GrhxMemberAuth;

public interface GrhxMemberAuthMapper {

	List<GrhxMemberAuth> getAll() throws SelectException;
	void insert(GrhxMemberAuth grhxMemberAuth) throws Exception;
	void update(GrhxMemberAuth grhxMemberAuth) throws Exception;
	void delete(Map<String, Object> map) throws Exception;
}
