package com.acc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acc.dao.AccProvinceMapper;
import com.acc.exception.SelectException;
import com.acc.model.AccProvince;
import com.acc.service.IAccProvinceService;

@Service("accProvinceService")
@Transactional
public class AccProvinceServiceImpl implements IAccProvinceService {

	private static final Logger _logger = LoggerFactory.getLogger(AccProvinceServiceImpl.class);
	@Autowired
	private AccProvinceMapper accProvinceMapper;
	
	@Override
	public List<AccProvince> getAll() throws SelectException {
		List<AccProvince> list = accProvinceMapper.getAll();
		return list;
	}
	
	@Override
	public Map<String, String> getProvince () throws SelectException{
		List<AccProvince> list = accProvinceMapper.getProvince();
		Map<String, String> accProvinceDictMap = new HashMap<String, String>();
		for (AccProvince accProvince : list) {
			accProvinceDictMap.put(accProvince.getProvinceName(), accProvince.getId()+"");
		}
		return accProvinceDictMap;
	}
	
	@Override
	public Map<String, AccProvince> getAllMap() throws SelectException {
		List<AccProvince> list = getAll();
		Map<String, AccProvince> accProvinceDictMap = new HashMap<String, AccProvince>();
		for (AccProvince accProvince : list) {
			accProvinceDictMap.put(accProvince.getId()+"", accProvince);
		}
		return accProvinceDictMap;
	}
	@Override
	public AccProvince selectByName(String provinceName) throws SelectException {
		if (StringUtils.isEmpty(provinceName)) {
			return null;
		}
		List<AccProvince> result = accProvinceMapper.selectByName(provinceName.trim());
		if (CollectionUtils.isEmpty(result)) return null;
		return result.get(0);
	}
}
