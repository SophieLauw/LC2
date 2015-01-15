package com.lc.web.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lc.pojo.User;
import com.lc.service.OrderService;
import com.lc.service.UserService;
import com.lc.service.impl.OrderServiceImpl;
import com.lc.service.impl.UserServiceImpl;

public class Controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			String path=req.getServletPath();
			String suffix="." +path.split("\\.")[1];
			path=path.split("\\.")[0];
			if("/user".equals(path)){
				UserService userService = new UserServiceImpl();			
		        //StudentService studentService = ServiceFactory.getStudentService();			
				List userList = userService.getUserList();
				req.setAttribute("userList", userList);
		        getServletContext().getRequestDispatcher("/user").forward(req, resp);
			}
			else if("/order".equals(path)){
				OrderService orderService = new OrderServiceImpl();
				List orderList = orderService.getOrderList();
				req.setAttribute("orderList", orderList);
		        getServletContext().getRequestDispatcher("/order").forward(req, resp);
			}
		} catch (Exception e){
			req.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher("/error").forward(req, resp);
		}
	}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			doGet(req,resp);
		}
	
	}