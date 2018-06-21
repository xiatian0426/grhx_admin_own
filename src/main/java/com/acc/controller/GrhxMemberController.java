package com.acc.controller;

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
import com.acc.exception.SelectException;
import com.acc.frames.web.Md5PwdEncoder;
import com.acc.model.GrhxMember;
import com.acc.model.GrhxMemberAuth;
import com.acc.model.UserInfo;
import com.acc.service.IGrhxMemberAuthService;
import com.acc.service.IGrhxMemberService;
import com.acc.util.CalendarUtil;
import com.acc.util.Constants;
import com.acc.vo.MemberQuery;
import com.acc.vo.Page;
import com.acc.vo.UserInfoQuery;


@Controller
@RequestMapping(value="/member")
public class GrhxMemberController {
	private static Logger _logger = LoggerFactory.getLogger(GrhxMemberController.class);
	
	@Autowired
	private IGrhxMemberService grhxMemberService;
	
	@Autowired
	private IGrhxMemberAuthService grhxMemberAuthService;
	/**
	 * 客户列表
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/memberList")
	public ModelAndView memberList (ModelAndView mav, final HttpServletRequest request,@ModelAttribute MemberQuery query) {
		Map<String, Object> model = mav.getModel();
		try {
			//所属行业
			query.setPageSize(20);
			Map<String, GrhxMemberAuth> grhxMemberAuthDictMap = grhxMemberAuthService.getDictAllMap();
			model.put("grhxMemberAuthDictMap", grhxMemberAuthDictMap);
			List<GrhxMemberAuth> memberAuthList = grhxMemberAuthService.getAll();
			model.put("memberAuthList", memberAuthList);
			Page<GrhxMember> page = grhxMemberService.selectPage(query);
			model.put("page", page);
			model.put("query", query);
			mav=new ModelAndView("/member/memberList", model);
		} catch (Exception e) {
			_logger.error("转到客户列表失败：" + ExceptionUtil.getMsg(e));
			e.printStackTrace();
			mav = new ModelAndView(Constants.SERVICES_ERROR, model);
		}
		return mav;
	}
	/**
	 * 跳转增加客户信息
	 * @param mav
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/goAdd")
	public ModelAndView goAdd (ModelAndView mav, final HttpServletRequest request) {
		Map<String, Object> model = mav.getModel();
		try {
			List<GrhxMemberAuth> memberAuthList = grhxMemberAuthService.getAll();
			model.put("memberAuthList", memberAuthList);
			mav.setViewName("/member/editMember");
		} catch (Exception e) {
			_logger.error("转到添加客户页失败：" + ExceptionUtil.getMsg(e));
			mav = new ModelAndView(Constants.SERVICES_ERROR, model);
		}
		return mav;
	}
	/**
	 * 跳转修改客户信息
	 * @param mav
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/goEdit")
	public ModelAndView goEdit (ModelAndView mav, final HttpServletRequest request) {
		Map<String, Object> model = mav.getModel();
		try {
			String userId = request.getParameter("userId");
			GrhxMember member = grhxMemberService.getById(userId);
			model.put("member", member);
			List<GrhxMemberAuth> memberAuthList = grhxMemberAuthService.getAll();
			model.put("memberAuthList", memberAuthList);
			mav.setViewName("/member/editMember");
		} catch (Exception e) {
			_logger.error("转到修改客户页失败：" + ExceptionUtil.getMsg(e));
			mav = new ModelAndView(Constants.SERVICES_ERROR, model);
		}
		return mav;
	}
	
	/**
	 * 验证 用户名是否存在  存在 false 不存在 true 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/validateUserId")
	public boolean validateUserId (final HttpServletRequest request) {
		String userid = request.getParameter("userid");
		try {
			GrhxMember member = grhxMemberService.getById(userid.trim());
			//当前登录名称不存在
			if (member == null) return false;
		} catch (SelectException e) {
			return true;
		}
		return true;
	}
	
	/**
	 * 修改客户信息
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/editMember")
	public ModelAndView editMember (final ModelAndView mav, final HttpServletRequest request, @ModelAttribute GrhxMember member) {
		String oldUserid = request.getParameter("oldUserid");
		try {
			HttpSession session = request.getSession();
			UserInfo staff = (UserInfo)session.getAttribute(Constants.LOGINUSER);
			if(oldUserid!=null && !"".equals(oldUserid)){
				//修改
				member.setUserid(oldUserid);
				if(member.getPwd() != null && !"".equals(member.getPwd())){
					member.setPwd(Md5PwdEncoder.getMD5Str(member.getUserid()+member.getPwd()));
				}else{
					GrhxMember oldMember = grhxMemberService.getById(oldUserid);
					member.setPwd(oldMember.getPwd());
				}
				member.setOperaterid(staff.getId());
				member.setOperatetime(new Date());
				grhxMemberService.update(member);
			}else{
				//新增
				if(member.getPwd() != null && !"".equals(member.getPwd())){
					member.setPwd(Md5PwdEncoder.getMD5Str(member.getUserid()+"888888"));
				}else{
					member.setPwd(Md5PwdEncoder.getMD5Str(member.getUserid()+member.getPwd()));
				}
				member.setCreatetime(new Date());
				member.setCreateid(staff.getId());
				grhxMemberService.insert(member);
			}
			mav.getModel().put("notice", 1);
		} catch (Exception e) {
			_logger.error("修改客户信息失败：" + ExceptionUtil.getMsg(e));
			mav.getModel().put("notice", -1);
		}
		return goEdit(mav,request);
	}
	/**
	 * @param response
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/index")
	public ModelAndView index (ModelAndView mav, final HttpServletRequest request,@ModelAttribute MemberQuery query) {
		Map<String, Object> model = mav.getModel();
		try {
			mav.setViewName("/member/index");
		} catch (Exception e) {
			_logger.error("转到客户管理列表页失败：" + ExceptionUtil.getMsg(e));
			mav = new ModelAndView(Constants.SERVICES_ERROR, model);
		}
		return mav;
	}
}
