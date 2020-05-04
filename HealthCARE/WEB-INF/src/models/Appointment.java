package models;

import java.sql.*;
import java.util.ArrayList;

public class Appointment{

	//------------------------INSTANCE LEVEL VARIABLES-----------------------------------

	private Integer appointmentId;
	private String name;
	private String gender;
	private String email;
	private String doctorEmail;
	private String contactNo;
	private Date dob;
	private String address;
	private String patientDoctor;
	private Date dateOfAppointment;
	private Time appointmentTime;
	
		
	//-------------------------CONSTRUCTORS------------------------------------

	public Appointment(){
	
	}

	public Appointment(String email){
		this.email = email;
	}

	public Appointment(String name, Date dob, String gender, String patientDoctor, String email){
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.patientDoctor = patientDoctor;
		this.email = email;
	}

	//------------------------JDBC-CONNECTIVITY--------------------------------

	
	public boolean saveAppointment(){
		boolean flag = false;
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ohms?user=root&password=1234");

			String query = "insert into appointments (patient_name,patient_doctor,gender,contact_no,address,email,doctor_email,dob,date_of_appointment,time) values(?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1,name);
			ps.setString(2,patientDoctor);
			ps.setString(3,gender);
			ps.setString(4,contactNo);
			ps.setString(5,address);
			ps.setString(6,email);
			ps.setString(7,doctorEmail);
			ps.setDate(8,dob);
			ps.setDate(9,dateOfAppointment);
			ps.setTime(10,appointmentTime);
			

			int r = ps.executeUpdate();
			
			if(r==1){
				flag = true;
			}

		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}

	//------------------------Collect-Records-JDBC-----------------------------

	public ArrayList<Appointment> collectPatients(){
		ArrayList<Appointment> patientRec = new ArrayList<Appointment>();
		Connection con = null;

		try{
		
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ohms?user=root&password=1234");

			String query = "select patient_name,dob,gender,patient_doctor,email from appointments";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				patientRec.add(new Appointment(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return patientRec;
	}
	

	public ArrayList<Appointment> collectDoctorPatients(){
		ArrayList<Appointment> patientRec = new ArrayList<Appointment>();
		Connection con = null;

		try{
		
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ohms?user=root&password=1234");

			String query = "select patient_name,dob,gender,patient_doctor,email from appointments where doctor_email='"+doctorEmail+"'";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				patientRec.add(new Appointment(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return patientRec;
	}
	
	//------------------------DELETE RECORD JDBC-------------------------------

	public boolean deleteRecord(){
		boolean flag = false;
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ohms?user=root&password=1234");

			String query = "delete from appointments where email=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1,getEmail());

			int r1 = ps.executeUpdate();

			String autoResetQuery = "alter table events auto_increment=1";

			PreparedStatement ps1 = con.prepareStatement(autoResetQuery);

			int r2 = ps1.executeUpdate();

			if(r1>0||r2>0){
				flag = true;
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return flag;
	}
	

	//------------------------GETTER-SETTERS-----------------------------------

	public void setAppointmentId(Integer appointmentId){
		this.appointmentId = appointmentId;
	}
	public Integer getAppointmentId(){
		return appointmentId;
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}

	public void setGender(String gender){
		this.gender = gender;
	}
	public String getGender(){
		return gender;
	}

	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return email;
	}

	public void setPatientDoctor(String patientDoctor){
		this.patientDoctor = patientDoctor;
	}
	public String getPatientDoctor(){
		return patientDoctor;
	}

	public void setContactNo(String contactNo){
		this.contactNo = contactNo;
	} 
	public String getContactNo(){
		return contactNo;
	}

	public void setDoctorEmail(String doctorEmail){
		this.doctorEmail = doctorEmail;
	} 
	public String getDoctorEmail(){
		return doctorEmail;
	}

	public void setDob(Date dob){
		this.dob = dob;
	}
	public Date getDate(){
		return dob;
	}

	public void setDateOfAppointment(Date dateOfAppointment){
		this.dateOfAppointment = dateOfAppointment;
	}
	public Date getDateOfAppointment(){
		return dateOfAppointment;
	}

	public void setAppointmentTime(Time appointmentTime){
		this.appointmentTime = appointmentTime;
	}
	public Time getAppointmentTime(){
		return appointmentTime;
	}

}