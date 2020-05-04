package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.ArrayList;
import com.google.gson.Gson;

import models.*;

public class DeletePatientServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		System.out.println("@@@@@@@@@@@@"+email);
		ArrayList<String> message = new ArrayList<String>();

		Appointment deletePatient = new Appointment(email);
	
		if(deletePatient.deleteRecord()){
			message.add("DELETED SUCCESSFULLY !!!");
		}else{
			message.add("OOPS!!!SOMETHING WENT WRONG...TRY AGAIN LATER");
		}
		String json = null;		
		json = new Gson().toJson(message);		
		System.out.println(json);
		response.getWriter().write(json);
	}
}