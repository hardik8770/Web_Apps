package models;

import java.sql.*;

public class Post{
	private Integer postId;
	private User user;
	private PostType postType;
	private String post;
	private Timestamp postDateTime;
	private Integer likeCount;
	private Integer dislikeCount;
	private Integer spamCount;
	private Status status;


	public Boolean savePost(){
		boolean flag = false;

		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");

			String query = "insert into posts (post,user_id,post_type_id) value (?,?,?)";

			PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);  

			ps.setString(1,post);
			ps.setInt(2,user.getUserId());
			ps.setInt(3,postType.getPostTypeId());

			int r = ps.executeUpdate();
			if(r==1){
				flag = true;

				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()){
					postId = rs.getInt(1);
				}
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

	public void setPostId(Integer postId){
		this.postId = postId;
	}
	public Integer getPostId(){
		return postId;
	}

	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}

	public void setPostType(PostType postType){
		this.postType = postType;
	}
	public PostType getPostType(){
		return postType;
	}

	public void setPost(String post){
		this.post = post;
	}
	public String getPost(){
		return post;
	}

	public void setPostDateTime(Timestamp postDateTime){
		this.postDateTime = postDateTime;
	}
	public Timestamp getPostDateTime(){
		return postDateTime;
	}

	public void setLikeCount(Integer likeCount){
		this.likeCount = likeCount;
	}
	public Integer getLikeCount(){
		return likeCount;
	}

	public void setDislikeCount(Integer dislikeCount){
		this.dislikeCount = dislikeCount;
	}
	public Integer getDislikeCount(){
		return dislikeCount;
	}

	public void setSpamCount(Integer spamCount){
		this.spamCount = spamCount;
	}
	public Integer getSpamCount(){
		return spamCount;
	}

	public void setStatus(Status status){
		this.status = status;
	}
	public Status getStatus(){
		return status;
	}
}