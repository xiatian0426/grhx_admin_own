/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.acc.model;



/**
 * @version 1.0
 * @since 1.0
 */


public class GrhxMemberAuth implements java.io.Serializable{
	
	private static final long serialVersionUID = 7046109190010145780L;
	//alias
	public static final String TABLE_ALIAS = "GrhxMemberAuth";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_MEMBERTYPE = "membertype";
	public static final String ALIAS_MESSAGERIGHT = "messageright";
	public static final String ALIAS_STATE = "state";
	public static final String ALIAS_MESSAGERIGHTNAME = "messagerightname";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	
	private Integer id;
    /**
     * membertype       db_column: membertype 
     */	
	private String membertype;
    /**
     * messageright       db_column: messageright 
     */	
	private String messageright;
	/**
     * state       db_column: state 
     */	
	private String state;
	/**
     * messagerightname       db_column: messagerightname 
     */	
	private String messagerightname;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMembertype() {
		return membertype;
	}
	public void setMembertype(String membertype) {
		this.membertype = membertype;
	}
	public String getMessageright() {
		return messageright;
	}
	public void setMessageright(String messageright) {
		this.messageright = messageright;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMessagerightname() {
		return messagerightname;
	}
	public void setMessagerightname(String messagerightname) {
		this.messagerightname = messagerightname;
	}
}

