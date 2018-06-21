package com.acc.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acc.dao.AccSeqTableMapper;
import com.acc.model.AccSeqTable;
import com.acc.service.IAccSeqTableService;

@Service("accSeqTableService")
@Transactional
public class AccSeqTableServiceImpl implements IAccSeqTableService {

	private static Logger _logger = LoggerFactory.getLogger(AccSeqTableServiceImpl.class);
	@Autowired
	private AccSeqTableMapper accSeqTableMapper;
	@Override
	public void update(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		accSeqTableMapper.update(map);
	}
	@Override
	public List<AccSeqTable> getByTableName(String tableName)
			throws Exception {
		// TODO Auto-generated method stub
		return accSeqTableMapper.getByTableName(tableName);
	}
	
	
	

}
