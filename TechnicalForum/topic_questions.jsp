<%@ page import="java.util.ArrayList,models.Question" %>

<!doctype html>
<html lang="en">
 <head>
  <link rel="stylesheet" type="text/css" href="css/header.css" />	
  <link rel="stylesheet" type="text/css" href="css/report.css" />	
  <link rel="stylesheet" type="text/css" href="css/topic_questions.css" />	

  <title>::TOPIC QUESTIONS::</title>
 </head>
 <body>
  <div id="main_container">
	<%@ include file="headeruser.jsp" %>

	<% ArrayList<Question> questions = (ArrayList)request.getAttribute("questions"); %>

	<div id="tp_title">
		:: <%= request.getParameter("topic") %> ::
		<input type="button" value="Post New Question" id="button" />	
		<input type="hidden" id="tp_id" value="<%= request.getParameter("topic_id") %>" />
		<input type="hidden" id="tp_nm" value="<%= request.getParameter("topic") %>" />
	</div>

	<table id="topic_box">
		<caption>Questions</caption>
		<thead>
			<tr>
				<th>Sr.</th>
				<th>Question Title</th>
				<th>User</th>
				<th>Date / Time</th>
				<th>View Count / Response Count</th>
			</tr>
		</thead>
		<% if(questions.size()==0){ %>
			<tr>
				<td colspan="5" id="no_rec" color="#990099">No Matching Records Found....</td>
			</tr>
		<% } %>
		<tbody>
			<% for(Question question : questions){ %>
					<tr>
						<td><%= question.getQuestionId() %></td>
						<td><a href="question_details.do?question_id=<%= question.getQuestionId() %>&topic=<%= request.getParameter("topic") %>&topic_id=<%= request.getParameter("topic_id") %>"><%= question.getTitle() %></a></td>
						<td><a href="user_profile.do?user_id=<%= question.getUser().getUserId() %>"><%= 
						question.getUser().getName()%></a></td>
						<td><%= question.getPostDateTime() %></td>
						<td><%= question.getResponseCount()+" / "+question.getViewCount() %></td>
					</tr>
			<% } %>
		</tbody>
	</table>

	<%@ include file="footer.jsp" %>
	<script src="js/topic_questions.js"></script>
  </div>
 </body>
</html>
