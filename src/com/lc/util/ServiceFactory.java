package com.lc.util;

import com.lc.service.UserService;
import com.lc.service.impl.UserServiceImpl;

public class ServiceFactory {

private static UserService userService = new UserServiceImpl(); 
	
	public static UserService getUserService(){
		return userService;
	}
	
}
