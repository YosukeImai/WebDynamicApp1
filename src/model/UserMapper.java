package model;

import javax.servlet.http.HttpServletResponse;

import beans.*;

public class UserMapper {
	public static User getUserFromID(String userid) {
		User user=null;

		try {
			JDBCWrapper jdbc=new JDBCWrapper();
			user=jdbc.GetUserFromID(userid);
			jdbc.close();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}
	
	public static void addUserCookie(HttpServletResponse response,User user) {
		CookieMapper.AddCookie(response, "userid", user.getId());
		CookieMapper.AddCookie(response, "name", user.getName());
	}
}
