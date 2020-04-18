package models;

public class Nation{
	private Integer nationId;
	private String nation;

	public Nation(Integer nationId){
		this.nationId = nationId; 
	}

	public void setNationId(Integer nationId){
		this.nationId = nationId;
	}
	public Integer getNationId(){
		return nationId;
	}

	public void setNation(String nation){
		this.nation = nation;
	}
	public String getNation(){
		return nation;
	}
}