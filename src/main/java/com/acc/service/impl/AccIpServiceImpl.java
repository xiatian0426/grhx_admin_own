package com.acc.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;

import com.acc.dao.AccIpMapper;
import com.acc.exception.SelectException;
import com.acc.model.AccIp;
import com.acc.service.IAccIpService;

@Service("accIpService")
@Transactional
public class AccIpServiceImpl extends BaseServiceImpl<AccIp> implements IAccIpService {

	private static Logger _logger = LoggerFactory.getLogger(AccIpServiceImpl.class);
	@Autowired
	private AccIpMapper accIpMapper;
	
	@Override
	public List<AccIp> getAll() throws SelectException {
		List<AccIp> list = accIpMapper.getAll();
		return list;
	}

	@Override
	public void deleteById(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		accIpMapper.delete(map);
	}

	@Override
	public void insert(AccIp accIp) throws Exception {
		// TODO Auto-generated method stub
		accIpMapper.insert(accIp);
	}

	@Override
	public void update(AccIp accIp) throws Exception {
		// TODO Auto-generated method stub
		accIpMapper.update(accIp);
	}
	
}
