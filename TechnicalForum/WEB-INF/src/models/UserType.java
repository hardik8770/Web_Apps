package models;

public class UserType{
	private Integer userTypeId;
	private String userType;

	public UserType(Integer userTypeId){
		this.userTypeId = userTypeId;
	}

	public void setUserTypeId(Integer userTypeId){
		this.userTypeId = userTypeId;
	}
	public Integer getUserTypeId(){
		return userTypeId;	
	}

	public void setUserType(String userType){
		this.userType = userType;
	}
	public String getUserType(){
		return userType;	
	}
}