package com.acc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acc.exception.ExceptionUtil;
import com.acc.model.GrhxMessageData;
import com.acc.model.GrhxMessageType;
import com.acc.service.IAccIpService;
import com.acc.service.IAccRoleService;
import com.acc.service.IGrhxMessageDataFrontService;
import com.acc.service.IGrhxMessageDataService;
import com.acc.service.IGrhxMessageTypeService;
import com.acc.service.IUserInfoService;


@Controller
@RequestMapping(value="/ajax")
public class AjaxController {
	private static Logger _logger = LoggerFactory.getLogger(AjaxController.class);
	
	@Autowired
	private IUserInfoService userInfoService;
	
	
	@Autowired
	private IAccRoleService accRoleService;
	
	@Autowired
	private IAccIpService accIpService;
	
	@Autowired
	private IGrhxMessageTypeService grhxMessageTypeService;
	
	@Autowired
	private IGrhxMessageDataService grhxMessageDataService;
	
	@Autowired
	private IGrhxMessageDataFrontService grhxMessageDataFrontService;
	
	/**
	 * 添加信息类型
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/addMessage", method = RequestMethod.POST)
	public Map<String, Object> addMessage (final HttpServletRequest request,
	final HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String messageName = request.getParameter("messageName");
			GrhxMessageType grhxMessageType = new GrhxMessageType();
			grhxMessageType.setMessageName(messageName);
			grhxMessageType.setState("0");
			grhxMessageTypeService.insert(grhxMessageType);
			model.put("info", "添加成功");
		} catch (Exception e) {
			_logger.error("添加信息类型失败：" + ExceptionUtil.getMsg(e));
			model.put("info", "添加失败");
		}
		return model;
	}
	/**
	 * 修改信息类型
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/editMessage", method = RequestMethod.POST)
	public Map<String, Object> editMessage (final HttpServletRequest request,
	final HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String id = request.getParameter("id");
			String messageName = request.getParameter("messageName");
			GrhxMessageType grhxMessageType = new GrhxMessageType();
			grhxMessageType.setId(Integer.valueOf(id));
			grhxMessageType.setMessageName(messageName);
			grhxMessageType.setState("0");
			grhxMessageTypeService.update(grhxMessageType);
			model.put("info", "修改成功");
		} catch (Exception e) {
			_logger.error("修改信息类型失败：" + ExceptionUtil.getMsg(e));
			model.put("info", "修改失败");
		}
		return model;
	}
	/**
	 * 删除信息类型
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteMessage", method = RequestMethod.POST)
	public Map<String, Object> deleteMessage (final HttpServletRequest request,
	final HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String id = request.getParameter("id");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("messagetype", id);
			List<GrhxMessageData> messageDataList= grhxMessageDataService.getByMessagetype(map);
			//判断对应的信息类型是否含有数据 如有数据 则不能删除 没有则可以删除
			if(messageDataList != null && messageDataList.size()>0){
				model.put("info", "该信息类型下有数据，不能删除!");
			}else{
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("id", id);
				grhxMessageTypeService.deleteById(map1);
				model.put("info", "删除成功");
			}
		} catch (Exception e) {
			_logger.error("删除信息类型失败：" + ExceptionUtil.getMsg(e));
			model.put("info", "删除失败");
		}
		return model;
	}
	/**
	 * 删除信息数据
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteMessageData", method = RequestMethod.POST)
	public Map<String, Object> deleteMessageData (final HttpServletRequest request,
	final HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		String info = "1";
		try {
			String id = request.getParameter("id");
			String isdelete = request.getParameter("isdelete");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("isdelete", isdelete);
			grhxMessageDataService.deleteById(map);
			if(isdelete!=null && "1".equals(isdelete)){
				grhxMessageDataFrontService.deleteById(map);
			}
		} catch (Exception e) {
			info = "-1";
			e.printStackTrace();
			_logger.error("删除信息数据失败：" + ExceptionUtil.getMsg(e));
		}
		model.put("info", info);
		return model;
	}
	
}
