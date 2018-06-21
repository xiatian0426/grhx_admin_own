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


public class AccSeqTable implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "AccSeqTable";
	public static final String ALIAS_TABLE_NAME = "tableName";
	public static final String ALIAS_TABLE_ROW_VALUE = "tableRowValue";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * tableName       db_column: TABLE_NAME 
     */	
	private String tableName;
    /**
     * tableRowValue       db_column: TABLE_ROW_VALUE 
     */	
	private Integer tableRowValue;
	//columns END

	public AccSeqTable(){
	}


	public void setTableName(String value) {
		this.tableName = value;
	}
	
	public String getTableName() {
		return this.tableName;
	}
	public void setTableRowValue(Integer value) {
		this.tableRowValue = value;
	}
	
	public Integer getTableRowValue() {
		return this.tableRowValue;
	}

}

