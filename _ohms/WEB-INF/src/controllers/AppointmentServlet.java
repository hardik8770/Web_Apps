package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import models.*;

public class AppointmentServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "receptionist_dashboard.jsp";

		String message = "";

		//--------------------------------getting parameters-------------------------------------------

		String patientFirstName = request.getParameter("patient_first_name");
		String patientLastName = request.getParameter("patient_last_name");

		String patientName = patientFirstName +" "+ patientLastName;

		String patientEmail = request.getParameter("patient_email");
		
		String patientDoctor = request.getParameter("patient_doctor");
		System.out.println("#####################"+patientDoctor);
		User user = new User(patientDoctor,new UserType(2));
		String doctorEmail = user.getDoctorEmail();

		String patientContact = request.getParameter("patient_contact");
		Date patientDob = Date.valueOf(request.getParameter("patient_dob"));
		//Date patientDob = null;

		/*try{
			patientDob = new SimpleDateFormat("yyyy-MM-dd")
			.parse(request.getParameter("patient_dob"));
		}catch(ParseException e){
			e.printStackTrace();	
		}*/

		String patientGender = request.getParameter("patient_gender");
		String patientAddress1 = request.getParameter("patient_address_1");
		Date patientDateOfAppointment = Date.valueOf(request.getParameter("patient_doa"));
		Time appointmentTime = Time.valueOf(request.getParameter("patient_doa_time"));

		//------------------------------Validations------------------------------------

		Appointment appointment = new Appointment();
		appointment.setName(patientName);
		appointment.setEmail(patientEmail);
		appointment.setDob(patientDob);
		appointment.setDoctorEmail(doctorEmail);
		appointment.setGender(patientGender);
		appointment.setAddress(patientAddress1);
		appointment.setPatientDoctor(patientDoctor);
		appointment.setContactNo(patientContact);
		appointment.setAppointmentTime(appointmentTime);
		appointment.setDateOfAppointment(patientDateOfAppointment);
		
		
		if(appointment.saveAppointment()){
			message = message + "Congrats!!! patient Registered Successfully...";
		}else{
			message = message + "Oops!Can't Register patient At This Moment, Try Again...";
		}

		request.setAttribute("message1",message);

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}	