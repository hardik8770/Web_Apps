<!doctype html>
<%@ page import="java.util.ArrayList,models.*" %>
<link rel="stylesheet" type="text/css" href="../css/admin_topics.css" />
<html lang="en">
 <head>
 
  <title>::TOPICS::</title>
 </head>
 <body>
	<% String err_msg = (String)request.getAttribute("err_msg"); %>

	
		<% if(err_msg!=null){ %>
			<div id="err_box">
				<span><%= err_msg %></span>
			</div>
		<% } %>
	
	<% request.setAttribute("isadmin",1); %>
	<%@ include file="../header.jsp" %>

	<% ArrayList<Topic> topics = (ArrayList<Topic>)application.getAttribute("collectTopics"); %>
	<div id="topic_div">
		<table id="topic_table">
			<caption>::TOPIC-LIST::</caption>
			<tr>
				<th>Sr.</th>
				<th>TOPICS</th>
			</tr>
			
			<%for(Topic topic : topics){%>
				<tr>
					<td><%=topic.getTopicId() %></td>
					<td class="td"><%=topic.getTopic() %></td>
				</tr>
			<%}%>
		</table>
	</div>
	
	<!-- _________________________________ADD NEW TOPIC____________________________________________________ -->
	
	<div id="add_topic_div">
		<table id="add_new_topic">
			<caption>::ADD NEW TOPIC::</caption>
			<!--<form id="add_new_topic_form" action="adddb.do">-->
				<tr>
					<td><input type="text" name="new_topic" placeholder="Enter New Topic Here" id="topicname" /></td>
				</tr>
				<tr>
					<td><input type="button" id="btn1" value="ADD TOPIC" /></td>
				</tr>
			<!--</form>-->
		</table>
	</div>
	<script src="../js/add_new_topic.js"></script>
	<%@ include file="../footer.jsp" %>
	
 </body>
</html>
