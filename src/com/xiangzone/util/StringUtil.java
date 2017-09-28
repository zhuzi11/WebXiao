package com.xiangzone.util;

import java.util.HashSet;
import java.util.Set;

public class StringUtil {

	/**
	 * 根据url后缀，判断是否拦截
	 * @param url
	 * @return
	 */
	public static boolean checkUrl(String url){
		Set<String> set = new HashSet<String>();
		set.add(".css");
		set.add(".js");
		set.add(".jpg");
		set.add(".png");
		set.add(".map");
		set.add("login.jsp");
		set.add("register.jsp");
		return set.contains(url);
	}
}
