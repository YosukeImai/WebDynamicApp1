package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import beans.*;

public class JDBCWrapper implements AutoCloseable{
	static final String serverName="localhost";
	static final String databaseName="post_info";
	static final String user="YosukeImai";
	static final String password="imai1431";
	static final String serverEncoding="UTF-8";
	static final String url="jdbc:mysql://localhost/"+databaseName;
	
	private Connection myCon;
	private Statement myStatement;
	
	public JDBCWrapper() {
		Connect();
	}
	
	public void ExecuteQuery(String query) {
		try {
			// MySQL に接続
			Connection myCon=DriverManager.getConnection(url,user,password);
			myCon.setAutoCommit(false);
			try {
				System.out.println("Start to commint：" + query);
				PreparedStatement state=myCon.prepareStatement(query);
				state.executeUpdate();
				myCon.commit();
				System.out.println("End to commint：" + query);
			} catch (SQLException e) {
				myCon.rollback();
				// TODO Auto-generated catch block
				System.out.println("処理エラー：" + e.getMessage());
			}
			finally{
				close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User GetUserFromID(String userID) {
		try {

			String query="Select usr_id,usr_name,usr_password from user Where usr_id='"+userID+"'";
			System.out.println("execute query:"+query);
			ResultSet rs=myStatement.executeQuery(query);
			while(rs.next()) {
				String id=rs.getString("usr_id");
				String name=rs.getString("usr_name");
				String password=rs.getString("usr_password");
				User usr=new User(id,name,password);
				return usr;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public LinkedList<Post>GetPostsFromUser(User user){
		LinkedList<Post>posts=new LinkedList<Post>();

		String query="Select p_id,p_title,p_content,p_image_path,p_created_time from post Where p_usr_id='"+user.getId()+"'";
		System.out.println("execute query:"+query);
		ResultSet rs;
		try {
			rs = myStatement.executeQuery(query);
			
			while(rs.next()) {
				int id=rs.getInt("p_id");
				String title=rs.getString("p_title");
				String content=rs.getString("p_content");
				String imagePath=rs.getString("p_image_path");
				String time=rs.getString("p_created_time");
	
				posts.add(new Post(id,title,content,imagePath,time));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return posts;
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		Close();
	}
	
	private void Connect() {
		String errorMessage="";
		
		try {		
			 // ドライバロード
			Class.forName( "com.mysql.cj.jdbc.Driver" );
			
			// MySQL に接続
			Connection myCon=DriverManager.getConnection(url,user,password);
			
			// ステートメント生成
			myStatement=myCon.createStatement();
			
			System.out.println("sucess to conect SQL");
			
		} catch (ClassNotFoundException e) {

			errorMessage="fail to load driver"; 
		} catch (SQLException e) {

			errorMessage="fail to connect SQLServer";
		}
		finally {
			if(!errorMessage.equals(""))
				System.out.println(errorMessage);
		}
	}
	
	private void Close() {
		
		try {
			if(myCon!=null)
				myCon.close();
			if(myStatement!=null)
				myStatement.close();
			System.out.println("sucess to close SQL");
		} catch (SQLException e) {
			System.out.println("fail to close SQL");
		}
	}
}
