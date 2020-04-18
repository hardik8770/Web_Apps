package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.sql.Date;
import java.util.ArrayList;
import models.*;

public class AddUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		String nextPage = "user_login.jsp";
		Boolean flag = true;
		String message = "";

		//--------------------------------getting parameters-------------------------------------------

		String userFirstName = (request.getParameter("user_first_name")).trim();
		String userLastName = (request.getParameter("user_last_name")).trim();

		String userName = userFirstName +" "+ userLastName;

		String userEmail = (request.getParameter("user_email")).trim();
		String userPassword = (request.getParameter("user_password")).trim();
		String userConfirmPassword = (request.getParameter("user_confirm_password")).trim();
		String userGender = (request.getParameter("user_gender")).trim();

		

		//--------------------------------models verification------------------------------------------

		User user = new User();
		user.setUserType(new UserType(4));
		user.setName(userName);
		user.setEmail(userEmail);
		user.setPassword(userPassword);
		user.setPassword(userConfirmPassword);
		user.setGender(userGender);
		
		if(userName.equals(" ")){
			message = message + "Name is empty";
			flag = false;
		}else if(userEmail.equals("")){
			message = message + "Email is empty";
			flag = false;
		}else if(!(userPassword.equals(userConfirmPassword))){
			flag = false;
			message = "password and confirm password didn't match";
		}else if(userGender.equals("")){
			flag = false;
			message = message +"Please Select Gender...";
		}else{
			boolean regFlag = user.registerUser();

			if(regFlag==true && flag==true){
				message = "You have Registered Yourself Successfully";
			}else{
				message = "Oops! Something Went Wrong...Try Again Later";
			}
		}
		
		//---------------------------------------------------------------------------------------------

		request.setAttribute("u_msg",message);
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}