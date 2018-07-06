package com.acc.job;

import com.acc.model.GrhxMessageData;
import com.acc.model.GrhxMessageDataFront;
import com.acc.service.IGrhxMessageDataFrontService;
import com.acc.service.IGrhxMessageDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于更新前端显示数据 每5分钟执行一次
 */
@Component("frontDataTask")
public class FrontDataTask {

	private static Logger _logger = LoggerFactory.getLogger(FrontDataTask.class);

	@Autowired
	private IGrhxMessageDataService  grhxMessageDataService;

	@Autowired
	private IGrhxMessageDataFrontService grhxMessageDataFrontService;
	
	/**
	 * 更新任务 * 0/5 *  * * ? 每5分钟执行一次
	 */
	@Scheduled(cron="* 0/5 *  * * ? ")
	public void execute () {
		/**
		 * 更新VIP 拟在建  招标公告  中标公告  热点信息  推荐项目
		 */
		Map<String, Object> map;
		List<GrhxMessageData> grhxMessageDataList;
		GrhxMessageDataFront messageDataFront;
		System.out.println("更新VIP 拟在建  招标公告  中标公告 热点信息  推荐项目开始...");
		for (int i=1;i<=5;i++){
			try {
				map = new HashMap<String, Object>();
				map.put("messagetype", i);
				if(i==1){
					//热点信息取1-10  推荐项目取11-15  招标公告取16-20
					map.put("sign", 2);
					grhxMessageDataList = grhxMessageDataService.getByMessagetypeNum(map);
					if(grhxMessageDataList!=null){
						if(grhxMessageDataList.size()>=10){
							List<GrhxMessageData> redianList = grhxMessageDataList.subList(0,10);
							try{
								updateData(redianList,map,"1");
							}catch (Exception e){
								_logger.info("更新热点信息报错...");
								e.printStackTrace();
							}
						}
						if(grhxMessageDataList.size()>=15){
							List<GrhxMessageData> tuijianList = grhxMessageDataList.subList(10,15);
							try{
								updateData(tuijianList,map,"2");
							}catch (Exception e){
								_logger.info("更新推荐项目报错...");
								e.printStackTrace();
							}
						}
						if(grhxMessageDataList.size()>=20){
							List<GrhxMessageData> zhaobiaoList = grhxMessageDataList.subList(15,20);
							try{
								updateData(zhaobiaoList,map,"3");
							}catch (Exception e){
								_logger.info("更新招标公告报错...");
								e.printStackTrace();
							}
						}
					}
				}else{
					map.put("sign", 1);
					grhxMessageDataList = grhxMessageDataService.getByMessagetypeNum(map);
					try{
						updateData(grhxMessageDataList,map,"3");
					}catch (Exception e){
						_logger.info("更新更新VIP 拟在建  中标公告 报错...");
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("更新VIP 拟在建  招标公告  中标公告  热点信息  推荐项目结束...");
	}

	/**
	 * 更新前台数据
	 * @param grhxMessageDataList
	 * @param map
	 * @param frontmodule
	 */
	private void updateData(List<GrhxMessageData> grhxMessageDataList,Map<String, Object> map,String frontmodule){
		try{
			if(grhxMessageDataList!=null && grhxMessageDataList.size()>0){
				//删除old
				map.put("frontmodule", frontmodule);
				grhxMessageDataFrontService.deleteByMap(map);
				//insert新的前台数据
				GrhxMessageDataFront messageDataFront;
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
						messageDataFront.setFrontmodule(frontmodule);
						grhxMessageDataFrontService.insert(messageDataFront);
					}catch (Exception e){
						e.printStackTrace();
					}
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
