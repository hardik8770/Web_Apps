<!doctype html>
<html lang="en">
 <head>
  <link rel="stylesheet" text="text/css" href="css/header.css" />
  <link rel="stylesheet" type="text/css" href="css/admin_login.css" />

  <title>::Registration Page::</title>

 </head>
 <body>
  <div id="main_container">

	<%
		request.setAttribute("isregisterpage",true);
	%>

	<%@ include file="headeruser.jsp" %>

	<% String errMsg = (String)request.getAttribute("err_msg"); %>

	<% if(errMsg!=null){ %>
			<div id="err"><%= errMsg %></div>
	<% } %>

	<form id="form" action="register.do">
	<table id="form_table" align="center">
		<caption id="caption">:: GENERAL USER REGISTRATION ::</caption>
		
		<tr class="form_row">
			<td>User Name</td>
			<td>:</td>
			<td><input class="ip" type="text" name="user_name"  /></td>
		</tr>
		<br/>
		<tr class="form_row">
			<td>Email</td>
			<td>:</td>
			<td><input class="ip" type="email" name="email"  /></td>
		</tr>
		<br/>
		<tr class="form_row">
			<td>Password</td>
			<td>:</td>
			<td><input class="ip" type="password" name="password" /></td>
		</tr>
		<br/>
		<tr class="form_row">
			<td>Re-type Password</td>
			<td>:</td>
			<td><input class="ip" type="password" name="repassword" /></td>
		</tr>
		<tr>
			<td colspan="3"><input id="btn" type="submit" value="SignUp" id="login_btn"/></td>
		</tr>
	</table>
	
	</form>
	<%@ include file="footer.jsp" %>
  </div>
 </body>
</html>
