package models;

public class EventType{

	//------------------------------Instance Level Variables----------------------

	private Integer eventTypeId;
	private String eventType;

	//------------------------------Constructors----------------------------------
	
	public EventType(){
		
	}

	public EventType(Integer eventTypeId){
		this.eventTypeId = eventTypeId;
	}

	//------------------------------Getter-Setters--------------------------------

	public void setEventTypeId(Integer eventTypeId){
		this.eventTypeId = eventTypeId;
	}
	
	public Integer getEventTypeId(){
		return eventTypeId;
	}

	public void setEventType(String eventType){
		this.eventType = eventType;
	}

	public String getEventType(){
		return eventType;
	}

	//----------------------------------------------------------------------------
}