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


public class AccIp implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "AccIp";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_IP = "ip";
	public static final String ALIAS_IS_DELETED = "isDeleted";
	public static final String ALIAS_DESCRIP = "descrip";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: ID 
     */	
	
	private Integer id;
    /**
     * ip       db_column: IP 
     */	
	private String ip;
    /**
     * isDeleted       db_column: isDeleted 
     */	
	private String isDeleted;
    /**
     * descrip       db_column: descrip 
     */	
	private String descrip;
	//columns END

	public AccIp(){
	}

	public AccIp(
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
	public void setIp(String value) {
		this.ip = value;
	}
	
	public String getIp() {
		return this.ip;
	}
	public void setIsDeleted(String value) {
		this.isDeleted = value;
	}
	
	public String getIsDeleted() {
		return this.isDeleted;
	}
	public void setDescrip(String value) {
		this.descrip = value;
	}
	
	public String getDescrip() {
		return this.descrip;
	}

}

