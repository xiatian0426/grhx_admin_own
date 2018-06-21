package com.acc.dao;

import java.util.List;
import java.util.Map;

import com.acc.exception.SelectException;
import com.acc.model.GrhxMember;

public interface GrhxMemberMapper {

	List<GrhxMember> getAll() throws SelectException;
	void insert(GrhxMember grhxMember) throws Exception;
	void update(GrhxMember grhxMember) throws Exception;
	void delete(Map<String, Object> map) throws Exception;
	GrhxMember getById (String userid) throws SelectException;
}
