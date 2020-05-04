package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
//import java.text.SimpleDateFormat;
//import java.text.ParseException;

import models.*;

public class DoctorRegisterServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "admin_dashboard.jsp";

		String message = "";

		//--------------------------------getting parameters-------------------------------------------

		String doctorFirstName = request.getParameter("doctor_first_name");
		String doctorLastName = request.getParameter("doctor_last_name");

		String doctorName = doctorFirstName +" "+ doctorLastName;

		String doctorEmail = request.getParameter("doctor_email");
		String doctorPassword = request.getParameter("doctor_password");
		Date doctorDob = Date.valueOf(request.getParameter("doctor_dob"));
		//Date doctorDob = null;

		/*try{
			doctorDob = new SimpleDateFormat("yyyy-MM-dd")
			.parse(request.getParameter("doctor_dob"));
		}catch(ParseException e){
			e.printStackTrace();	
		}*/

		String doctorGender = request.getParameter("doctor_gender");
		String doctorDepartment = request.getParameter("doctor_department");
		String doctorAddress1 = request.getParameter("doctor_address_1");
		String doctorAddress2 = request.getParameter("doctor_address_2");
		String doctorCity = request.getParameter("doctor_city");
		String doctorZip = request.getParameter("doctor_zip");
		String doctorNationality = request.getParameter("doctor_nationality");
		Integer doctorExperience = Integer.parseInt(request.getParameter("doctor_experience"));
		String doctorQualification = request.getParameter("doctor_qualification");
		String doctorSpecialist = request.getParameter("doctor_specialist");

		//------------------------------Validations------------------------------------

		User user = new User();
		user.setUserType(new UserType(2));
		user.setName(doctorName);
		user.setEmail(doctorEmail);
		user.setPassword(doctorPassword);
		user.setDob(doctorDob);
		user.setGender(doctorGender);
		user.setDepartment(doctorDepartment);
		user.setAddress(doctorAddress1);
		user.setAddress2(doctorAddress2);
		user.setCity(doctorCity);
		user.setZip(doctorZip);
		user.setNationality(doctorNationality);
		user.setExperience(doctorExperience);
		user.setQualification(doctorQualification);
		user.setSpecialist(doctorSpecialist);
		
		if(user.saveDoctor()){
			message = message + "Congrats!!! Doctor Registered Successfully...";
		}else{
			message = message + "Oops!Can't Register Doctor At This Moment, Try Again...";
		}

		request.setAttribute("message",message);

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}	