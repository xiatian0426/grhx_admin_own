package com.acc.job;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.acc.exception.SelectException;
import com.acc.model.GrhxMessageData;
import com.acc.service.IAccProvinceService;
import com.acc.service.IGrhxMessageDataService;
import com.acc.util.CalendarUtil;

@Component("crawlerCCGPDataTask")
public class CrawlerCCGPDataTask {
	@Autowired
	private IGrhxMessageDataService  grhxMessageDataService;
	
	@Autowired
	private IAccProvinceService accProvinceService;
	
	/**
	 * 爬取任务 0 0 1 * * ? 每天11,17点执行
	 * @throws Exception 
	 */
	@Scheduled(cron = "0 0 11,17 * * ?")
	public void execute () throws Exception {
		//一天7000+数据
		Map<String, String> provinceMap = null;
		try {
			System.out.println("爬取任务开始...");
			provinceMap = accProvinceService.getProvince();
			//爬取数据
			List<String> list = new ArrayList<String>();
			list.add(CalendarUtil.getCurrentDate());
//			list.add("2018-04-01");
//			list.add("2018-04-02");
//			list.add("2018-04-03");
//			list.add("2018-04-04");
//			list.add("2018-04-05");
//			list.add("2018-04-06");
//			list.add("2018-04-07");
//			list.add("2018-04-08");
//			list.add("2018-04-09");
//			list.add("2018-04-10");
//			list.add("2018-04-11");
			int jj = 150;
			for (int j = 0; j < list.size(); j++) {
				jj = 150;
				if(CalendarUtil.dayForWeek(list.get(j))==6 || CalendarUtil.dayForWeek(list.get(j))==7){
					jj = 20;
				}
				for (int i = 0; i < jj; i++) {
					getCrawlerDataCCGP(i+1,provinceMap,list.get(j).replace("-", "%3A"));
				}
			}
		} catch (SelectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 爬取"中国政府采购网"的数据
	 */
	private void getCrawlerDataCCGP(int pageNum,Map<String, String> provinceMap,String currdate){
		try {
			Entities.EscapeMode.base.getMap().clear();
			SimpleDateFormat sim = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
			Document doc = Jsoup.connect("http://search.ccgp.gov.cn/bxsearch?searchtype=2&page_index="+pageNum+"&bidSort=0&pinMu=0&bidType=0&dbselect=bidx&start_time="+currdate+"&end_time="+currdate+"&timeType=6&pppStatus=0&date="+new Date())
					.header("Accept", "*/*")
					.header("Accept-Encoding", "gzip, deflate")
				.header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
				.header("Referer", "https://www.baidu.com/")
				.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
				.timeout(5000)
				.get(); 
			String url="";
			String title;
			String province;
			String messageType;
			String date;
			Document docDetail;
			String pro;
			GrhxMessageData grhxMessageData;
			Map<String, Object> map;
			List<GrhxMessageData> list;
			Elements eles = doc.getElementsByClass("vT-srch-result-list-bid").get(0).children();
			for (int i = 0; i < eles.size(); i++) {
				grhxMessageData = new GrhxMessageData();
				try {
					url = eles.get(i).getElementsByTag("a").get(0).attr("href");
					title = eles.get(i).getElementsByTag("a").get(0).text();
					province = eles.get(i).getElementsByTag("span").get(0).getElementsByTag("a").get(0).text();
					messageType = eles.get(i).getElementsByTag("span").get(0).getElementsByTag("strong").get(0).text();
					date = eles.get(i).getElementsByTag("span").get(0).text().split("\\|")[0];
					grhxMessageData.setTitle(title);
					grhxMessageData.setDate(sim.parse(date));
					if(messageType!=null && ("公开招标公告".equals(messageType) || "询价公告".equals(messageType)
							|| "竞争性谈判公告".equals(messageType) || "单一来源公告".equals(messageType) || "资格预审公告".equals(messageType)
							|| "邀请招标公告".equals(messageType) || "其他公告".equals(messageType) || "其它公告".equals(messageType) || "竞争性磋商公告".equals(messageType))){
						grhxMessageData.setMessagetype("1");//招标公告
						grhxMessageData.setBusType("03");
					}else if(messageType!=null && ("中标公告".equals(messageType) || "成交公告".equals(messageType) || "终止公告".equals(messageType))){
						grhxMessageData.setMessagetype("2");//中标公示
						grhxMessageData.setBusType("04");
					}else if(messageType!=null && "更正公告".equals(messageType)){
						grhxMessageData.setMessagetype("3");//变更公告
						grhxMessageData.setBusType("05");
					}else{
						continue;
					}
					pro = provinceMap.get(province);
					if(pro==null || "".equals(pro)){
						continue;
					}
					grhxMessageData.setProvince(pro);
					//验证该数据是否存在
					map = new HashMap<String, Object>();
					map.put("title", grhxMessageData.getTitle());
					map.put("province", grhxMessageData.getProvince());
					map.put("messagetype", grhxMessageData.getMessagetype());
					map.put("date", grhxMessageData.getDate());
					list = grhxMessageDataService.getByMap(map);
					if(list == null || list.size() == 0){
						grhxMessageData.setWebtype("2");
						grhxMessageData.setCreateTime(new Date());
						docDetail = Jsoup.connect(url)
								.header("Accept", "*/*")
								.header("Accept-Encoding", "gzip, deflate")
							.header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
							.header("Referer", "https://www.baidu.com/")
							.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
							.timeout(5000)
							.get();
						grhxMessageData.setContent(docDetail.getElementsByClass("vF_detail_content_container").get(0).html());
						grhxMessageDataService.insert(grhxMessageData);
					}
				} catch (Exception e) {
					System.out.println(url);
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		String url = "http://search.ccgp.gov.cn/bxsearch?searchtype=2&page_index=19&bidSort=0&buyerName=&projectId=&pinMu=0&bidType=0&dbselect=bidx&kw=&start_time=2017%3A12%3A19&end_time=2017%3A12%3A19&timeType=6&displayZone=&zoneId=&pppStatus=0&agentName=";
		url = "http://search.ccgp.gov.cn/bxsearch";
		Document doc = Jsoup.connect(url).get(); 
		
	}
}
