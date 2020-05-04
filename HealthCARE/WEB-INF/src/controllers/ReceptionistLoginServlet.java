package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.regex.*;
import models.*;

public class ReceptionistLoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "receptionist_login.jsp";

		boolean flag = true;

        String message = "";
        String receptionistEmail = request.getParameter("recep_email");
        String receptionistPassword = request.getParameter("recep_password");
        
        Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
		Matcher m = p.matcher(receptionistEmail.trim());

        System.out.println(receptionistEmail);
        System.out.println(receptionistPassword);

        if(receptionistEmail.trim().equals("")){
            flag = false;
            message = message + "Email field is empty <br />";
			request.setAttribute("message",message);
        }else if(!m.matches()){
            flag = false;
            message = message + "Incorrect pattern of email <br />";
			request.setAttribute("message",message);
        }else if(receptionistPassword.trim().equals("")){
            flag = false;
            message = message + "Password field is empty <br />";
			request.setAttribute("message",message);
        }else if(flag){
            User user = new User(receptionistEmail,receptionistPassword);
            if(user.isLoginSuccess()&&user.getUserType().getUserTypeId()==3){
                nextPage = "receptionist_dashboard.jsp";
                session.setAttribute("receptionist_user",user);
                session.setAttribute("receptionist_session","receptionist");

            }else{
                message = message + "Invalid Credentials!!! <br />";
                request.setAttribute("message",message);
            }
        }

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}