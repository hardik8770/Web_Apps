package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DoctorLogoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "doctor_login.jsp";

		session.invalidate();
		
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}	