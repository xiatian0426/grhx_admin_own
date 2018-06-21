package com.acc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acc.dao.GrhxMemberAuthMapper;
import com.acc.exception.SelectException;
import com.acc.model.GrhxMemberAuth;
import com.acc.service.IGrhxMemberAuthService;

@Service("grhxMemberAuthService")
@Transactional
public class GrhxMemberAuthServiceImpl extends BaseServiceImpl<GrhxMemberAuth> implements IGrhxMemberAuthService {

	private static Logger _logger = LoggerFactory.getLogger(GrhxMemberAuthServiceImpl.class);
	@Autowired
	private GrhxMemberAuthMapper grhxMemberAuthMapper;
	
	@Override
	public List<GrhxMemberAuth> getAll() throws SelectException {
		List<GrhxMemberAuth> list = grhxMemberAuthMapper.getAll();
		return list;
	}
	@Override
	public void insert(GrhxMemberAuth grhxMemberAuth) throws Exception {
		// TODO Auto-generated method stub
		grhxMemberAuthMapper.insert(grhxMemberAuth);
	}
	
	@Override
	public void update(GrhxMemberAuth grhxMemberAuth) throws Exception {
		// TODO Auto-generated method stub
		grhxMemberAuthMapper.update(grhxMemberAuth);
	}
	@Override
	public void deleteById(Map<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		grhxMemberAuthMapper.delete(map);
	}
	@Override
	public Map<String, GrhxMemberAuth> getDictAllMap() throws Exception{
		List<GrhxMemberAuth> list = getAll();
		Map<String, GrhxMemberAuth> grhxMemberAuthDictMap = new HashMap<String, GrhxMemberAuth>();
		for (GrhxMemberAuth grhxMemberAuth : list) {
			grhxMemberAuthDictMap.put(grhxMemberAuth.getId()+"", grhxMemberAuth);
		}
		return grhxMemberAuthDictMap;
	}
}
