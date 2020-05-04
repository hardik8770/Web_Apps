package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.ArrayList;
import com.google.gson.Gson;

import models.*;

public class DeleteEventServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		Integer eventTypeId = Integer.parseInt(request.getParameter("event_type_id"),0,1,10);
		String eventTitle = request.getParameter("event_type_id").substring(1);

		ArrayList<String> message = new ArrayList<String>();

		Event event = new Event(new EventType(eventTypeId),eventTitle);
	
		if(event.deleteEventRecord()){
			message.add("EVENT DELETED SUCCESSFULLY !!!");
		}else{
			message.add("OOPS!!!SOMETHING WENT WRONG...TRY AGAIN LATER");
		}
		System.out.println("Event Title : "+eventTitle+"\t EventTypeId : "+eventTypeId);
		String json = null;		
		json = new Gson().toJson(message);		
		System.out.println(json);
		response.getWriter().write(json);
	}
}