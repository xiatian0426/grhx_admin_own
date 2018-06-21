/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.acc.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.acc.util.CalendarUtil;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class AccBusiness implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "AccBusiness";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CUSTOMER_ID = "customerId";
	public static final String ALIAS_BUSINESS_NAME = "businessName";
	public static final String ALIAS_OWNER_ID = "ownerId";
	public static final String ALIAS_DEMANDPATTERN = "demandpattern";
	public static final String ALIAS_STAGE = "stage";
	public static final String ALIAS_PRICE = "price";
	public static final String ALIAS_SCHEDULED_TIME = "scheduledTime";
	public static final String ALIAS_THEME = "theme";
	public static final String ALIAS_NEXT_TIME = "nextTime";
	public static final String ALIAS_BUSINESS_ROLE = "businessRole";
	public static final String ALIAS_LECTURER = "lecturer";
	public static final String ALIAS_ISDELETE = "isdelete";
	public static final String ALIAS_CREATE_TIME = "createTime";
	public static final String ALIAS_CREATERID = "createrid";
	public static final String ALIAS_OPERATER_ID = "operaterId";
	public static final String ALIAS_OPERATE_TIME = "operateTime";
	public static final String ALIAS_TYPE = "type";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: ID 
     */	
	
	private Integer id;
    /**
     * customerId       db_column: CUSTOMER_ID 
     */	
	private Integer customerId;
    /**
     * businessName       db_column: BUSINESS_NAME 
     */	
	private String businessName;
    /**
     * ownerId       db_column: OWNER_ID 
     */	
	
	private Integer ownerId;
    /**
     * demandpattern       db_column: DEMANDPATTERN 
     */	
	private String demandpattern;
    /**
     * stage       db_column: STAGE 
     */	
	private String stage;
    /**
     * price       db_column: PRICE 
     */	
	
	private String price;
    /**
     * scheduledTime       db_column: SCHEDULED_TIME 
     */	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date scheduledTime;
	private String scheduledTimeString;
    /**
     * theme       db_column: THEME 
     */	
	private String theme;
    /**
     * nextTime       db_column: NEXT_TIME 
     */	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date nextTime;
	private String nextTimeString;
    /**
     * businessRole       db_column: BUSINESS_ROLE 
     */	
	private String businessRole;
    /**
     * lecturer       db_column: LECTURER 
     */	
	private String lecturer;
    /**
     * isdelete       db_column: ISDELETE 
     */	
	private String isdelete;
    /**
     * createTime       db_column: CREATE_TIME 
     */	
	
	private Date createTime;
	private String createTimeString;
    /**
     * createrid       db_column: CREATERID 
     */	
	
	private Integer createrid;
    /**
     * operaterId       db_column: OPERATER_ID 
     */	
	
	private Integer operaterId;
    /**
     * operateTime       db_column: OPERATE_TIME 
     */	
	
	private Date operateTime;
	/**
     * type       db_column: TYPE 
     */	
	private String type;
	/**
     * roleId       db_column: ROLE_ID 
     */	
	private Integer roleId;
	
	private String fullName;
	//columns END

	public AccBusiness(){
	}

	public AccBusiness(
		Integer id
	){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setCustomerId(Integer value) {
		this.customerId = value;
	}
	
	public Integer getCustomerId() {
		return this.customerId;
	}
	public void setBusinessName(String value) {
		this.businessName = value;
	}
	
	public String getBusinessName() {
		return this.businessName;
	}
	public void setOwnerId(Integer value) {
		this.ownerId = value;
	}
	
	public Integer getOwnerId() {
		return this.ownerId;
	}
	public void setDemandpattern(String value) {
		this.demandpattern = value;
	}
	
	public String getDemandpattern() {
		return this.demandpattern;
	}
	public void setStage(String value) {
		this.stage = value;
	}
	
	public String getStage() {
		return this.stage;
	}
	public void setPrice(String value) {
		this.price = value;
	}
	
	public String getPrice() {
		return this.price;
	}
	
	public void setScheduledTime(Date value) {
		this.scheduledTime = value;
	}
	
	public Date getScheduledTime() {
		return this.scheduledTime;
	}
	public void setTheme(String value) {
		this.theme = value;
	}
	
	public String getTheme() {
		return this.theme;
	}
	
	public void setNextTime(Date value) {
		this.nextTime = value;
	}
	
	public Date getNextTime() {
		return this.nextTime;
	}
	public void setBusinessRole(String value) {
		this.businessRole = value;
	}
	
	public String getBusinessRole() {
		return this.businessRole;
	}
	public void setLecturer(String value) {
		this.lecturer = value;
	}
	
	public String getLecturer() {
		return this.lecturer;
	}
	public void setIsdelete(String value) {
		this.isdelete = value;
	}
	
	public String getIsdelete() {
		return this.isdelete;
	}
	
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setCreaterid(Integer value) {
		this.createrid = value;
	}
	
	public Integer getCreaterid() {
		return this.createrid;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getScheduledTimeString() {
		if(getScheduledTime()!=null){
			return CalendarUtil.dateToString(getScheduledTime(), "yyyy-MM-dd");
		}else{
			return "";
		}
	}

	public void setScheduledTimeString(String scheduledTimeString) {
		this.scheduledTimeString = scheduledTimeString;
	}

	public String getNextTimeString() {
		if(getNextTime()!=null){
			return CalendarUtil.dateToString(getNextTime(), "yyyy-MM-dd");
		}else{
			return "";
		}
	}

	public void setNextTimeString(String nextTimeString) {
		this.nextTimeString = nextTimeString;
	}

	public String getCreateTimeString() {
		if(getCreateTime()!=null){
			return CalendarUtil.dateToString(getCreateTime(), "yyyy-MM-dd");
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}

