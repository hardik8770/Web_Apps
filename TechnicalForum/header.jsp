<%@ page import="models.User" %>

<link rel="stylesheet" type="text/css" href="../css/header.css" />
<link rel="stylesheet" type="text/css" href="css/header.css" />

<% User user = (User)session.getAttribute("user"); %>
<% Integer isadmin = (Integer)request.getAttribute("isadmin"); %>
<% Boolean isLoginPage = (Boolean)request.getAttribute("isloginpage"); %>
<% Boolean isRegisterPage = (Boolean)request.getAttribute("isregisterpage"); %>


<div id="header">
	<img src='<%= isadmin!=null?"../images/logo.png":"images/logo.png" %>' id="img"/>
	<span id="txt" align="top">Online Technical Discussion Forums</span>

	<div id="controllers" align="right">
		<% if(user==null){ %>
			
			<% if(isLoginPage==null){ %>
					<a href="show_login.do" class="cntrl">LOGIN</a>
			<% } %>

			<% if(isadmin==null&&isRegisterPage==null){ %>
					<a href="registration_form.do" class="cntrl">REGISTER</a>
			<% } %>

		<% }else{ %>
				<a href="logout.do" class="cntrl">LOGOUT</a>	
		<% } %>

		
	</div>
	
  
  </div>	