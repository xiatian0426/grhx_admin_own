package com.acc.util;

public class Constants {

	public static final String PAGE_NOT_FOUND = "/prompt/404";
	public static final String SERVICES_ERROR = "/prompt/500";
	
	public final static String LOGINUSER = "SESSIONLOGINUSER";
	public final static String VALIDATESESSION = "VALIDATECODESESSION";
	//存入cookie的名称
	public static final String COOKIESUSERNAME = "cookieUserName";
	//cookies存放有效期(单位：秒)
	public static final int COOKIESTIMES = 60 * 60 * 24 * 3;
}
