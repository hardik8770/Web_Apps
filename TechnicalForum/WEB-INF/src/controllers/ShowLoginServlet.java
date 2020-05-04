package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;

public class ShowLoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		String next_page = "login.jsp";
		
		request.getRequestDispatcher(next_page).forward(request,response);
	}
}