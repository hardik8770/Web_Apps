<!doctype html>
<html lang="en">
 <head>
	<link rel="stylesheet" type="text/css" href="css/header.css" />
	<link rel="stylesheet" type="text/css" href="css/report.css" />
	<link rel="stylesheet" type="text/css" href="css/question_form.css" />
  
  <title>:: Question Form ::</title>
 </head>

 <body>
	<div id="main_container">
		<%@ include file="headeruser.jsp" %>
		
		<div id="tp_title">
			:: <%= request.getParameter("topic") %> ::
		</div>

		<form action="post_question.do">
			<table id="qtable">
				<tr>
					<td class="lft_cell">Question Title: </td>
					<td class="rht_cell"><input type="text" name="qtitle" class="fld" id="qt_fld"/></td>
				</tr>

				<tr>
					<td class="lft_cell">Question: </td>
					<td class="rht_cell"><textarea name="question" rows="10" cols="50" class="fld"></textarea></td>
				</tr>

				<tr>
					<td colspan="2" align="center">
						<input type="hidden" name="topic_id" value="<%= request.getParameter("topic_id") %>" />
						<input type="hidden" name="topic" value="<%= request.getParameter("topic") %>" />
						<input type="submit" value="Submit" id="qbtn"/>
					</td>
				</tr>

			</table>
		</form>

		<%@ include file="footer.jsp" %>
	</div>

	
 </body>
</html>
