package com.acc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acc.dao.ProprietorMapper;
import com.acc.exception.InsertException;
import com.acc.exception.SelectException;
import com.acc.exception.UpdateException;
import com.acc.model.Proprietor;
import com.acc.service.IProprietorService;

@Service("proprietorService")
@Transactional
public class ProprietorServiceImpl extends BaseServiceImpl<Proprietor> implements IProprietorService {

	private static Logger _logger = LoggerFactory.getLogger(ProprietorServiceImpl.class);
	@Autowired
	private ProprietorMapper proprietorMapper;
	
	@Override
	public void insert(Proprietor proprietor) throws InsertException {
		proprietorMapper.insert(proprietor);
	}
	@Override
	public void delete(String id) throws Exception {
		proprietorMapper.delete(id);
	}
	
	@Override
	public Proprietor getById(String userId) throws SelectException {
		try {
			int id = Integer.parseInt(userId);
			return proprietorMapper.getById(id);
		} catch (Exception ex) {
			_logger.error("[获取用户失败,无效的用户,ID="+userId+"]");
		}
		return null;
	}

	@Override
	public List<Proprietor> getAll() throws SelectException {
		List<Proprietor> list = proprietorMapper.getAll();
		return list;
	}
	
	@Override
	public Map<Integer, Proprietor> getAllMap() throws SelectException {
		List<Proprietor> list = getAll();
		Map<Integer, Proprietor> userInfoDictMap = new HashMap<Integer, Proprietor>();
		for (Proprietor proprietor : list) {
			userInfoDictMap.put(proprietor.getId(), proprietor);
		}
		return userInfoDictMap;
	}
	

	@Override
	public void update(Proprietor Proprietor) throws UpdateException {
		proprietorMapper.update(Proprietor);
	}

}
