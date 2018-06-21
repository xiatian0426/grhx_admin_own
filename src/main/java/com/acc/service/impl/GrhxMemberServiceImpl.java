package com.acc.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acc.dao.GrhxMemberMapper;
import com.acc.exception.SelectException;
import com.acc.model.GrhxMember;
import com.acc.service.IGrhxMemberService;

@Service("grhxMemberService")
@Transactional
public class GrhxMemberServiceImpl extends BaseServiceImpl<GrhxMember> implements IGrhxMemberService {

	private static Logger _logger = LoggerFactory.getLogger(GrhxMemberServiceImpl.class);
	@Autowired
	private GrhxMemberMapper grhxMemberMapper;
	
	@Override
	public List<GrhxMember> getAll() throws SelectException {
		List<GrhxMember> list = grhxMemberMapper.getAll();
		return list;
	}
	@Override
	public void insert(GrhxMember grhxMember) throws Exception {
		// TODO Auto-generated method stub
		grhxMemberMapper.insert(grhxMember);
	}
	
	@Override
	public void update(GrhxMember grhxMember) throws Exception {
		// TODO Auto-generated method stub
		grhxMemberMapper.update(grhxMember);
	}
	@Override
	public void deleteById(Map<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		grhxMemberMapper.delete(map);
	}
	@Override
	public GrhxMember getById(String userId) throws SelectException {
		try {
			return grhxMemberMapper.getById(userId);
		} catch (Exception ex) {
			_logger.error("[获取用户失败,无效的用户,ID="+userId+"]");
		}
		return null;
	}
}
