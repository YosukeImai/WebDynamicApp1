package controller;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import model.UserMapper;
import util.Authenticate;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	System.out.println("start login servlet");
    	String sentId = request.getParameter("login-id");
    	String sentPw = request.getParameter("hashPassword");

    	try {
    		User user=UserMapper.getUserFromID(sentId);

    		if (user!=null&&Authenticate.equal(user, sentPw)) {  
    			HttpSession session = request.getSession();  
    			session.setAttribute("user", user); 
    			session.setAttribute("loginUser", true); 

    			String header=request.getHeader("REFERER");
    			URL baseUrl=new URL(header);
    			URL url=new URL(baseUrl,"./home");
    			response.sendRedirect(url.toString());	  

    		} else {              	 
    			request.setAttribute("loginErrorMsg", "ログイン情報が不正です。");                    	 
    			request.setAttribute("errorFlg", true);                  	 
    			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");              	 
    			rd.forward(request, response);
    		}
    	} catch (NoSuchAlgorithmException | ServletException | IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
        rd.forward(request, response);
    }

}
