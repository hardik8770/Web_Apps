package models;

public class Action{
	private Integer actionId;
	private Post post;
	private User user;
	private ActionType actionType;

	public void setActionId(Integer actionId){
		this.actionId = actionId;
	}
	public Integer getActionId(){
		return actionId;
	}

	public void setPostId(Post post){
		this.post = post;
	}
	public Post getPost(){
		return post;
	}

	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}

	public void setActionType(ActionType actionType){
		this.actionType = actionType;
	}
	public ActionType getActionType(){
		return actionType;
	}

}