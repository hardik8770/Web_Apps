package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;
import com.google.gson.Gson;

import models.*;

public class CollectEventServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		Integer eventTypeId = Integer.parseInt(request.getParameter("event_type_id"));
		
		Event event = new Event();
		event.setEventType(new EventType(eventTypeId));

		ArrayList<Event> eventsRecords = event.collectEvents();
		System.out.println(eventsRecords);

		String json = null;

		json = new Gson().toJson(eventsRecords);
		response.getWriter().write(json);
	}
}