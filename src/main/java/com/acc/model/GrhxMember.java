/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.acc.model;

import java.util.Date;

import com.acc.util.CalendarUtil;


/**
 * @version 1.0
 * @since 1.0
 */


public class GrhxMember implements java.io.Serializable{
	
	private static final long serialVersionUID = 8565694830649765342L;
	//alias
	public static final String TABLE_ALIAS = "GrhxMember";
	public static final String ALIAS_USERID = "userid";
	public static final String ALIAS_PWD = "pwd";
	public static final String ALIAS_PHONE = "phone";
	public static final String ALIAS_TEL = "tel";
	public static final String ALIAS_LINKMAN = "linkman";
	public static final String ALIAS_COMPANY = "company";
	public static final String ALIAS_CREATEID = "createid";
	public static final String ALIAS_CREATETIME = "createtime";
	public static final String ALIAS_AUTHID = "authid";
	public static final String ALIAS_SEX = "sex";
	public static final String ALIAS_OPERATERID = "operaterid";
	public static final String ALIAS_OPERATETIME = "operatetime";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * userid       db_column: userid 
     */	
	
	private String userid;
    /**
     * pwd       db_column: pwd 
     */	
	private String pwd;
    /**
     * phone       db_column: phone 
     */	
	private String phone;
	/**
     * tel       db_column: tel 
     */	
	private String tel;
	/**
     * linkman       db_column: linkman 
     */	
	private String linkman;
	/**
     * company       db_column: company 
     */	
	private String company;
	/**
     * createid       db_column: createid 
     */	
	private Integer createid;
	/**
     * createtime       db_column: createtime 
     */	
	private Date createtime;
	private String createtimeString;
	/**
     * authid       db_column: authid 
     */	
	private String authid;
	/**
     * sex       db_column: sex 
     */	
	private String sex;
	/**
     * operaterid       db_column: operaterid 
     */	
	private Integer operaterid;
	/**
     * operatetime       db_column: operatetime 
     */	
	private Date operatetime;
	private String operatetimeString;
	private Integer status;
	//columns END

	public GrhxMember(){
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setOperaterid(Integer operaterid) {
		this.operaterid = operaterid;
	}
	
	public Integer getOperaterid() {
		return operaterid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAuthid() {
		return authid;
	}

	public void setAuthid(String authid) {
		this.authid = authid;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreatetimeString() {
		if(getCreatetime()!=null){
			return CalendarUtil.dateToString(getCreatetime(), "yyyy-MM-dd HH:mm:ss");
		}else{
			return "";
		}
	}

	public void setCreatetimeString(String createtimeString) {
		this.createtimeString = createtimeString;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}

	public String getOperatetimeString() {
		if(getOperatetime()!=null){
			return CalendarUtil.dateToString(getOperatetime(), "yyyy-MM-dd HH:mm:ss");
		}else{
			return "";
		}
	}

	public void setOperatetimeString(String operatetimeString) {
		this.operatetimeString = operatetimeString;
	}

	public Integer getCreateid() {
		return createid;
	}

	public void setCreateid(Integer createid) {
		this.createid = createid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}

