package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.ArrayList;
import com.google.gson.Gson;
import models.*;

public class AjaxTopicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		String topicName = request.getParameter("tpname");
		System.out.println(topicName);
		Topic topic = new Topic(topicName);
		
		ArrayList<Topic> collectTopic = topic.ajaxCollectTopics();
		
		String json = null;
		
		json = new Gson().toJson(collectTopic);		

		response.getWriter().write(json);
	}
}