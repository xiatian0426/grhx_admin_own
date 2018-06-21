package com.acc.service;

import java.util.List;
import java.util.Map;

import com.acc.model.AccSeqTable;

public interface IAccSeqTableService {
	void update (Map<String, Object> map) throws Exception;
	List<AccSeqTable> getByTableName (String tableName) throws Exception;
}
