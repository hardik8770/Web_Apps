package models;

import java.sql.*;
import java.util.*;

public class Topic{
	private Integer topicId;
	private String topic;
	private Integer questionCount;
	private Integer openQuestions;
	private Timestamp lastUpdate;
	private Status status;

	public Topic(){
	
	}

	public Topic(Integer topicId){
		this.topicId = topicId;
	}

	public Topic(String topic){
		this.topic = topic;
	}

	public Topic(Integer topicId, String topic){
		this.topicId = topicId;
		this.topic = topic;
	}
	
	public Topic(Integer topicId, String topic, Integer questionCount, Integer openQuestions, Timestamp lastUpdate){
		this.topicId = topicId;
		this.topic = topic;
		this.questionCount = questionCount;
		this.openQuestions = openQuestions;
		this.lastUpdate = lastUpdate;
	}

	public ArrayList<Topic> ajaxCollectTopics(){
		ArrayList<Topic> topics = new ArrayList<Topic>();
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");

			String query = "select topic_id,topic from topics where topic='"+topic+"'";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				topics.add(new Topic(rs.getInt(1),rs.getString(2)));
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
		return topics;
	}


	public static ArrayList<Topic> collectTopics(){
		ArrayList<Topic> topics = new ArrayList<Topic>();
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");

			String query = "select topic_id,topic from topics ORDER BY topic_id ASC";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				topics.add(new Topic(rs.getInt(1),rs.getString(2)));
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
		return topics;
	}

	public static ArrayList<Topic> collectTopics1(){
		ArrayList<Topic> topics = new ArrayList<Topic>();
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");

			String query = "select topic_id,topic,question_count,open_questions,last_update from topics";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				topics.add(new Topic(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getTimestamp(5)));
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
		return topics;
	}

	public void addTopicDb(){
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");

			String query = "insert into topics (topic) value (?)";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,topic);

			int r = ps.executeUpdate();
			
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
	}

	public void setTopicId(Integer topicId){
		this.topicId = topicId;
	}
	public Integer getTopicId(){
		return topicId;
	}

	public void setTopic(String topic){
		this.topic = topic;
	}
	public String getTopic(){
		return topic;
	}

	public void setQuestionCount(Integer questionCount){
		this.questionCount = questionCount;
	}
	public Integer getQuestionCount(){
		return questionCount;
	}

	public void setOpenQuestions(Integer openQuestions){
		this.openQuestions = openQuestions;
	}
	public Integer getOpenQuestions(){
		return openQuestions;
	}

	public void setLastUpdate(Timestamp lastUpdate){
		this.lastUpdate = lastUpdate;
	}
	public Timestamp getLastUpdate(){
		return lastUpdate;
	}
	public void setStatus(Status status){
		this.status = status;
	}
	public Status getStatus(){
		return status;
	}

}