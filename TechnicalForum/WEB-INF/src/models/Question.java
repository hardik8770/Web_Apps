package models;

import java.util.*;
import java.sql.*;

public class Question extends Post{

	private Integer questionId;
	private Topic topic;
	//private Post post;
	private String title;
	private Integer responseCount;
	private Integer viewCount;

	public Question(){
	
	}

	public Question(int questionId){
		this.questionId = questionId;
	}

	public void getQuestionDetails(){
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
		
			String query = "select p.post_id,post,post_date_time,like_count,dislike_count,spam_count,"+
							"post_type_id,p.status_id,title,q.response_count,view_count,topic_id,u.user_id,"+
							"u.name  from posts as p inner join questions as q inner join users as u "+
							"where p.post_id=q.post_id and p.user_id=u.user_id and q.question_id=?";

			PreparedStatement p = con.prepareStatement(query);
			p.setInt(1,questionId);

			ResultSet r = p.executeQuery();

			if(r.next()){
				setPostId(r.getInt(1));
				setPost(r.getString(2));
				setPostDateTime(r.getTimestamp(3));
				setLikeCount(r.getInt(4));
				setDislikeCount(r.getInt(5));
				setSpamCount(r.getInt(6));
				setPostType(new PostType(r.getInt(7)));
				setStatus(new Status(r.getInt(8)));
				title = r.getString(9);
				responseCount = r.getInt(10);
				viewCount = r.getInt(11);
				topic = new Topic(r.getInt(12));
				setUser(new User(r.getInt(13),r.getString(14)));
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
	}

	public Boolean saveQuestion(){
		savePost();
		
		boolean flag = false;
	
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");

			String query = "insert into questions (title,topic_id,post_id) value (?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);  

			ps.setString(1,title);
			ps.setInt(2,topic.getTopicId());
			ps.setInt(3,getPostId());

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

	public static ArrayList<Question> collectQuestion(Integer topicId){
		ArrayList<Question> questions = new ArrayList<Question>();
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");

			String query = "select question_id,title,q.response_count,view_count,post_date_time,p.user_id,name,p.status_id,status from questions as q inner join posts as p inner join users as u inner join status as s where topic_id=? and q.post_id=p.post_id and p.user_id=u.user_id and p.status_id=s.status_id";

			PreparedStatement p = con.prepareStatement(query);
			p.setInt(1,topicId);
			ResultSet r = p.executeQuery();
			while(r.next()){
				Question question = new Question();

				question.questionId = r.getInt(1);
				question.title = r.getString(2);
				question.responseCount = r.getInt(3);
				question.viewCount = r.getInt(4);

				//Post post = new Post();

				question.setPostDateTime(r.getTimestamp(5));
				question.setUser(new User(r.getInt(6),r.getString(7)));
				question.setStatus(new Status(r.getInt(8),r.getString(9)));

				//question.post = post;
				questions.add(question);
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
		return questions;
	}

	public void setQuestionId(Integer questionId){
		this.questionId = questionId;
	}
	public Integer getQuestionId(){
		return questionId;
	}

	public void setTopic(Topic topic){
		this.topic = topic;
	}
	public Topic getTopic(){
		return topic;
	}

	/*public void setPost(Post post){
		this.post = post;
	}
	public Post getPost(){
		return post;
	}*/

	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return title;
	}

	public void setResponseCount(Integer responseCount){
		this.responseCount = responseCount;
	}
	public Integer getResponseCount(){
		return responseCount;
	}

	public void setViewCount(Integer viewCount){
		this.viewCount = viewCount;
	}
	public Integer getViewCount(){
		return viewCount;
	}
}