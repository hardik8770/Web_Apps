package models;

public class UserType{
	
	//------------------------INSTANCE LEVEL VARIABLES ------------------------
	
	private Integer userTypeId;
	private String user;

	//------------------------INSTANCE LEVEL VARIABLES ------------------------

	public UserType(Integer userTypeId){
		this.userTypeId = userTypeId;
	}

	//------------------------GETTER-SETTERS-----------------------------------

	public void setUserTypeId(Integer userTypeId){
		this.userTypeId = userTypeId;
	}
	
	public Integer getUserTypeId(){
		return userTypeId;
	}

	public void setUser(String user){
		this.user = user;
	}
	
	public String getUser(){
		return user;
	}
}