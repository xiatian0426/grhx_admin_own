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


public class FrontData implements Serializable{
	
	private static final long serialVersionUID = 516612906788122775L;
	//columns START
    /**
     * id       db_column: ID 
     */	
	private Integer id;
	private String name;
	private String url;
	private String type;
	private Integer createrid;
	private Date createtime;
	private String createDateString;
	private Integer operaterid;
	private Date operatetime;
	private Integer isdelete;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getCreaterid() {
		return createrid;
	}
	public void setCreaterid(Integer createrid) {
		this.createrid = createrid;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getCreateDateString() {
		if(getCreatetime()!=null){
			return CalendarUtil.dateToString(getCreatetime(), "yyyy-MM-dd HH:mm:ss");
		}else{
			return "";
		}
	}
	public void setCreateDateString(String createDateString) {
		this.createDateString = createDateString;
	}
	public Integer getOperaterid() {
		return operaterid;
	}
	public void setOperaterid(Integer operaterid) {
		this.operaterid = operaterid;
	}
	public Date getOperatetime() {
		return operatetime;
	}
	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}
	public Integer getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	
}

