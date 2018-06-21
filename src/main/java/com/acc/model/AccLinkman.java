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
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class AccLinkman implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "AccLinkman";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CUSTOMER_ID = "customerId";
	public static final String ALIAS_LINKMAN_NAME = "linkmanName";
	public static final String ALIAS_PHONE = "phone";
	public static final String ALIAS_TELEPHONE = "telephone";
	public static final String ALIAS_DEPARTMENT = "department";
	public static final String ALIAS_POSITION = "position";
	public static final String ALIAS_EMAIL = "email";
	public static final String ALIAS_ROLE = "role";
	public static final String ALIAS_IMPORTANT_REMARK = "importantRemark";
	public static final String ALIAS_STATE = "state";
	public static final String ALIAS_RESPONSIBLEAREA = "responsiblearea";
	public static final String ALIAS_REMARK = "remark";
	public static final String ALIAS_ISDELETE = "isdelete";
	public static final String ALIAS_CREATE_TIME = "createTime";
	public static final String ALIAS_CREATERID = "createrid";
	public static final String ALIAS_OPERATER_ID = "operaterId";
	public static final String ALIAS_OPERATE_TIME = "operateTime";
	
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
     * linkmanName       db_column: LINKMAN_NAME 
     */	
	private String linkmanName;
    /**
     * phone       db_column: PHONE 
     */	
	private String phone;
    /**
     * telephone       db_column: TELEPHONE 
     */	
	private String telephone;
    /**
     * department       db_column: DEPARTMENT 
     */	
	private String department;
    /**
     * position       db_column: POSITION 
     */	
	private String position;
    /**
     * email       db_column: EMAIL 
     */	
	private String email;
    /**
     * role       db_column: ROLE 
     */	
	private String role;
    /**
     * importantRemark       db_column: IMPORTANT_REMARK 
     */	
	private String importantRemark;
    /**
     * state       db_column: STATE 
     */	
	private String state;
    /**
     * responsiblearea       db_column: RESPONSIBLEAREA 
     */	
	private String responsiblearea;
    /**
     * remark       db_column: REMARK 
     */	
	private String remark;
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
	private String operaterName;
    /**
     * operateTime       db_column: OPERATE_TIME 
     */	
	
	private Date operateTime;
	private String operateTimeString;
	/**
     * roleId       db_column: ROLE_ID 
     */	
	private Integer roleId;
	
	private String linkmanEnName;
	
	private String sex;
	private String postStatus;
	//columns END

	public AccLinkman(){
	}

	public AccLinkman(
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
	public void setLinkmanName(String value) {
		this.linkmanName = value;
	}
	
	public String getLinkmanName() {
		return this.linkmanName;
	}
	public void setPhone(String value) {
		this.phone = value;
	}
	
	public String getPhone() {
		return this.phone;
	}
	public void setTelephone(String value) {
		this.telephone = value;
	}
	
	public String getTelephone() {
		return this.telephone;
	}
	public void setDepartment(String value) {
		this.department = value;
	}
	
	public String getDepartment() {
		return this.department;
	}
	public void setPosition(String value) {
		this.position = value;
	}
	
	public String getPosition() {
		return this.position;
	}
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setRole(String value) {
		this.role = value;
	}
	
	public String getRole() {
		return this.role;
	}
	public void setImportantRemark(String value) {
		this.importantRemark = value;
	}
	
	public String getImportantRemark() {
		return this.importantRemark;
	}
	public void setState(String value) {
		this.state = value;
	}
	
	public String getState() {
		return this.state;
	}
	public void setResponsiblearea(String value) {
		this.responsiblearea = value;
	}
	
	public String getResponsiblearea() {
		return this.responsiblearea;
	}
	public void setRemark(String value) {
		this.remark = value;
	}
	
	public String getRemark() {
		return this.remark;
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

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperateTimeString() {
		if(getOperateTime()!=null){
			return CalendarUtil.dateToString(getOperateTime(), "yyyy-MM-dd");
		}else{
			return "";
		}
	}

	public void setOperateTimeString(String operateTimeString) {
		this.operateTimeString = operateTimeString;
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

	public String getOperaterName() {
		return operaterName;
	}

	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}

	public String getLinkmanEnName() {
		return linkmanEnName;
	}

	public void setLinkmanEnName(String linkmanEnName) {
		this.linkmanEnName = linkmanEnName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPostStatus() {
		return postStatus;
	}

	public void setPostStatus(String postStatus) {
		this.postStatus = postStatus;
	}
	
}

