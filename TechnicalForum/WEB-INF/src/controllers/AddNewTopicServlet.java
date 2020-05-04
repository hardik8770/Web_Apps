package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;

public class AddNewTopicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String topic = request.getParameter("tpname");
		String err_msg = "";


		//validation:
		
		if(!topic.equals("")){
			Topic tp = new Topic(topic);
			tp.addTopicDb();
		}else{
			err_msg = err_msg + "Empty field cannot be added to the database!!! <br /> ";
			request.setAttribute("err_msg",err_msg);
		}

		request.getRequestDispatcher("admin_topics.jsp").forward(request,response);
	}
}