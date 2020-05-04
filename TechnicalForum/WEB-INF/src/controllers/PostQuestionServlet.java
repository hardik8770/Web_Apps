package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;

public class PostQuestionServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String next_page = "login.jsp";	

		User user1 = (User)session.getAttribute("user1");
		
		if(user1!=null){
			String questionTitle = request.getParameter("qtitle");
			String question_str = request.getParameter("question");
			Integer topicId = Integer.parseInt(request.getParameter("topic_id"));
			
			Question question = new Question();
			question.setUser(user1);
			question.setPostType(PostType.QUESTION);
			question.setPost(question_str);
			question.setTitle(questionTitle);
			question.setTopic(new Topic(topicId));

			if(question.saveQuestion()){
				next_page = "topic_question.do";
			}else{
				next_page = "question_form.jsp";
			}
		}

		request.getRequestDispatcher(next_page).forward(request,response);
	}	
}