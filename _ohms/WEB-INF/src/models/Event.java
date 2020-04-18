package models;

import java.sql.*;
import java.util.ArrayList;

public class Event{
	
	//--------------------Instance Level Variables------------------------------------

	private Integer eventId;
	private String eventTitle;
	private Date eventStartDate;
	private Date eventEndDate;
	private EventType eventType;

	//--------------------Constructors-------------------------------------------------

	public Event(){
	
	}

	public Event(EventType eventType, String eventTitle){
		this.eventType = eventType;
		this.eventTitle = eventTitle;
	}

	public Event(String eventTitle, Date eventEndDate, Date eventStartDate){
		this.eventTitle = eventTitle;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
	}
	
	//--------------------JDBC-CONNECTIVITY--------------------------------------------

	public boolean saveEvent(){
		boolean flag = false;
		Connection con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ohms?user=root&password=1234");

			String query = "insert into events (event_title, date_of_closing,date_of_opening,event_type_id) values (?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			System.out.println(eventTitle);
			System.out.println(eventEndDate);
			System.out.println(eventStartDate);
			System.out.println(getEventType().getEventTypeId());

			ps.setString(1,eventTitle);
			ps.setDate(2,eventEndDate);
			ps.setDate(3,eventStartDate);
			ps.setInt(4,getEventType().getEventTypeId());
			
			int r = ps.executeUpdate();
			if(r==1){
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

	//--------------------COLLECT EVENT METHOD JDBC CONNECTIVITY-----------------------

	public ArrayList<Event> collectEvents(){
		ArrayList<Event> events = new ArrayList<Event>();
		Connection con = null;

		try{
		
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ohms?user=root&password=1234");

			String query = "select event_title,date_of_closing,date_of_opening from events where event_type_id=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1,getEventType().getEventTypeId());

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				events.add(new Event(rs.getString(1),rs.getDate(2),rs.getDate(3)));
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

		return events;
	}
	//--------------------DELETE EVENT JDBC CONNECTION---------------------------------

	public boolean deleteEventRecord(){
		boolean flag = false;
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ohms?user=root&password=1234");

			String query = "delete from events where event_type_id=? and event_title=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1,getEventType().getEventTypeId());
			ps.setString(2,getEventTitle());

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

	//--------------------Getter Setters-----------------------------------------------

	public void setEventId(Integer eventId){
		this.eventId = eventId;
	}

	public Integer getEventId(){
		return eventId;	
	}

	public void setEventTitle(String eventTitle){
		this.eventTitle = eventTitle;	
	}

	public String getEventTitle(){
		return eventTitle;
	}
	
	public void setEventStartDate(Date eventStartDate){
		this.eventStartDate = eventStartDate;
	}

	public Date getEventStartDate(){
		return eventStartDate;
	}

	public void setEventEndDate(Date eventEndDate){
		this.eventEndDate = eventEndDate;
	}

	public Date getEventEndDate(){
		return eventEndDate;
	}

	public void setEventType(EventType eventType){
		this.eventType = eventType;
	}

	public EventType getEventType(){
		return eventType;
	}
}