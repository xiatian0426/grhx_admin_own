package com.acc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.acc.exception.SelectException;
import com.acc.exception.UpdateException;
import com.acc.model.Proprietor;

public interface ProprietorMapper  extends BaseMapper<Proprietor>{

	Proprietor getById (@Param("id")int id) throws SelectException;
	void delete(@Param("id")String id) throws Exception;

	List<Proprietor> getAll() throws SelectException;

	void update(Proprietor proprietor) throws UpdateException;
	List<Proprietor> getAllByMap (Map<String, Object> map) throws SelectException;
}
