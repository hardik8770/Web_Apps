package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.ArrayList;
import com.google.gson.Gson;
import models.*;

public class CollectDoctorsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		Integer userTypeId = Integer.parseInt(request.getParameter("user_type_id"));
		System.out.println(userTypeId);
		
		User user = new User();
		user.setUserType(new UserType(userTypeId));

		ArrayList<User> collectDoctors = user.collectAll();
		System.out.println(collectDoctors);
		String json = null;
		
		json = new Gson().toJson(collectDoctors);		
		System.out.println(json);
		response.getWriter().write(json);
	}
}