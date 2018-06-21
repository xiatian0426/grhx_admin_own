package com.acc.service;

import com.acc.model.GrhxCrawler;

public interface IGrhxCrawlerService extends IBaseService<GrhxCrawler> {
	
	public void insert(GrhxCrawler grhxCrawler) throws Exception;
	
}
