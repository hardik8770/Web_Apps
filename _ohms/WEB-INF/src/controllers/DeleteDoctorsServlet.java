package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.ArrayList;
import com.google.gson.Gson;

import models.*;

public class DeleteDoctorsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		HttpSession session  = request.getSession();

		String recordId = request.getParameter("record_id");
		Integer userTypeId = Integer.parseInt(request.getParameter("user_type_id"));
		String docEmail = request.getParameter("email");
		String message = "";
		ArrayList<String> al = new ArrayList<String>();

		User user = new User();
		user.setUserType(new UserType(userTypeId));
		user.setEmail(docEmail);

		
		if(user.deleteRecord()){
			message = message + "RECORD DELETED SUCCESSFULLY!!!";
			al.add(message);
		}else{
			message = message + "Sorry,Either Record Doesn't Exists OR Something Went Wrong...Try Again Later!!!";
			al.add(message);
		}
		
		String json = null;		
		json = new Gson().toJson(al);		
		System.out.println(json);
		response.getWriter().write(json);
	}
}