package com.acc.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acc.dao.GrhxMessageDataFrontMapper;
import com.acc.model.GrhxMessageDataFront;
import com.acc.service.IGrhxMessageDataFrontService;

@Service("grhxMessageDataFrontService")
@Transactional
public class GrhxMessageDataFrontServiceImpl extends BaseServiceImpl<GrhxMessageDataFront> implements IGrhxMessageDataFrontService {

	private static Logger _logger = LoggerFactory.getLogger(GrhxMessageDataFrontServiceImpl.class);
	@Autowired
	private GrhxMessageDataFrontMapper grhxMessageDataFrontMapper;
	
	@Override
	public void insert(GrhxMessageDataFront grhxMessageData) throws Exception {
		// TODO Auto-generated method stub
		grhxMessageDataFrontMapper.insert(grhxMessageData);
	}
	
	@Override
	public void update(GrhxMessageDataFront grhxMessageData) throws Exception {
		// TODO Auto-generated method stub
		grhxMessageDataFrontMapper.update(grhxMessageData);
	}
	@Override
	public void deleteById(Map<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		grhxMessageDataFrontMapper.delete(map);
	}
	@Override
	public GrhxMessageDataFront getById(Map<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		return grhxMessageDataFrontMapper.getById(map);
	}
	@Override
	public void deleteByMap(Map<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		grhxMessageDataFrontMapper.deleteByMap(map);
	}
}
