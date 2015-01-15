package com.lc.dao;

import java.util.List;

import com.lc.pojo.User;

public interface UserDao {
	
	public List getUserList();	
	public User getUser(User paramUser);

}
