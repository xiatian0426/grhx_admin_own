/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.acc.model;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class AccField implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "AccField";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_FIELD_NAME = "fieldName";
	public static final String ALIAS_STATE = "state";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: ID 
     */	
	
	private Integer id;
    /**
     * fieldName       db_column: FIELD_NAME 
     */	
	private String fieldName;
    /**
     * state       db_column: STATE 
     */	
	private String state;
	//columns END

	public AccField(){
	}

	public AccField(
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
	public void setFieldName(String value) {
		this.fieldName = value;
	}
	
	public String getFieldName() {
		return this.fieldName;
	}
	public void setState(String value) {
		this.state = value;
	}
	
	public String getState() {
		return this.state;
	}

}

