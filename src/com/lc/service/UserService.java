package com.lc.service;
import java.util.List;

import com.lc.pojo.User;


public interface UserService {

	public List getUserList();
	public User getUser(User paramUser);
}
