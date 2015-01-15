package com.lc.util;

import com.lc.dao.UserDao;
import com.lc.dao.impl.UserDaoImpl;

public class DaoFactory {
	
private static UserDao UserDao = new UserDaoImpl(); 
	
	public static UserDao getUserDao(){
		return UserDao;
	}

}
