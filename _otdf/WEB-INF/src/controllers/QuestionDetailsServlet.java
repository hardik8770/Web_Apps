package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.Question;

public class QuestionDetailsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession();
		
		String nextPage = "question_details.jsp";

		int questionId = Integer.parseInt(request.getParameter("question_id"));

		Question question = new Question();
		question.setQuestionId(questionId);
		question.getQuestionDetails();

		request.setAttribute("question_details",question);

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}