package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import models.*;

public class ConferenceRegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession();
		boolean flag = true;
		String confMsg = "";
		String nextPage = "admin_dashboard.jsp";

		//--------------------------getParameter()----------------------------------
	
		String confTitle = request.getParameter("conferences_and_workshops_title").trim();
		Date confDateOfUploading = null;
		Date confDateOfClosing = null;
		try{
			confDateOfUploading = Date.valueOf(request.getParameter("conferences_and_workshops_date_of_uploading"));
			confDateOfClosing = Date.valueOf(request.getParameter("conferences_and_workshops_date_of_conference_ws_closed"));
		}catch(IllegalArgumentException e){
			confMsg = confMsg + "Date Field Was Empty";
		}
		
		
		//--------------------------VALIDATION--------------------------------------

		if(confTitle.equals("")){
			flag = false;
			confMsg = confMsg + "Title Field Was Empty";
		}
		
		if(flag){
			Event event = new Event();
			event.setEventTitle(confTitle);
			event.setEventStartDate(confDateOfUploading);
			event.setEventEndDate(confDateOfClosing);
			event.setEventType(new EventType(1));
			
			if(event.saveEvent()){
				confMsg = confMsg + "SUCCESSFULLY SAVED DATA...";
				request.setAttribute("confMsg",confMsg);
			}else{
				confMsg = confMsg + " Unable To Process...Try Again";
				request.setAttribute("confMsg",confMsg);
			}
		}
		request.setAttribute("confMsg",confMsg);
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}