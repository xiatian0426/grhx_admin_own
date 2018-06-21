package com.acc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.acc.exception.SelectException;
import com.acc.model.AccLevel;

public interface AccLevelMapper {

	List<AccLevel> getAll() throws SelectException;
	
	List<AccLevel> getNotCCAll() throws SelectException;
	
	List<AccLevel> getCCAll() throws SelectException;

	List<AccLevel> selectByTypeAndName(@Param("type")String type, @Param("name")String name) throws SelectException;
}
