package com.event.test.impl;

import com.event.test.DemoCallback;


public class DemoCallbackImpl implements DemoCallback {
	
	public static String onreturn = "...";
	public static String onthrow = "...";
	
	@Override
	public String onreturn() {
		onreturn = "数据已被返回！！！";
		return "数据已被返回！！！";
	}

	@Override
	public String onthrow() {
		onthrow = "出现错误！！！";
		return "出现错误！！！";
	}

}
