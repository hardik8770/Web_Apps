package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.regex.*;

import models.*;

public class AdminLoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		String next_page = "admin_welcome.jsp";
		boolean flag = true;
		String email = request.getParameter("email"); 
		String password = request.getParameter("password"); 
		String err_msg = "";
		
		Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
		Matcher m = p.matcher(email.trim());
		
		//Validation:
		
		if(email.trim().equals("")){
			flag = false;
			err_msg = err_msg + "Email Field Is Empty!!! <br />";
		}
		if(!m.matches()){
			flag = false;
			err_msg = err_msg + "Incorrect Pattern Of Email <br />";
		}

		if(password.trim().equals("")){
			flag = false;
			err_msg = err_msg + "Password Field Is Empty !!! <br />";
		}

		if(flag){
			
			User user = new User(email,password);
			
			if(user.isLoginSuccess()&&user.getUserType().getUserTypeId()==1){
				next_page = "admin_dashboard.jsp";
				session.setAttribute("user",user);
			}else{
				err_msg = err_msg + "Incorrect Credentials";
				request.setAttribute("err_msg",err_msg);
			}
		}else{
			request.setAttribute("err_msg",err_msg);
		}

		request.getRequestDispatcher(next_page).forward(request,response);
	}
}