package models;

import java.sql.*;

public class User{
	private Integer userId;
	private String name;
	private String email;
	private String password;
	private java.util.Date dob;
	private Nation nation;
	private String areaOfInterest;
	private String organization;
	private String currentProfile;
	private Integer questionCount;
	private Integer responseCount;
	private Status status;
	private UserType userType;

	public User(String name,String email,String password){
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User(String email, String password){
		this.email = email;
		this.password = password;
	}
	public User(Integer userId, String name){
		this.userId = userId;
		this.name = name;
	}

	public boolean isLoginSuccess(){
		boolean flag = false;
		Connection con = null;
		

		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			
			String query = "select user_id,name,dob,nation_id,status_id,user_type_id,area_of_interest,organization,current_profile,question_count,response_count from users where email=? and password=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1,email);
			ps.setString(2,password);

			ResultSet rs = ps.executeQuery();
			System.out.println("8");

			if(rs.next()){
				this.userId = rs.getInt(1);
				this.name = rs.getString(2);
				this.dob = rs.getDate(3);//yyyy-mm-dd
				this.nation = new Nation(rs.getInt(4));
				this.status = new Status(rs.getInt(5));
				this.userType = new UserType(rs.getInt(6));
				this.areaOfInterest = rs.getString(7);
				this.organization = rs.getString(8);
				this.currentProfile = rs.getString(9);
				this.questionCount = rs.getInt(10);
				this.responseCount = rs.getInt(11);

				System.out.println("9");
				flag = true;
				System.out.println("10");
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
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
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			
			String query = "insert into users (name,email,password) value (?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,password);

			int r = ps.executeUpdate();
			if(r==1){
				flag = true;
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
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

	public void setDob(java.util.Date dob){
		this.dob = dob;
	}
	public java.util.Date getDob(){
		return dob;
	} 

	public void setNation(Nation nation){
		this.nation = nation;
	}
	public Nation getNation(){
		return nation;
	}
	
	public void setAreaOfInterest(String areaOfInterest){
		this.areaOfInterest = areaOfInterest;
	}
	public String getAreaOfInterest(){
		return areaOfInterest;
	}
	
	public void setOrganization(String organization){
		this.organization = organization;
	}
	public String getOrganization(){
		return organization;
	}

	public void setCurrentProfile(String currentProfile){
		this.currentProfile = currentProfile;
	}
	public String getCurrentProfile(){
		return currentProfile;
	}

	public void setQuestionCount(Integer questionCount){
		this.questionCount = questionCount;
	}
	public Integer getQuestionCount(){
		return questionCount;
	}

	public void setResponseCount(Integer responseCount){
		this.responseCount = responseCount;
	}
	public Integer getResponseCount(){
		return responseCount;
	}

	public void setStatusId(Status status){
		this.status = status;
	}
	public Status getStatus(){
		return status;
	}

	public void setUserIype(UserType userType){
		this.userType = userType;
	}	

	public UserType getUserType(){
		return userType;
	}
}