package com.acc.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acc.dao.GrhxMessageTypeMapper;
import com.acc.exception.SelectException;
import com.acc.model.GrhxMessageType;
import com.acc.service.IGrhxMessageTypeService;

@Service("grhxMessageTypeService")
@Transactional
public class GrhxMessageTypeServiceImpl extends BaseServiceImpl<GrhxMessageType> implements IGrhxMessageTypeService {

	private static Logger _logger = LoggerFactory.getLogger(GrhxMessageTypeServiceImpl.class);
	@Autowired
	private GrhxMessageTypeMapper grhxMessageTypeMapper;
	
	@Override
	public List<GrhxMessageType> getAll() throws SelectException {
		List<GrhxMessageType> list = grhxMessageTypeMapper.getAll();
		return list;
	}
	@Override
	public List<GrhxMessageType> getAllById(Map<String, Object> map) throws SelectException {
		List<GrhxMessageType> list = grhxMessageTypeMapper.getAllById(map);
		return list;
	}
	@Override
	public void insert(GrhxMessageType grhxMessageType) throws Exception {
		// TODO Auto-generated method stub
		grhxMessageTypeMapper.insert(grhxMessageType);
	}
	
	@Override
	public void update(GrhxMessageType grhxMessageType) throws Exception {
		// TODO Auto-generated method stub
		grhxMessageTypeMapper.update(grhxMessageType);
	}
	@Override
	public void deleteById(Map<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		grhxMessageTypeMapper.delete(map);
	}
}
