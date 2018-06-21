package com.acc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.acc.exception.ExceptionUtil;
import com.acc.frames.web.Md5PwdEncoder;
import com.acc.model.AccDepart;
import com.acc.model.AccRole;
import com.acc.model.Proprietor;
import com.acc.model.UserInfo;
import com.acc.service.IAccDepartService;
import com.acc.service.IAccRoleService;
import com.acc.service.IProprietorService;
import com.acc.service.IUserInfoService;
import com.acc.util.CalendarUtil;
import com.acc.util.Constants;
import com.acc.vo.AccDepartVo;
import com.acc.vo.Page;
import com.acc.vo.ProprietorQuery;
import com.alibaba.fastjson.JSON;


@Controller
@RequestMapping(value="/proprietor")
public class ProprietorController {
	private static Logger _logger = LoggerFactory.getLogger(ProprietorController.class);
	
	@Autowired
	private IProprietorService proprietorService;
	
	@Autowired
	private IAccRoleService accRoleService;
	
	@Autowired
	private IAccDepartService accDepartService;
	
	/**
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/index")
	public ModelAndView index (ModelAndView mav, final HttpServletRequest request, @ModelAttribute ProprietorQuery query) {
		Map<String, Object> model = mav.getModel();
		try {
			mav.setViewName("/proprietor/index");
		} catch (Exception e) {
			_logger.error("转到用户列表页失败：" + ExceptionUtil.getMsg(e));
			mav = new ModelAndView(Constants.SERVICES_ERROR, model);
		}
		return mav;
	}
	/**
	 * 业主列表
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list (ModelAndView mav, final HttpServletRequest request, @ModelAttribute ProprietorQuery query) {
		Map<String, Object> model = mav.getModel();
		try {
			//负责人
			Page<Proprietor> page = proprietorService.selectPage(query);
			model.put("page", page);
			model.put("query", query);
			mav.setViewName("/proprietor/proprietorList");
		} catch (Exception e) {
			_logger.error("转到业主列表页失败：" + ExceptionUtil.getMsg(e));
			mav = new ModelAndView(Constants.SERVICES_ERROR, model);
		}
		return mav;
	}
	
	/**
	 * 跳转到添加业主
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/goAdd")
	public ModelAndView goAdd (ModelAndView mav, final HttpServletRequest request) {
		mav.setViewName("/proprietor/add");
		return mav;
	}
	
	/**
	 * 添加业主
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ModelAndView add (ModelAndView mav, final HttpServletRequest request, @ModelAttribute Proprietor proprietor) {
		Map<String, Object> model = mav.getModel();
		try {
			HttpSession session = request.getSession();
			UserInfo staff = (UserInfo)session.getAttribute(Constants.LOGINUSER);
			proprietor.setCreaterid(staff.getId());
			proprietor.setCreatetime(new Date());
			proprietorService.insert(proprietor);
			mav.setViewName("redirect:/proprietor/index");
		} catch (Exception e) {
			_logger.error("添加业主失败：" + ExceptionUtil.getMsg(e));
			mav = new ModelAndView(Constants.SERVICES_ERROR, model);
		}
		return mav;
	}
	/**
	 * 删除业主
	 * @param mav
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteProprietor")
	public Boolean deleteProprietor (ModelAndView mav, final HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			proprietorService.delete(id);
			return true;
		} catch (Exception e) {
			_logger.error("删除业主失败：" + ExceptionUtil.getMsg(e));
			return false;
		}
	}
	/**
	 * 跳转修改业主信息
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
			Proprietor proprietor = proprietorService.getById(id);
			model.put("proprietor", proprietor);
			mav = new ModelAndView("/proprietor/editProprietor",model);
		} catch (Exception e) {
			_logger.error("跳转修改业主信息页失败：" + ExceptionUtil.getMsg(e));
			mav = new ModelAndView(Constants.SERVICES_ERROR, model);
		}
		return mav;
	}
	
	/**
	 * 修改业主
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/editProprietor")
	public ModelAndView editProprietor (final ModelAndView mav, final HttpServletRequest request, @ModelAttribute Proprietor proprietor) {
		try {
			HttpSession session = request.getSession();
			UserInfo staff = (UserInfo)session.getAttribute(Constants.LOGINUSER);
			proprietor.setOperaterid(staff.getId());
			proprietor.setOperatetime(new Date());
			proprietorService.update(proprietor);
			mav.getModel().put("notice", 1);
		} catch (Exception e) {
			_logger.error("修改业主失败：" + ExceptionUtil.getMsg(e));
			mav.getModel().put("notice", -1);
		}
		mav.setViewName("redirect:/proprietor/goEdit");
		return mav;
	}
}
