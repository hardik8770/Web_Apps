package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ReceptionistLogoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "receptionist_login.jsp";

		session.invalidate();
		
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}	