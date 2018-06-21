package com.acc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.acc.exception.SelectException;
import com.acc.exception.UpdateException;
import com.acc.model.FrontData;

public interface FrontDataMapper  extends BaseMapper<FrontData>{

	FrontData getById (@Param("id")int id) throws SelectException;
	void delete(@Param("id")String id,@Param("isdelete") String isdelete) throws Exception;

	List<FrontData> getAll() throws SelectException;

	void update(FrontData frontData) throws UpdateException;
	List<FrontData> getAllByMap (Map<String, Object> map) throws SelectException;
}
