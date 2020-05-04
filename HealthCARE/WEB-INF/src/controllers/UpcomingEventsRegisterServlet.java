package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import models.*;

public class UpcomingEventsRegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession();
		boolean flag = true;
		String upcomingMsg = "";
		String nextPage = "admin_dashboard.jsp";

		//--------------------------getParameter()----------------------------------
	
		String upcomingTitle = request.getParameter("upcoming_events_title").trim();
		Date upcomingDateOfUploading = null;
		Date upcomingDateOfClosing = null;
		try{
			upcomingDateOfUploading = Date.valueOf(request.getParameter("upcoming_events_start_date"));
			upcomingDateOfClosing = Date.valueOf(request.getParameter("upcoming_events_close_date"));
		}catch(IllegalArgumentException e){
			upcomingMsg = upcomingMsg + "Date Field Was Empty";
		}
		
		
		//--------------------------VALIDATION--------------------------------------

		if(upcomingTitle.equals("")){
			flag = false;
			upcomingMsg = upcomingMsg + "Title Field Was Empty";
		}
		
		if(flag){
			Event event = new Event();
			event.setEventTitle(upcomingTitle);
			event.setEventStartDate(upcomingDateOfUploading);
			event.setEventEndDate(upcomingDateOfClosing);
			event.setEventType(new EventType(2));
			
			if(event.saveEvent()){
				upcomingMsg = upcomingMsg + "SUCCESSFULLY SAVED DATA...";
				request.setAttribute("upcomingMsg",upcomingMsg);
			}else{
				upcomingMsg = upcomingMsg + " Unable To Process...Try Again";
				request.setAttribute("upcomingMsg",upcomingMsg);
			}
		}
		request.setAttribute("upcomingMsg",upcomingMsg);
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}