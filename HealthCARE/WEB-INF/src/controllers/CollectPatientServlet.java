package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;
import com.google.gson.Gson;

import models.*;

public class CollectPatientServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		Appointment patient = new Appointment();
		
		ArrayList<Appointment> patientRecords = patient.collectPatients();
		System.out.println(patientRecords);

		String json = null;

		json = new Gson().toJson(patientRecords);
		response.getWriter().write(json);
	}
}