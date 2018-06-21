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


public class AccBusinessContact implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "AccBusinessContact";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CUSTOMER_ID = "customerId";
	public static final String ALIAS_BUSINESS_ID = "businessId";
	public static final String ALIAS_LINK_MAN = "linkMan";
	public static final String ALIAS_WAY = "way";
	public static final String ALIAS_BUSINESS_ROLE = "businessRole";
	public static final String ALIAS_NEXT_TIME = "nextTime";
	public static final String ALIAS_CONTENT = "content";
	public static final String ALIAS_REMARK = "remark";
	public static final String ALIAS_CREATE_TIME = "createTime";
	public static final String ALIAS_CREATERID = "createrid";
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
     * businessId       db_column: BUSINESS_ID 
     */	
	
	private Integer businessId;
    /**
     * linkMan       db_column: LINK_MAN 
     */	
	private String linkMan;
    /**
     * way       db_column: WAY 
     */	
	private String way;
    /**
     * businessRole       db_column: BUSINESS_ROLE 
     */	
	private String businessRole;
    /**
     * nextTime       db_column: NEXT_TIME 
     */	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date nextTime;
	private String nextTimeString;
    /**
     * content       db_column: CONTENT 
     */	
	private String content;
    /**
     * remark       db_column: REMARK 
     */	
	private String remark;
    /**
     * createTime       db_column: CREATE_TIME 
     */	
	
	private Date createTime;
    /**
     * createrid       db_column: CREATERID 
     */	
	
	private Integer createrid;
    /**
     * type       db_column: TYPE 
     */	
	private String type;
	/**
     * roleId       db_column: ROLE_ID 
     */	
	private Integer roleId;
	
	private Integer operaterId;
	private Date operateTime;
	//columns END

	public Integer getOperaterId() {
		return operaterId;
	}

	public void setOperaterId(Integer operaterId) {
		this.operaterId = operaterId;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public AccBusinessContact(){
	}

	public AccBusinessContact(
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
	public void setBusinessId(Integer value) {
		this.businessId = value;
	}
	
	public Integer getBusinessId() {
		return this.businessId;
	}
	public void setLinkMan(String value) {
		this.linkMan = value;
	}
	
	public String getLinkMan() {
		return this.linkMan;
	}
	public void setWay(String value) {
		this.way = value;
	}
	
	public String getWay() {
		return this.way;
	}
	public void setBusinessRole(String value) {
		this.businessRole = value;
	}
	
	public String getBusinessRole() {
		return this.businessRole;
	}
	
	public void setNextTime(Date value) {
		this.nextTime = value;
	}
	
	public Date getNextTime() {
		return this.nextTime;
	}
	public void setContent(String value) {
		this.content = value;
	}
	
	public String getContent() {
		return this.content;
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
	public void setCreaterid(Integer value) {
		this.createrid = value;
	}
	
	public Integer getCreaterid() {
		return this.createrid;
	}
	public void setType(String value) {
		this.type = value;
	}
	
	public String getType() {
		return this.type;
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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}

