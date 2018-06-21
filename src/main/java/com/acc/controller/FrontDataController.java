package com.acc.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.acc.exception.ExceptionUtil;
import com.acc.model.FrontData;
import com.acc.model.UserInfo;
import com.acc.service.IFrontDataService;
import com.acc.util.Constants;
import com.acc.vo.Page;
import com.acc.vo.FrontDataQuery;

/**
 * 数据管理
 * @author xugs
 *
 */
@Controller
@RequestMapping(value="/frontData")
public class FrontDataController {
	private static Logger _logger = LoggerFactory.getLogger(FrontDataController.class);
	
	@Autowired
	private IFrontDataService frontDataService;
	
	/**
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/index")
	public ModelAndView index (ModelAndView mav, final HttpServletRequest request, @ModelAttribute FrontDataQuery query) {
		Map<String, Object> model = mav.getModel();
		try {
			mav.setViewName("/frontData/index");
		} catch (Exception e) {
			_logger.error("转到数据管理列表页失败：" + ExceptionUtil.getMsg(e));
			mav = new ModelAndView(Constants.SERVICES_ERROR, model);
		}
		return mav;
	}
	/**
	 * 数据管理列表
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list (ModelAndView mav, final HttpServletRequest request, @ModelAttribute FrontDataQuery query) {
		Map<String, Object> model = mav.getModel();
		try {
			//负责人
			Page<FrontData> page = frontDataService.selectPage(query);
			model.put("page", page);
			model.put("query", query);
			mav.setViewName("/frontData/frontDataList");
		} catch (Exception e) {
			_logger.error("转到数据管理列表页失败：" + ExceptionUtil.getMsg(e));
			mav = new ModelAndView(Constants.SERVICES_ERROR, model);
		}
		return mav;
	}
	
	/**
	 * 跳转到添加数据管理
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/goAdd")
	public ModelAndView goAdd (ModelAndView mav, final HttpServletRequest request) {
		mav.setViewName("/frontData/add");
		return mav;
	}
	
	/**
	 * 添加数据管理
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ModelAndView add (ModelAndView mav, final HttpServletRequest request, @ModelAttribute FrontData frontData) {
		Map<String, Object> model = mav.getModel();
		try {
			HttpSession session = request.getSession();
			UserInfo staff = (UserInfo)session.getAttribute(Constants.LOGINUSER);
			frontData.setCreaterid(staff.getId());
			frontData.setCreatetime(new Date());
			frontData.setOperatetime(new Date());
			frontDataService.insert(frontData);
			mav.setViewName("redirect:/frontData/index");
		} catch (Exception e) {
			_logger.error("添加数据管理失败：" + ExceptionUtil.getMsg(e));
			mav = new ModelAndView(Constants.SERVICES_ERROR, model);
		}
		return mav;
	}
	/**
	 * 删除数据管理
	 * @param mav
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteFrontData")
	public Boolean deleteFrontData (ModelAndView mav, final HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			String isdelete = request.getParameter("isdelete");
			frontDataService.delete(id,isdelete);
			return true;
		} catch (Exception e) {
			_logger.error("删除数据管理失败：" + ExceptionUtil.getMsg(e));
			return false;
		}
	}
	/**
	 * 跳转修改数据管理信息
	 * @param mav
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/goEdit")
	public ModelAndView goEdit (ModelAndView mav, final HttpServletRequest request) {
		Map<String, Object> model = mav.getModel();
		try {
			model.put("notice", request.getParameter("notice"));
			String id = request.getParameter("id");
			FrontData frontData = frontDataService.getById(id);
			model.put("frontData", frontData);
			mav = new ModelAndView("/frontData/editFrontData",model);
		} catch (Exception e) {
			_logger.error("跳转修改数据管理信息页失败：" + ExceptionUtil.getMsg(e));
			mav = new ModelAndView(Constants.SERVICES_ERROR, model);
		}
		return mav;
	}
	
	/**
	 * 修改数据管理
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/editFrontData")
	public ModelAndView editFrontData (final ModelAndView mav, final HttpServletRequest request, @ModelAttribute FrontData frontData) {
		try {
			HttpSession session = request.getSession();
			UserInfo staff = (UserInfo)session.getAttribute(Constants.LOGINUSER);
			frontData.setOperaterid(staff.getId());
			frontData.setOperatetime(new Date());
			frontDataService.update(frontData);
			mav.getModel().put("notice", 1);
		} catch (Exception e) {
			_logger.error("修改数据管理失败：" + ExceptionUtil.getMsg(e));
			mav.getModel().put("notice", -1);
		}
		mav.setViewName("redirect:/frontData/goEdit");
		return mav;
	}
}
