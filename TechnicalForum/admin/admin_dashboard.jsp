<!doctype html>
<html lang="en">

 <head>
  <link rel="stylesheet" type="text/css" href="../css/admin_dashboard.css" /> 
  <title>::Admin Dashboard::</title>
 </head>
 <body>
<% request.setAttribute("isadmin",1); %>
  <%@ include file="../header.jsp" %>
	
	<div id="topic_div"><a href="topic.do" id="topiclink">TOPICS</a></div>

  <%@ include file="../footer.jsp" %>  
 </body>
</html>
