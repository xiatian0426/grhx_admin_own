/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.acc.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.acc.util.CalendarUtil;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class AccCustomer implements Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "AccCustomer";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_FULL_NAME = "fullName";
	public static final String ALIAS_TELEPHONE = "telephone";
	public static final String ALIAS_EMAIL = "email";
	public static final String ALIAS_PROVINCE = "province";
	public static final String ALIAS_URL = "url";
	public static final String ALIAS_ADDRESS = "address";
	public static final String ALIAS_CORSOURCE = "corsource";
	public static final String ALIAS_CHANNEL = "channel";
	public static final String ALIAS_LEVEL = "level";
	public static final String ALIAS_CCLEVEL = "cclevel";
	public static final String ALIAS_NEXTACCESS_TIME = "nextaccessTime";
	public static final String ALIAS_REMARK = "remark";
	public static final String ALIAS_CREATE_TIME = "createTime";
	public static final String ALIAS_OPERATER_ID = "operaterId";
	public static final String ALIAS_OPERATE_TIME = "operateTime";
	public static final String ALIAS_CREATER_ID = "createrId";
	public static final String ALIAS_OWNER_ID = "ownerId";
	public static final String ALIAS_STATUS = "status";//0：正常 1：删除 2：公海
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	
	private Integer id;
    /**
     * fullName       db_column: FULL_NAME 
     */	
	private String fullName;
    /**
     * telephone       db_column: TELEPHONE 
     */	
	private String telephone;
    /**
     * email       db_column: EMAIL 
     */	
	private String email;
    /**
     * province       db_column: PROVINCE 
     */	
	private String province;
    /**
     * url       db_column: URL 
     */	
	private String url;
    /**
     * address       db_column: ADDRESS 
     */	
	private String address;
    /**
     * corsource       db_column: CORSOURCE 
     */	
	private String corsource;
    /**
     * channel       db_column: CHANNEL 
     */	
	private String channel;
    /**
     * level       db_column: LEVEL 
     */	
	private String level;
    /**
     * cclevel       db_column: CCLEVEL 
     */	
	private String cclevel;
    /**
     * nextaccessTime       db_column: NEXTACCESS_TIME 
     */	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date nextaccessTime;
	private String nextaccessTimeString;
    /**
     * remark       db_column: REMARK 
     */	
	private String remark;
    /**
     * createTime       db_column: CREATE_TIME 
     */	
	
	private Date createTime;
	private String createTimeString;
    /**
     * operaterId       db_column: OPERATER_ID 
     */	
	
	private Integer operaterId;
    /**
     * operateTime       db_column: OPERATE_TIME 
     */	
	
	private Date operateTime;
    /**
     * createrId       db_column: CREATER_ID 
     */	
	
	private Integer createrId;
	/**
     * ownerId       db_column: OWNER_ID 
     */	
	
	private Integer ownerId;
	/**
     * status       db_column: STATUS 
     */	
	
	private String status;
	/**
     * roleId       db_column: ROLE_ID 
     */	
	
	private Integer roleId;
	/**
     * customerId       db_column: CUSTOMERID 
     */	
	
	private Integer customerId;
	
	//columns END


	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setFullName(String value) {
		this.fullName = value;
	}
	
	public String getFullName() {
		return this.fullName;
	}
	public void setTelephone(String value) {
		this.telephone = value;
	}
	
	public String getTelephone() {
		return this.telephone;
	}
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setProvince(String value) {
		this.province = value;
	}
	
	public String getProvince() {
		return this.province;
	}
	public void setUrl(String value) {
		this.url = value;
	}
	
	public String getUrl() {
		return this.url;
	}
	public void setAddress(String value) {
		this.address = value;
	}
	
	public String getAddress() {
		return this.address;
	}
	public void setCorsource(String value) {
		this.corsource = value;
	}
	
	public String getCorsource() {
		return this.corsource;
	}
	public void setChannel(String value) {
		this.channel = value;
	}
	
	public String getChannel() {
		return this.channel;
	}
	public void setLevel(String value) {
		this.level = value;
	}
	
	public String getLevel() {
		return this.level;
	}
	public void setCclevel(String value) {
		this.cclevel = value;
	}
	
	public String getCclevel() {
		return this.cclevel;
	}
	
	public void setNextaccessTime(Date value) {
		this.nextaccessTime = value;
	}
	
	public Date getNextaccessTime() {
		return this.nextaccessTime;
	}
	public void setRemark(String value) {
		this.remark = value;
	}
	
	public String getRemark() {
		return this.remark;
	}
	
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setOperaterId(Integer value) {
		this.operaterId = value;
	}
	
	public Integer getOperaterId() {
		return this.operaterId;
	}
	
	public void setOperateTime(Date value) {
		this.operateTime = value;
	}
	
	public Date getOperateTime() {
		return this.operateTime;
	}
	public void setCreaterId(Integer value) {
		this.createrId = value;
	}
	
	public Integer getCreaterId() {
		return this.createrId;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNextaccessTimeString() {
		if(getNextaccessTime()!=null){
			return CalendarUtil.dateToString(getNextaccessTime(), "yyyy-MM-dd");
		}else{
			return "";
		}
	}

	public void setNextaccessTimeString(String nextaccessTimeString) {
		this.nextaccessTimeString = nextaccessTimeString;
		if (StringUtils.isNotEmpty(nextaccessTimeString) && !"--".equals(nextaccessTimeString)) {
			this.nextaccessTime = CalendarUtil.stringToDate(nextaccessTimeString, CalendarUtil.DATE_FORMAT);
		}
	}

	public String getCreateTimeString() {
		if(getCreateTime()!=null){
			return CalendarUtil.dateToString(getCreateTime(), "yyyy-MM-dd HH:mm:ss");
		}else{
			return "";
		}
	}

	public void setCreateTimeString(String createTimeString) {
		this.createTimeString = createTimeString;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

}

