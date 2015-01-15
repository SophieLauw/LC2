package com.lc.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lc.pojo.User;
import com.lc.service.UserService;
import com.lc.util.DaoFactory;

public class UserServiceImpl implements UserService{

	@Override
	public List getUserList() {
		// TODO Auto-generated method stub
       return DaoFactory.getUserDao().getUserList();
	}

	@Override
	public User getUser(User paramUser) {
		// TODO Auto-generated method stub
		return DaoFactory.getUserDao().getUser(paramUser);
	}
	

	

	
	
}
