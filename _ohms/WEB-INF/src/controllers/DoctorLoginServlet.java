package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.regex.*;
import models.*;

public class DoctorLoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "doctor_login.jsp";

		boolean flag = true;

        String message = "";
        String doctorEmail = request.getParameter("doctor_email");
        String doctorPassword = request.getParameter("doctor_password");
        
        Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
		Matcher m = p.matcher(doctorEmail.trim());

        System.out.println(doctorEmail);
        System.out.println(doctorPassword);

        if(doctorEmail.trim().equals("")){
            flag = false;
            message = message + "Email field is empty <br />";
			request.setAttribute("message",message);
        }else if(!m.matches()){
            flag = false;
            message = message + "Incorrect pattern of email <br />";
			request.setAttribute("message",message);
        }else if(doctorPassword.trim().equals("")){
            flag = false;
            message = message + "Password field is empty <br />";
			request.setAttribute("message",message);
        }else if(flag){
            User user = new User(doctorEmail,doctorPassword);
            if(user.isLoginSuccess()&&user.getUserType().getUserTypeId()==2){
                nextPage = "doctor_dashboard.jsp";
                session.setAttribute("doctor_user",user);
                session.setAttribute("doctor_session","doctor");

            }else{
                message = message + "Invalid Credentials!!! <br />";
                request.setAttribute("message",message);
            }
        }

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}