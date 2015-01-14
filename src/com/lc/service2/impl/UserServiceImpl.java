package com.lc.service2.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lc.pojo.User;
import com.lc.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public List getUserList() {
		// TODO Auto-generated method stub
        List userList = new ArrayList();		
		Connection conn = null;		
		Statement stmt = null;		
		ResultSet rs = null;
		try{
            Class.forName("com.mysql.jdbc.Driver");			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");			
			stmt = conn.createStatement();			
			rs = stmt.executeQuery("select * from users");
			
			while(rs.next()){
				User user = new User();
				
				user.setUserId(rs.getString("userid"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
												
				userList.add(user);
			}
		}
		catch(Exception ex){
		
            ex.printStackTrace();			
			throw new RuntimeException("error when querying users ",ex);
		}
		finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();				
				throw new RuntimeException("error when querying users ",ex);
			}
			
		}
		return userList;
	}

	

	
	
}
