package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;

public class PostResponseServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		//String nextPage = "show_login.do";

		User user = (User)session.getAttribute("user1");

		if(user!=null){
			int questionId = Integer.parseInt(request.getParameter("question_id"));
			String resp_ = request.getParameter("response");

			Response resp = new Response();
			resp.setUser(user);
			resp.setPostType(PostType.REPLY);
			resp.setPost(resp_);

			if(resp.savePost()){
				resp.setQuestion(new Question(questionId));
				resp.saveResponse();
			}
		}
	}
}