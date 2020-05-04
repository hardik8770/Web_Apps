package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.regex.*;
import models.*;

public class RegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		String next_page = "register_form.jsp";
		
		boolean flag = true;
		
		String userName = request.getParameter("user_name").trim(); 
		String email = request.getParameter("email"); 
		String password = request.getParameter("password"); 
		String rePassword = request.getParameter("repassword").trim(); 

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

		if(userName.equals("")){
			flag = false;
			err_msg += "User Name Is Invalid...<br />";
		}

		if(!password.equals(rePassword)){
			flag = false;
			err_msg += "password and repassword mismatch...<br />"; 
		}

		if(flag){
			
			User user = new User(userName,email,password);
			if(user.registerUser()){
				next_page = "login.jsp";
			}else{
				err_msg = err_msg + "An Account With Same Email Is Already Exist";
				request.setAttribute("err_msg",err_msg);
			}
		}else{
			request.setAttribute("err_msg",err_msg);
		}
		request.getRequestDispatcher(next_page).forward(request,response);
	}
}