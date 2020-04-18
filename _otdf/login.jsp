<!doctype html>
<html lang="en">
 <head>
  <link rel="stylesheet" text="text/css" href="css/header.css" />
  <link rel="stylesheet" type="text/css" href="css/admin_login.css" />

  <title>::User Login::</title>

 </head>
 <body>
  <div id="main_container">

	<%
		request.setAttribute("isloginpage",true);
	%>

	<%@ include file="headeruser.jsp" %>

	<% String errMsg = (String)request.getAttribute("err_msg"); %>

	<% if(errMsg!=null){ %>
			<div id="err"><%= errMsg %></div>
	<% } %>

	<form id="form" action="login.do">
	<table id="form_table" align="center">
		<caption id="caption">:: USER LOGIN ::</caption>
		<tr class="form_row">
			<td>Email</td>
			<td>:</td>
			<td><input class="ip" type="email" name="email" /></td>
		</tr>
		<br/>
		<tr class="form_row">
			<td>Password</td>
			<td>:</td>
			<td><input class="ip" type="password" name="password" /></td>
		</tr>
		<tr>
			<td><input id="btn" type="submit" name="login" value="LOGIN" id="login_btn"/></td>
		</tr>
	</table>
	
	</form>

	<%@ include file="footer.jsp" %>

  </div>
 </body>
</html>
