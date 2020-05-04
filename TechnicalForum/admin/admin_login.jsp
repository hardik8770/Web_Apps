<% String err_msg = (String)request.getAttribute("err_msg"); %>
<div id="err">
	<%if(err_msg!=null){%>
		<link rel="stylesheet" type="text/css" href="../css/admin_login.css" />
		<span><%= err_msg %></span>
	<%}%>
</div>
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