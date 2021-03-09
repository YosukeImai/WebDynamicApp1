package model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieMapper {
	public static void AddCookie(HttpServletResponse response,String name,String value) {
		Cookie cook=new Cookie(name,value);
		cook.setMaxAge(60*60*24*3);
		cook.setPath("/");
		response.addCookie(cook);
	}
}
