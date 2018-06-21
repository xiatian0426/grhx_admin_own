/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.acc.model;

import java.util.Date;

/**
 * @version 1.0
 * @since 1.0
 */


public class GrhxCrawler implements java.io.Serializable{
	
	private static final long serialVersionUID = -3577098100663269648L;
	//alias
	public static final String TABLE_ALIAS = "GrhxCrawler";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_TITLE = "title";
	public static final String ALIAS_CREATE_TIME = "createTime";
	public static final String ALIAS_DATE = "date";
	public static final String ALIAS_PROVINCE = "province";
	public static final String ALIAS_MESSAGETYPE = "messagetype";
	public static final String ALIAS_CONTENT = "content";
	public static final String ALIAS_WEBTYPE = "webtype";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: ID 
     */	
	
	private Integer id;
    /**
     * title       db_column: TITLE 
     */	
	private String title;
    /**
     * createTime       db_column: CREATE_TIME 
     */	
	
	private Date createTime;
    /**
     * date       db_column: DATE 
     */	
	private String date;
	/**
     * province       db_column: PROVINCE 
     */	
	private String province;
	/**
     * messagetype       db_column: MESSAGETYPE 
     */	
	private String messagetype;
	/**
     * content       db_column: CONTENT 
     */
	private String content;
	/**
     * webtype       db_column: WEBTYPE 
     */	
	private String webtype;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getMessagetype() {
		return messagetype;
	}
	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}
	public String getWebtype() {
		return webtype;
	}
	public void setWebtype(String webtype) {
		this.webtype = webtype;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}

