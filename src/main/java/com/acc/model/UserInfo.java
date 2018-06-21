/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.acc.model;

import java.io.Serializable;
import java.util.Date;

import com.acc.util.CalendarUtil;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class UserInfo implements Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "UserInfo";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USER_NAME = "userName";
	public static final String ALIAS_USER_PASSWORD = "userPassword";
	public static final String ALIAS_CREATE_DATE = "createDate";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_USERREALNAME = "userRealname";
	
	//columns START
    /**
     * id       db_column: ID 
     */	
	
	private Integer id;
    /**
     * userName       db_column: USER_NAME 
     */	
	
	private String userName;
	
    /**
     * userPassword       db_column: USER_PASSWORD 
     */	
	private String userPassword;
	
    /**
     * createDate       db_column: CREATE_DATE 
     */	
	
	private Date createDate;
	private String createDateString;
	
	/**
     * createrId       db_column: CREATER_ID 
     */	
	
	private int createrId;
	
    /**
     * status       db_column: STATUS 
     */	
	private String status;
	/**
     * modifyDate       db_column: MODIFY_DATE 
     */	
	private String modifyDate;
	/**
     * modifierId       db_column: MODIFIER_ID
     */	
	private String modifierId;
	/**
     * roleId       db_column: ROLE_ID 
     */	
	private String roleId;
	/**
     * manageDepart       db_column: MANAGEDEPART 
     */	
	private String manageDepart;
	/**
     * departClass       db_column: DEPARTCLASS 
     */	
	private String departClass;
	/**
     * userRealname       db_column: USER_REALNAME 
     */	
	private String userRealname;
	/**
     * maxCustomerNum       db_column: MAX_CUSTOMER_NUM 
     */	
	private String maxCustomerNum;
	/**
	 * total
	 */
	private Integer total;
	//columns END


	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setUserName(String value) {
		this.userName = value;
	}
	
	public String getUserName() {
		return this.userName;
	}
	public void setUserPassword(String value) {
		this.userPassword = value;
	}
	
	public String getUserPassword() {
		return this.userPassword;
	}
	
	public void setCreateDate(Date value) {
		this.createDate = value;
	}
	
	public Date getCreateDate() {
		return this.createDate;
	}
	public void setStatus(String value) {
		this.status = value;
	}
	
	public String getStatus() {
		return this.status;
	}

	public int getCreaterId() {
		return createrId;
	}

	public void setCreaterId(int createrId) {
		this.createrId = createrId;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifierId() {
		return modifierId;
	}

	public void setModifierId(String modifierId) {
		this.modifierId = modifierId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getManageDepart() {
		return manageDepart;
	}

	public void setManageDepart(String manageDepart) {
		this.manageDepart = manageDepart;
	}

	public String getDepartClass() {
		return departClass;
	}

	public void setDepartClass(String departClass) {
		this.departClass = departClass;
	}

	public String getUserRealname() {
		return userRealname;
	}

	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname;
	}
	
	public String getMaxCustomerNum() {
		return maxCustomerNum;
	}

	public void setMaxCustomerNum(String maxCustomerNum) {
		this.maxCustomerNum = maxCustomerNum;
	}

	public String getCreateDateString() {
		if(getCreateDate()!=null){
			return CalendarUtil.dateToString(getCreateDate(), "yyyy-MM-dd HH:mm:ss");
		}else{
			return "";
		}
	}

	public void setCreateDateString(String createDateString) {
		this.createDateString = createDateString;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", createDate="
				+ createDate + ", createrId=" + createrId + ", status="
				+ status + ", modifyDate=" + modifyDate + ", modifierId="
				+ modifierId + ", roleId=" + roleId + ", manageDepart="
				+ manageDepart + ", departClass=" + departClass
				+ ", userRealname=" + userRealname + "]";
	}
	
	
}

