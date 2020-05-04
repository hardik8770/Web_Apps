package models;

import java.sql.*;
import java.util.ArrayList;

public class User{

	//------------------------INSTANCE LEVEL VARIABLES-----------------------------------

	private Integer userId;
	private String name;
	private String fathersName;
	private String email;
	private String password;
	private Date dob;
	private String specialist;
	private Integer experience;
	private String nationality;
	private String gender;
	private String qualification;
	private String department;
	private String address;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private UserType userType;
		
	//-------------------------CONSTRUCTORS------------------------------------

	public User(Integer userId, String name, String email, Date dob, String specialist, Integer experience, String gender, String department){
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.specialist = specialist;
		this.experience = experience;
		this.gender = gender;
		this.department = department;
	}

	public User(String email,String password){
		this.email = email;
		this.password = password;
	}

	public User(String name,UserType userType){
		this.name = name;
		this.userType = userType;
	}
	public User(){
	
	}

	//------------------------JDBC-CONNECTIVITY--------------------------------

	public boolean isLoginSuccess(){
		System.out.println("1");
		boolean flag = false;
		Connection con = null;

		try{
			System.out.println("2");
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ohms?user=root&password=1234");

			String query = "select user_id,name,fathers_name,dob,speacilist,experience,nationality,gender,qualification,user_type_id from users where email=? and password=?";
			System.out.println("3");
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1,email);
			ps.setString(2,password);
			
			System.out.println(email);
			System.out.println(password);

			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			System.out.println("4");
			//System.out.println("ResultSet is : "+rs.next());
			//boolean flg = rs.next();
			//System.out.println("flg : "+flg);
			if(rs.next()){
				System.out.println("5");
				this.userId = rs.getInt(1);
				this.name = rs.getString(2);
				this.fathersName = rs.getString(3);
				this.dob = rs.getDate(4);
				this.specialist = rs.getString(5);
				this.experience = rs.getInt(6);
				this.nationality = rs.getString(7);
				this.gender = rs.getString(8);
				this.qualification = rs.getString(9);
				this.userType = new UserType(rs.getInt(10));
				System.out.println("6");
				flag=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				System.out.println("7");
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		System.out.println("flag of isLoginSuccess() = "+flag);
		return flag;
	}
	
	public boolean saveDoctor(){
		boolean flag = false;
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ohms?user=root&password=1234");

			String query = "insert into users (name,email,password,dob,speacilist,experience,"+
							"nationality,gender,qualification,user_type_id,address,address2,city,"+
							"state,zip,department) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,password);
			ps.setDate(4,dob);
			ps.setString(5,specialist);
			ps.setInt(6,experience);
			ps.setString(7,nationality);
			ps.setString(8,gender);
			ps.setString(9,qualification);
			ps.setInt(10,getUserType().getUserTypeId());
			ps.setString(11,address);
			ps.setString(12,address2);
			ps.setString(13,city);
			ps.setString(14,state);
			ps.setString(15,zip);
			ps.setString(16,department);

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

	public boolean registerUser(){
		boolean flag = false;
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ohms?user=root&password=1234");

			String query = "insert into users (name,email,password,gender,user_type_id) values(?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,password);
			ps.setString(4,gender);
			ps.setInt(5,getUserType().getUserTypeId());

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

	public ArrayList<User> collectAll(){
		ArrayList<User> user = new ArrayList<User>();
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ohms?user=root&password=1234");

			String query = "select user_id,name,email,dob,speacilist,experience,gender,department from users "+
						   "where user_type_id="+getUserType().getUserTypeId();

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8)));
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
		return user;
	}
	
	//------------------------DELETE RECORD JDBC-------------------------------

	public boolean deleteRecord(){
		boolean flag = false;
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ohms?user=root&password=1234");
			
			String query = "delete from users where email=? and user_type_id=?";
			
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1,email);
			ps.setInt(2,getUserType().getUserTypeId());

			int r1 = ps.executeUpdate();

			String autoResetQuery = "alter table users auto_increment=1";

			PreparedStatement ps2 = con.prepareStatement(autoResetQuery);

			int r2 = ps.executeUpdate();
			System.out.println(r1+"\t"+r2);
			
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
	//------------------------JDBC getting Doctor email -----------------------

	public String getDoctorEmail(){
		Connection con = null;
		String docEmail = null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ohms?user=root&password=1234");

			String query = "select email from users where user_type_id=2 and name='"+name+"'";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				docEmail = rs.getString(1);
			}
			System.out.println("@@@@@@@@@@@@@@@@@@@\t"+docEmail+"\t@@@@@@@@@@@@@@@@@@@@@@@");
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return docEmail;
	}

	//------------------------GETTER-SETTERS-----------------------------------

	public void setUserId(Integer userId){
		this.userId = userId;
	}
	public Integer getUserId(){
		return userId;
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	public void setFathersName(String fathersName){
		this.fathersName = fathersName;
	}
	public String getFathersName(){
		return fathersName;
	}

	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return email;
	}

	public void setPassword(String password){
		this.password = password;
	} 
	public String getPassword(){
		return password;
	}

	public void setDob(Date dob){
		this.dob = dob;
	}
	public Date getDate(){
		return dob;
	}

	public void setSpecialist(String specialist){
		this.specialist = specialist;
	}	
	public String getSpecialist(){
		return specialist;
	}

	public void setExperience(Integer experience){
		this.experience = experience;
	}
	public Integer getExperience(){
		return experience;
	}

	public void setNationality(String nationality){
		this.nationality = nationality;
	}
	public String getNationality(){
		return nationality;
	}

	public void setGender(String gender){
		this.gender = gender;
	}
	public String getGender(){
		return gender;
	}

	public void setQualification(String qualification){
		this.qualification = qualification;
	}
	public String getQualification(){
		return qualification;
	}

	public void setUserType(UserType userType){
		this.userType = userType;
	}
	public UserType getUserType(){
		return userType;
	}

	public void setDepartment(String department){
		this.department = department;
	}
	public String getDepartment(){
		return department;
	}

	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}

	public void setAddress2(String address2){
		this.address2 = address2;
	}
	public String getAddress2(){
		return address2;
	}

	public void setCity(String city){
		this.city = city;
	}
	public String getCity(){
		return city;
	}

	public void setState(String state){
		this.state = state;
	}
	public String getState(){
		return state;
	}

	public void setZip(String zip){
		this.zip = zip;
	}
	public String getZip(){
		return zip;
	}
}