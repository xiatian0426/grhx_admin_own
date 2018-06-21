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


public class AccLecture implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "AccLecture";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CUSTOMER_ID = "customerId";
	public static final String ALIAS_LECTURE_NAME = "lectureName";
	public static final String ALIAS_LECTURER = "lecturer";
	public static final String ALIAS_LECTURE_TIME = "lectureTime";
	public static final String ALIAS_ISDELETE = "isdelete";
	public static final String ALIAS_CREATE_TIME = "createTime";
	public static final String ALIAS_CREATERID = "createrid";
	public static final String ALIAS_OPERATER_ID = "operaterId";
	public static final String ALIAS_OPERATE_TIME = "operateTime";
	public static final String ALIAS_TYPE = "type";
	public static final String ALIAS_REMARK = "remark";
	
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
     * lectureName       db_column: LECTURE_NAME 
     */	
	private String lectureName;
    /**
     * lecturer       db_column: LECTURER 
     */	
	private String lecturer;
    /**
     * lectureTime       db_column: LECTURE_TIME 
     */	
	
	private Date lectureTime;
	private String lectureTimeString;
    /**
     * isdelete       db_column: ISDELETE 
     */	
	private String isdelete;
    /**
     * createTime       db_column: CREATE_TIME 
     */	
	
	private Date createTime;
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
     * remark       db_column: REMARK 
     */	
	private String remark;
	/**
     * roleId       db_column: ROLE_ID 
     */	
	private Integer roleId;
	
	//columns END

	public AccLecture(){
	}

	public AccLecture(
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
	public void setLectureName(String value) {
		this.lectureName = value;
	}
	
	public String getLectureName() {
		return this.lectureName;
	}
	public void setLecturer(String value) {
		this.lecturer = value;
	}
	
	public String getLecturer() {
		return this.lecturer;
	}
	
	public void setLectureTime(Date value) {
		this.lectureTime = value;
	}
	
	public Date getLectureTime() {
		return this.lectureTime;
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
	public void setType(String value) {
		this.type = value;
	}
	
	public String getType() {
		return this.type;
	}

	public String getLectureTimeString() {
		if(getLectureTime()!=null){
			return CalendarUtil.dateToString(getLectureTime(),"yyyy-MM-dd");
		}else{
			return "";
		}
	}

	public void setLectureTimeString(String lectureTimeString) {
		this.lectureTimeString = lectureTimeString;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}

