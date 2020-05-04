package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class UserLoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		
		HttpSession session = request.getSession();
		
		String nextPage = "user_login.jsp";
		boolean flag = false;
		
		// Getting Parameters - 

		String userName = request.getParameter("user_email");
		String userPassword = request.getParameter("user_password");

		System.out.println(userName);
		System.out.println(userPassword);
		
		//
	}
}