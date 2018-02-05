package com.core.utils;

import java.util.ResourceBundle;

public class Constant {

	protected static final ResourceBundle res1 = ResourceBundle.getBundle("prop");

	public final static String SYS_SESSION_VALIDATECODE = res1.getString("SYS_SESSION_VALIDATECODE");// 验证码

}