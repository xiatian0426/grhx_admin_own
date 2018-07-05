package com.acc.job;

import com.acc.model.GrhxMessageData;
import com.acc.model.GrhxMessageDataFront;
import com.acc.service.IGrhxMessageDataFrontService;
import com.acc.service.IGrhxMessageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于更新前端显示数据 每10分钟执行一次
 */
@Component("frontDataTask")
public class FrontDataTask {
	@Autowired
	private IGrhxMessageDataService  grhxMessageDataService;

	@Autowired
	private IGrhxMessageDataFrontService grhxMessageDataFrontService;
	
	/**
	 * 爬取任务 * 0/10 *  * * ? 每10分钟执行一次
	 */
	@Scheduled(cron="* 0/1 *  * * ? ")
	public void execute () {
		/**
		 * 更新VIP 拟在建  招标公告  中标公告
		 */
		Map<String, Object> map;
		List<GrhxMessageData> grhxMessageDataList;
		GrhxMessageDataFront messageDataFront;
		for (int i=1;i<=5;i++){
			try {
				map = new HashMap<String, Object>();
				map.put("messagetype", i);
				if(i==1){
					map.put("sign", 2);
				}else{
					map.put("sign", 1);
				}
				grhxMessageDataList = grhxMessageDataService.getByMessagetypeNum(map);
				if(grhxMessageDataList!=null && grhxMessageDataList.size()>0){
					//删除old
					map.put("frontmodule", "3");
					grhxMessageDataFrontService.deleteByMap(map);
					//insert新的前台数据
					for(GrhxMessageData grhxMessageData:grhxMessageDataList){
						try{
							messageDataFront = new GrhxMessageDataFront();
							messageDataFront.setId(grhxMessageData.getId());
							messageDataFront.setTitle(grhxMessageData.getTitle());
							messageDataFront.setDate(grhxMessageData.getDate());
							messageDataFront.setProvince(grhxMessageData.getProvince());
							messageDataFront.setMessagetype(grhxMessageData.getMessagetype());
							messageDataFront.setWebtype(grhxMessageData.getWebtype());
							messageDataFront.setBusType(grhxMessageData.getBusType());
							messageDataFront.setFrontmodule("3");
							grhxMessageDataFrontService.insert(messageDataFront);
						}catch (Exception e){
							e.printStackTrace();
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/**
		 * 更新热点信息
		 */
		try {
			map = new HashMap<String, Object>();
			map.put("messagetype", 1);
			map.put("sign", 3);
			grhxMessageDataList = grhxMessageDataService.getByMessagetypeNum(map);
			if(grhxMessageDataList!=null && grhxMessageDataList.size()>0){
				//删除old
				map.put("frontmodule", "1");
				grhxMessageDataFrontService.deleteByMap(map);
				//insert新的前台数据
				for(GrhxMessageData grhxMessageData:grhxMessageDataList){
					try{
						messageDataFront = new GrhxMessageDataFront();
						messageDataFront.setId(grhxMessageData.getId());
						messageDataFront.setTitle(grhxMessageData.getTitle());
						messageDataFront.setDate(grhxMessageData.getDate());
						messageDataFront.setProvince(grhxMessageData.getProvince());
						messageDataFront.setMessagetype(grhxMessageData.getMessagetype());
						messageDataFront.setWebtype(grhxMessageData.getWebtype());
						messageDataFront.setBusType(grhxMessageData.getBusType());
						messageDataFront.setFrontmodule("1");
						grhxMessageDataFrontService.insert(messageDataFront);
					}catch (Exception e){
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * 更新推荐项目
		 */
		try {
			map = new HashMap<String, Object>();
			map.put("messagetype", 1);
			map.put("sign", 4);
			grhxMessageDataList = grhxMessageDataService.getByMessagetypeNum(map);
			if(grhxMessageDataList!=null && grhxMessageDataList.size()>0){
				//删除old
				map.put("frontmodule", "2");
				grhxMessageDataFrontService.deleteByMap(map);
				//insert新的前台数据
				for(GrhxMessageData grhxMessageData:grhxMessageDataList){
					try{
						messageDataFront = new GrhxMessageDataFront();
						messageDataFront.setId(grhxMessageData.getId());
						messageDataFront.setTitle(grhxMessageData.getTitle());
						messageDataFront.setDate(grhxMessageData.getDate());
						messageDataFront.setProvince(grhxMessageData.getProvince());
						messageDataFront.setMessagetype(grhxMessageData.getMessagetype());
						messageDataFront.setWebtype(grhxMessageData.getWebtype());
						messageDataFront.setBusType(grhxMessageData.getBusType());
						messageDataFront.setFrontmodule("2");
						grhxMessageDataFrontService.insert(messageDataFront);
					}catch (Exception e){
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
