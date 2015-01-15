package com.lc.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lc.pojo.OrderStatus;
import com.lc.pojo.Orderline;
import com.lc.pojo.Orders;
import com.lc.pojo.Orderview;
import com.lc.pojo.Payway;
import com.lc.service.OrderService;

public class OrderServiceImpl implements OrderService{

	@Override
	public List getOrderList() {
		// TODO Auto-generated method stub
		List orderList = new ArrayList();	
		Connection conn = null;		
		Statement stmt = null;		
		ResultSet rs = null;
		try{
            Class.forName("com.mysql.jdbc.Driver");			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");			
			stmt = conn.createStatement();			
			rs = stmt.executeQuery("select * from orderview");
			
			while(rs.next()){
				Orderview orderview = new Orderview();
				
				
				orderview.setLineid(rs.getString("lineid"));
				orderview.setOrderid(rs.getString("orderid"));
				orderview.setCost(rs.getString("cost"));
				orderview.setName(rs.getString("name"));
		        orderview.setPaystyle(rs.getString("paystyle"));
												
				orderList.add(orderview);
				
			}
		}
		catch(Exception ex){
		
            ex.printStackTrace();			
			throw new RuntimeException("error when querying orders ",ex);
		}
		finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();				
				throw new RuntimeException("error when querying orders ",ex);
			}
			
		}
		return orderList;
	}
	

}
