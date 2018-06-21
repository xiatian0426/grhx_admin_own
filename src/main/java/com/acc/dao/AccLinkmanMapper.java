package com.acc.dao;

import java.util.List;
import java.util.Map;

import com.acc.exception.InsertException;
import com.acc.exception.SelectException;
import com.acc.model.AccLinkman;

public interface AccLinkmanMapper extends BaseMapper<AccLinkman>{

	List<AccLinkman> getAll() throws SelectException;
	void update(AccLinkman accLinkman) throws Exception;
	List<AccLinkman> getByCustomerId (Map<String, Object> map) throws Exception;
	void delete(String id) throws Exception;
	List<AccLinkman> getLinkMan (Map<String, Object> map) throws Exception;
	void batchInsert(List<AccLinkman> linkManList) throws InsertException;
}
