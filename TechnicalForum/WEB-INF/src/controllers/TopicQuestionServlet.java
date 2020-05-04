package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;

public class TopicQuestionServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		String next_page = "topic_questions.jsp";

		int topicId = Integer.parseInt(request.getParameter("topic_id"));
		ArrayList<Question> questions = Question.collectQuestion(topicId);

		request.setAttribute("questions",questions);

		request.getRequestDispatcher(next_page).forward(request,response);
	}
}