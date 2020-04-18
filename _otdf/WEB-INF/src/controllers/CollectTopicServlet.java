package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;
import com.google.gson.Gson;

public class CollectTopicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		ArrayList<Topic> collectTopics = Topic.collectTopics1();

		String json = null;
		
		json = new Gson().toJson(collectTopics);		

		response.getWriter().write(json);	
	}
}
