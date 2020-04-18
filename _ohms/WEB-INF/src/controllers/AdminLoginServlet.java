package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.regex.*;

import models.*;

public class AdminLoginServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        HttpSession session = request.getSession();
        String nextPage = "admin_login.jsp";
        boolean flag = true;

        String message = "";
        String adminEmail = request.getParameter("admin_email");
        String adminPassword = request.getParameter("admin_password");
        
        Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
		Matcher m = p.matcher(adminEmail.trim());

        System.out.println(adminEmail);
        System.out.println(adminPassword);

        if(adminEmail.trim().equals("")){
            flag = false;
            message = message + "Email field is empty <br />";
			request.setAttribute("message",message);
        }else if(!m.matches()){
            flag = false;
            message = message + "Incorrect pattern of email <br />";
			request.setAttribute("message",message);
        }else if(adminPassword.trim().equals("")){
            flag = false;
            message = message + "Password field is empty <br />";
			request.setAttribute("message",message);
        }else if(flag){
            User user = new User(adminEmail,adminPassword);
            if(user.isLoginSuccess()&&user.getUserType().getUserTypeId()==1){
                nextPage = "admin_dashboard.jsp";
                session.setAttribute("admin_user",user);
            }else{
                message = message + "Invalid Credentials!!! <br />";
                request.setAttribute("message",message);
            }
        }
		
        request.getRequestDispatcher(nextPage).forward(request,response);
    }
}             