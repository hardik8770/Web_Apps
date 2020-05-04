package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.ArrayList;
import com.google.gson.Gson;
import models.*;

public class TopicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		ServletContext application = getServletConfig().getServletContext();
		
		String next_page = "admin_topics.jsp";

		ArrayList<Topic> collectTopics = Topic.collectTopics();

		application.setAttribute("collectTopics",collectTopics);
		
		request.getRequestDispatcher(next_page).forward(request,response);
		
		/*
		String json = null;
		
		json = new Gson().toJson(collectTopics);		

		response.getWriter().write(json);	*/
	}
}