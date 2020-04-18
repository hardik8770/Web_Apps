package models;

public class ActionType{

	private Integer actionTypeId;
	private String actionType;

	public void setActionTypeId(Integer actionTypeId){
		this.actionTypeId = actionTypeId;
	}
	public Integer getActionTypeId(){
		return actionTypeId;
	}

	public void setActionType(String actionType){
		this.actionType = actionType;
	}
	public String getActionType(){
		return actionType;
	}
}