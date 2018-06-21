package com.acc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acc.dao.GrhxCrawlerMapper;
import com.acc.model.GrhxCrawler;
import com.acc.service.IGrhxCrawlerService;

@Service("grhxCrawlerService")
@Transactional
public class GrhxCrawlerServiceImpl extends BaseServiceImpl<GrhxCrawler> implements IGrhxCrawlerService {

	private static Logger _logger = LoggerFactory.getLogger(GrhxCrawlerServiceImpl.class);
	@Autowired
	private GrhxCrawlerMapper grhxCrawlerMapper;
	

	@Override
	public void insert(GrhxCrawler grhxCrawler) throws Exception {
		grhxCrawlerMapper.insert(grhxCrawler);
		
	}
	
}
