package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;

public class LogoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		User user1 = (User)session.getAttribute("user1");
		
		String next_page = "index.jsp";

		if(user!=null&&user.getUserType().getUserTypeId()==1){
			next_page = "admin_welcome.jsp";
		}
		session.invalidate();

		request.getRequestDispatcher(next_page).forward(request,response);
	}
}