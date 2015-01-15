package com.lc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lc.pojo.OrderStatus;
import com.lc.pojo.Orderline;
import com.lc.pojo.Orders;
import com.lc.pojo.Orderview;
import com.lc.pojo.Payway;
import com.lc.pojo.User;
import com.lc.service.OrderService;
import com.lc.service.UserService;
import com.lc.service.impl.OrderServiceImpl;
import com.lc.service.impl.UserServiceImpl;

public class SV1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		try{
			
			OrderService  orderService = new OrderServiceImpl();			
	    //StudentService studentService = ServiceFactory.getStudentService();			
			List orderList = orderService.getOrderList();	
			toOrderList(resp, orderList);
		} catch (Exception e){
			toError(resp,e.getMessage());
		}
			}
			
			private void toOrderList(HttpServletResponse resp, List orderList) throws IOException {
		// TODO Auto-generated method stub
				
				PrintWriter out = resp.getWriter();
				
				out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
				out.println("<html>");
				out.println("	<head>");
				out.println("		<title>达内电子商务门户</title>");
				out.println("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
				out.println("		<meta name=\"description\" content=\"达内电子商务门户\">");
				out.println("		<link href=\"./css/tarena.css\" rel=stylesheet>");
				out.println("	</head>");
				out.println("	<body topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\">");
				out.println("<!-- Header Start -->");
				out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" id=\"table2\">");
				out.println("			<tr>");
				out.println("				<td align=\"left\" width=\"7%\" background=\"./images/top_bg.gif\"><img src=\"./images/logo.gif\" width=\"286\" height=\"58\"></td>");
				out.println("				<td width=\"62%\" background=\"./images/top_bg.gif\">　</td>");
				out.println("				<td width=\"31%\" background=\"./images/top_bg.gif\" align=\"right\"><img src=\"./images/top_r.gif\" width=\"352\" height=\"58\" border=\"0\"></td>");
				out.println("			</tr>");
				out.println("		</table>");
				out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
				out.println("			<tr>");
				out.println("				<td background=\"./images/dh_bg.gif\" align=\"left\" height=\"12\">");
				out.println("					<table width=\"100\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
				out.println("						<tr>");
				out.println("							<td width=\"5%\"></td>");
				out.println("							");
				out.println("          <td width=\"10%\"><a href=\"./four\"><img name=\"Image1\" border=\"0\" src=\"./images/index.gif\" width=\"90\" height=\"36\"></a></td>");
				out.println("							");
				out.println("          <td width=\"10%\"><a href=\"./eight\"><img name=\"Image2\" border=\"0\" src=\"./images/reg.gif\" width=\"92\" height=\"36\"></a></td>");
				out.println("							");
				out.println("          <td width=\"10%\"><a href=\"./six\"><img name=\"Image4\" border=\"0\" src=\"./images/cart.gif\" width=\"92\" height=\"36\"></a></td>");
				out.println("							");
				out.println("          <td width=\"10%\"><a href=\"./two\"><img name=\"Image5\" border=\"0\" src=\"./images/order.gif\" width=\"92\" height=\"36\"></a></td>");
				out.println("							");
				out.println("          <td width=\"10%\"><a href=\"./four\"><img name=\"Image6\" border=\"0\" src=\"./images/exit.gif\" width=\"92\" height=\"36\"></a></td>");
				out.println("						</tr>");
				out.println("					</table>");
				out.println("				</td>");
				out.println("			</tr>");
				out.println("		</table>");
				out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" border=\"0\" width=\"98%\">");
				out.println("			<tr>");
				out.println("				<td width=\"65%\"><br>");
				out.println("					>> 欢迎访问 <b>达内电子商务门户</b>");
				out.println("				</td>");
				out.println("				<td width=\"35%\" align=\"right\">");
				out.println("				</td>");
				out.println("			</tr>");
				out.println("		</table>");
				out.println("<!-- Header End -->");
				out.println("<!-- Body Start -->");
				out.println("		<table cellspacing=\"1\" cellpadding=\"3\" align=\"center\" class=\"tableBorder2\">");
				out.println("			<tr>");
				out.println("				<td height=\"25\" valign=\"middle\">");
				out.println("					<img src=\"./images/Forum_nav.gif\" align=\"absmiddle\">");
				out.println("					<a href=./index.jsp>达内电子商务门户</a> →<img border=\"0\" src=\"./images/dog.gif\" width=\"19\" height=\"18\"> 定单列表");
				out.println("				</td>");
				out.println("			</tr>");
				out.println("		</table>");
				out.println("		<br>");
				out.println("		<table cellpadding=\"3\" cellspacing=\"1\" align=\"center\" class=\"tableborder1\">");
				out.println("			<tr>");
				out.println("				<td valign=middle align=center height=25 background=\"./images/bg2.gif\"><font color=\"#ffffff\"><b>序号</b></font></td>");
				out.println("				<td valign=middle align=center height=25 background=\"./images/bg2.gif\"><font color=\"#ffffff\"><b>订单编号</b></font></td>");
				out.println("				<td valign=middle align=center height=25 background=\"./images/bg2.gif\"><font color=\"#ffffff\"><b>订单金额</b></font></td>");
				out.println("				<td valign=middle align=center height=25 background=\"./images/bg2.gif\"><font color=\"#ffffff\"><b>订单状态</b></font></td>");
				out.println("				<td valign=middle align=center height=25 background=\"./images/bg2.gif\"><font color=\"#ffffff\"><b>付款方式</b></font></td>");
				out.println("				<td valign=middle align=center height=25 background=\"./images/bg2.gif\"><font color=\"#ffffff\"><b>操作</b></font></td>");
				out.println("			</tr>");
				for(Iterator<Orderview> it = orderList.iterator();it.hasNext();){
					
					
					Orderview order = it.next();
					
					
					out.println("			<tr>");
					out.println("				<td class=tablebody2 valign=middle align=center>"+order.getLineid()+"</td>");
					out.println("				<td class=tablebody1 valign=middle>&nbsp;&nbsp;<a href=\"./one\">"+order.getOrderid()+"</a></td>");
					out.println("				<td class=tablebody2 valign=middle align=left>&nbsp;&nbsp;￥"+order.getCost()+"</td>");
					out.println("				<td class=tablebody1 valign=middle align=center>"+order.getName()+"</td>");
					out.println("				<td class=tablebody2 valign=middle align=left>&nbsp;&nbsp;"+order.getPaystyle()+" </td>");
					out.println("				<td class=tablebody1 valign=middle align=center>");
					out.println("					<input type=\"button\" value=\"删除\" onclick=\"javascript:window.location='./two';\">&nbsp;");
					out.println("					<input type=\"button\" value=\"明细\" onclick=\"javascript:window.location='./one';\">");
					out.println("				</td>");
					out.println("			</tr>");
					
				}
				out.println("		</table>");
				out.println("		<br>");
				out.println("<!-- Body End -->");
				out.println("<!-- Footer Start -->");
				out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" height=\"28\">");
				out.println("			<tr>");
				out.println("				<td height=\"17\" background=\"./images/bot_bg.gif\">");
				out.println("				</td>");
				out.println("			</tr>");
				out.println("		</table>");
				out.println("		<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">");
				out.println("			<tr>");
				out.println("				<td bgcolor=\"#f1f1f6\" height=\"53\" valign=\"center\">");
				out.println("					<p align=\"center\">");
				out.println("						Copyright &copy;2004 - 2005 <a href=\"http://www.tarena.com.cn\"><b>Tarena</b><font color=\"red\">.com.cn</font></a>");
				out.println("					</p>");
				out.println("				</td>");
				out.println("			</tr>");
				out.println("		</table>");
				out.println("<!-- Footer End -->");
				out.println("	</body>");
				out.println("</html>");
				
				
				out.close();
		
	}

			private void toError(HttpServletResponse resp, String message) throws IOException {
		// TODO Auto-generated method stub
				PrintWriter out = resp.getWriter();
				
				out.println("<html>");
				out.println("<head>");
				out.println("	<title>Error</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("	<h2 align=\"center\">Error</h2>");
				out.println("	<hr>");
				out.println("	System Error," + message + "!");
				out.println("</body>");
				out.println("</html>");
				
				out.close();
		
	}

			

			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
				
			}
		
		}