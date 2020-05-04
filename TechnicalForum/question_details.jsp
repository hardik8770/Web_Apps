<%@ page import="models.Question" %>

<!doctype html>
<html lang="en">
 <head>
  
  <link rel="stylesheet" type="text/css" href="css/header.css" />	
  <link rel="stylesheet" type="text/css" href="css/question_details.css" />	
  <script src="js/question_details.js"></script>

  <title>::QUESTION DETAILS::</title>
 </head>
 <body>
  <div id="main_container">
	<%@ include file="headeruser.jsp" %>

	<% Question question = (Question)request.getAttribute("question_details"); %>
	
	<div id="aaa">
		<a href="index.jsp"><b><i>TOPIC&nbsp;</a>
		<small>&gt;&gt;</small>&nbsp;
		<a href="topic_question.do?topic_id=<%= request.getParameter("topic_id") %>&topic=<%= request.getParameter("topic") %>"><%= request.getParameter("topic") %></i></b></a>
	</div>

	<div id="question_box">
		
		<h3>Question Title:</h3>		
		<div id="question_title">
			<h2><%= question.getTitle() %></h2>
			
			<div id="post_details">
				<small id="user_name"><b>User : </b><%= question.getUser().getName() %></small>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<small id="post_dttm"><b>Post Date : </b><%= question.getPostDateTime() %></small>
				<div id="short_resp">
					<small><b>Like : </b><%= question.getLikeCount() %></small>&nbsp;&nbsp;
					<small><b>Dislike : </b><%= question.getDislikeCount() %></small>&nbsp;&nbsp;
					<small><b>Spam : </b><%= question.getSpamCount() %></small>
				</div>
			</div>
		</div>
		<br />
		<hr />
			<h3>Question Detail:</h3>
			<div id="question_description">
				<%= question.getPost() %>
			</div>
			<br />
		<hr />
		<br />
	</div>
	
	<div id="post_response_box">
		<h2>Reply:</h2>
		<!-- <form action="post_my_answer.do">-->
			<input type="hidden" id="question_id" value="<%= question.getQuestionId() %>" />
			<textarea id="reply_field"></textarea>
			<div id="btn_div_box"><input type="button" id="post_answer_button" value="Post Your Answer" /></div>
		<!--</form> -->
	</div>

	<%@ include file="footer.jsp" %>
	<!-- <script src="js/topic_questions.js"></script> -->
  </div>
 </body>
</html>
