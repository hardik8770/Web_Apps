package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;

public class ShowQuestionFormServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user1");

		String next_page = "login.jsp";
		
		if(user!=null){
			next_page = "questions_form.jsp";
		}
		request.getRequestDispatcher(next_page).forward(request,response);
	}
}