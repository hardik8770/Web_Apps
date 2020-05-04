<!doctype html>
<html lang="en">
 <head>
	<link rel="stylesheet" type="text/css" href="../css/header.css" />
	<link rel="stylesheet" type="text/css" href="../css/admin_login.css" />

	<title>::Admin::</title>
 </head> 
 <body>
	<div id="main_container">
	
		<%
			request.setAttribute("isadmin",1);
			request.setAttribute("isloginpage",true);
		%>
		
		<%@ include file="../header.jsp" %>
	
		<% String err_msg = (String)request.getAttribute("err_msg"); %>
		
			<%if(err_msg!=null){%>
					<div id="err"><%= err_msg %></div>
			<% } %>
		<form id="form" action="login.do">
			<table id="form_table" align="center">
				<caption id="caption">::ADMIN LOGIN::</caption>
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
		<%@ include file="../footer.jsp" %>  
	</div>

 </body>
</html>
