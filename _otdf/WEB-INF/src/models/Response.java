package models;

import java.sql.*;

public class Response extends Post{

	private Integer responseId;
	private Question question;
	//private Post post;

	public void saveResponse(){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query = "insert into response (question_id,post_id) values (?,?)";
			PreparedStatement p = con.prepareStatement(query);

			p.setInt(1,question.getQuestionId());
			p.setInt(2,getPostId());

			p.executeUpdate();

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

	public void setResponseId(Integer responseId){
		this.responseId = responseId;
	}
	public Integer getResponseId(){
		return responseId;
	}

	public void setQuestion(Question question){
		this.question = question;
	}
	public Question getQuestion(){
		return question;
	}

	/*public void setPost(Post post){
		this.post = post;
	}
	public Post getPost(){
		return post;
	}*/
}