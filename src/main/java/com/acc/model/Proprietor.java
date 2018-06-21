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


public class Proprietor implements Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//columns START
    /**
     * id       db_column: ID 
     */	
	private Integer id;
	private String company;
	private String linkman;
	private String tel;
	private String address;
	private String type;
	private Integer createrid;
	private Date createtime;
	private String createDateString;
	private Integer operaterid;
	private Date operatetime;
	//columns END
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
}

