package model;

import beans.*;

import java.util.LinkedList;

public class PostMapper {
	public static LinkedList<Post> getPostOfUser(User user) {
		
		JDBCWrapper jdbc=new JDBCWrapper();
		LinkedList<Post>posts=new LinkedList<Post>();
		try {
			posts=jdbc.GetPostsFromUser(user);
			jdbc.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return posts;
	}
	
	public static void AddNewPost(User user,String title,String content) {
		
		JDBCWrapper jdbc=new JDBCWrapper();
		String sql="Insert INTO post (p_usr_id,p_title,p_content,p_image_path,p_created_time) values ("+
	    "'"+user.getId()+"',"+
	    "'"+title+"',"+
	    "'"+content+"',"+
	    "'"+""+"',"+
	    "NOW());";
		try {
			jdbc.ExecuteQuery(sql);
			jdbc.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
