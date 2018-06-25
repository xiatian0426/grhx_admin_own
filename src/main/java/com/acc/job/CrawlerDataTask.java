package com.acc.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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

@Component("crawlerDataTask")
public class CrawlerDataTask {
	@Autowired
	private IGrhxMessageDataService  grhxMessageDataService;
	
	@Autowired
	private IAccProvinceService accProvinceService;
	
	/**
	 * 爬取任务 0 0 1 * * ? 每天11点执行
	 */
	@Scheduled(cron = "0 0 10,18 * * ?")
	public void execute () {
		/*Map<String, String> provinceMap = null;
		try {
			System.out.println("获取数据开始");
			provinceMap = accProvinceService.getProvince();
			String currdate = CalendarUtil.getCurrentDate();
			//爬取数据 	01:工程建设  
			int ggzy01 = 1;
			for (int i = 0; i < 5000; i++) {
				ggzy01 = getCrawlerDataGGZY(i+1,provinceMap,"01",currdate);
				System.out.println("ggzy01==="+ggzy01);
				if(ggzy01==0){
					break;
				}
			}
			//爬取数据 	02:政府采购
			int ggzy02 = 1;
			for (int i = 0; i < 5000; i++) {
				ggzy02 = getCrawlerDataGGZY(i+1,provinceMap,"02",currdate);
				System.out.println("ggzy02==="+ggzy02);
				if(ggzy02==0){
					break;
				}
			}
			
			System.out.println("获取数据结束");
		} catch (SelectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	/**
	 * 爬取"全国公共资源交易平台"的数据
	 */
	private int getCrawlerDataGGZY(int pageNum,Map<String, String> provinceMap,String busType,String currdate){
		try {
			Entities.EscapeMode.base.getMap().clear();
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
			Document doc = Jsoup.connect("http://deal.ggzy.gov.cn/ds/deal/dealList.jsp?HEADER_DEAL_TYPE="+busType+"&PAGENUMBER="+pageNum).get(); 
			Element ele = doc.getElementById("publicl");
			Elements eles = ele.getElementsByClass("publicont");
			String url;
			String title;
			String province;
			String messageType;
			String date;
			Document docDetail;
			GrhxMessageData grhxMessageData;
			String onclick;
			String urlDetail;
			String pro;
			Map<String, Object> map;
			List<GrhxMessageData> list;
			for(Element e :eles){
				try {
					grhxMessageData = new GrhxMessageData();
					url = e.getElementsByTag("h4").get(0).getElementsByTag("a").get(0).attr("href");
					title = e.getElementsByTag("h4").get(0).getElementsByTag("a").get(0).attr("title");
					date = e.getElementsByClass("span_o").get(0).text();
					if(date==null || !date.equals(currdate)){
						if(CalendarUtil.addDay(currdate, -1).equals(date)){
							return 0;
						}
						if(CalendarUtil.isAfter(currdate,date)){
							return 0;
						}
					}
					province = e.getElementsByClass("span_on").get(0).text();
					messageType = e.getElementsByClass("span_on").get(3).text();
					grhxMessageData.setBusType(busType);
					if("01".equals(busType)){
						if(messageType!=null && "招标/资审公告".equals(messageType)){
							grhxMessageData.setMessagetype("1");//招标公告
						}else if(messageType!=null && "交易结果公示".equals(messageType)){
							grhxMessageData.setMessagetype("2");//中标公示
						}else{
							continue;
						}
					}else if("02".equals(busType)){
						if(messageType!=null && "采购/资审公告".equals(messageType)){
							grhxMessageData.setMessagetype("1");//招标公告
						}else if(messageType!=null && "中标公告".equals(messageType)){
							grhxMessageData.setMessagetype("2");//中标公示
						}else if(messageType!=null && "更正事项".equals(messageType)){
							grhxMessageData.setMessagetype("3");//变更公告
						}else{
							continue;
						}
					}else{
						continue;
					}
					grhxMessageData.setTitle(title);
					grhxMessageData.setDate(sim.parse(date));
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
						grhxMessageData.setWebtype("1");
						grhxMessageData.setCreateTime(new Date());
						docDetail = Jsoup.connect(url).get();
						//第一种格式
						if(docDetail.getElementById("mycontent")!=null){
							grhxMessageData.setContent(docDetail.getElementById("mycontent").html());
						}else{
							Elements elesDetail = docDetail.getElementsByClass("fully_toggle_cont");
							for(Element eDetail :elesDetail){
								try {
									if(eDetail.hasAttr("style")){
										onclick = eDetail.getElementsByClass("li_hover").get(0).getElementsByTag("a").get(0).attr("onclick");
										urlDetail = "http://www.ggzy.gov.cn/information"+onclick.split(",")[2].substring(1, onclick.split(",")[2].length()-2);
										grhxMessageData.setContent(Jsoup.connect(urlDetail).get().getElementById("mycontent").html());
										break;
									}
								} catch (Exception e3) {
									e3.printStackTrace();
								}
							}
						}
						if(grhxMessageData.getContent()!=null && !"".equals(grhxMessageData.getContent())){
							grhxMessageDataService.insert(grhxMessageData);
						}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
	
}
