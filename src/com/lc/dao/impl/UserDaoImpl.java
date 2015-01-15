package com.lc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lc.dao.UserDao;
import com.lc.pojo.User;
import com.lc.util.ConnectionFactory;

public class UserDaoImpl implements UserDao{

	@Override
	public List getUserList() {
		// TODO Auto-generated method stub
		List userList = new ArrayList();		
		Connection conn = null;		
		Statement stmt = null;		
		ResultSet rs = null;
		try{
			conn = ConnectionFactory.getConnection();
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


	@Override
	public User getUser(User paramUser) {
		// TODO Auto-generated method stub
		Connection conn = null;		
		Statement stmt = null;		
		ResultSet rs = null;
		try{
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();		
			rs = stmt.executeQuery("select * from users where userid='"
					+ paramUser.getUserId() + "' and password='"
					+ paramUser.getPassword() + "'");
			
			while(rs.next()){
				User user = new User();
				
				user.setUserId(rs.getString("userid"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
					
				return user;
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
		return null;
	}
	

}
