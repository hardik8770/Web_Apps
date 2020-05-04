package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
//import java.text.SimpleDateFormat;
//import java.text.ParseException;

import models.*;

public class ReceptionistRegisterServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "admin_dashboard.jsp";

		String message = "";

		//--------------------------------getting parameters-------------------------------------------

		String receptionistFirstName = request.getParameter("receptionist_first_name");
		String receptionistLastName = request.getParameter("receptionist_last_name");

		String receptionistName = receptionistFirstName +" "+ receptionistLastName;

		String receptionistEmail = request.getParameter("receptionist_email");
		String receptionistPassword = request.getParameter("receptionist_password");
		Date receptionistDob = Date.valueOf(request.getParameter("receptionist_dob"));
		//Date receptionistDob = null;

		/*try{
			receptionistDob = new SimpleDateFormat("yyyy-MM-dd")
			.parse(request.getParameter("receptionist_dob"));
		}catch(ParseException e){
			e.printStackTrace();	
		}*/

		String receptionistGender = request.getParameter("receptionist_gender");
		String receptionistAddress1 = request.getParameter("receptionist_address_1");
		String receptionistAddress2 = request.getParameter("receptionist_address_2");
		String receptionistCity = request.getParameter("receptionist_city");
		String receptionistZip = request.getParameter("receptionist_zip");
		String receptionistNationality = request.getParameter("receptionist_nationality");
		Integer receptionistExperience = Integer.parseInt(request.getParameter("receptionist_experience"));
		String receptionistQualification = request.getParameter("receptionist_qualification");

		//------------------------------Validations------------------------------------

		User user = new User();
		user.setUserType(new UserType(3));
		user.setName(receptionistName);
		user.setEmail(receptionistEmail);
		user.setPassword(receptionistPassword);
		user.setDob(receptionistDob);
		user.setGender(receptionistGender);
		user.setAddress(receptionistAddress1);
		user.setAddress2(receptionistAddress2);
		user.setCity(receptionistCity);
		user.setZip(receptionistZip);
		user.setNationality(receptionistNationality);
		user.setExperience(receptionistExperience);
		user.setQualification(receptionistQualification);
		
		if(user.saveDoctor()){
			message = message + "Congrats!!! Receptionist Registered Successfully...";
		}else{
			message = message + "Oops!Can't Register Receptionist At This Moment, Try Again...";
		}

		request.setAttribute("message1",message);

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}	