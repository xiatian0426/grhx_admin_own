package com.acc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acc.dao.FrontDataMapper;
import com.acc.dao.ProprietorMapper;
import com.acc.exception.InsertException;
import com.acc.exception.SelectException;
import com.acc.exception.UpdateException;
import com.acc.model.FrontData;
import com.acc.service.IFrontDataService;
import com.acc.service.IProprietorService;

@Service("frontDataService")
@Transactional
public class FrontDataServiceImpl extends BaseServiceImpl<FrontData> implements IFrontDataService {

	private static Logger _logger = LoggerFactory.getLogger(FrontDataServiceImpl.class);
	@Autowired
	private FrontDataMapper frontDataMapper;
	
	@Override
	public void insert(FrontData frontData) throws InsertException {
		frontDataMapper.insert(frontData);
	}
	@Override
	public void delete(String id,String isdelete) throws Exception {
		frontDataMapper.delete(id,isdelete);
	}
	
	@Override
	public FrontData getById(String userId) throws SelectException {
		try {
			int id = Integer.parseInt(userId);
			return frontDataMapper.getById(id);
		} catch (Exception ex) {
			_logger.error("[获取用户失败,无效的用户,ID="+userId+"]");
		}
		return null;
	}

	@Override
	public List<FrontData> getAll() throws SelectException {
		List<FrontData> list = frontDataMapper.getAll();
		return list;
	}
	
	@Override
	public Map<Integer, FrontData> getAllMap() throws SelectException {
		List<FrontData> list = getAll();
		Map<Integer, FrontData> userInfoDictMap = new HashMap<Integer, FrontData>();
		for (FrontData frontData : list) {
			userInfoDictMap.put(frontData.getId(), frontData);
		}
		return userInfoDictMap;
	}
	

	@Override
	public void update(FrontData frontData) throws UpdateException {
		frontDataMapper.update(frontData);
	}

}
