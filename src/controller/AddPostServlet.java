package controller;

import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import model.PostMapper;

/**
 * Servlet implementation class AddPostServlet
 */
@WebServlet("/addPost")
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println("title:"+title);
		System.out.println("content:"+content);
		
		HttpSession session = request.getSession(false);
		User user=session==null?null:(User)session.getAttribute("user");
		
		if(user!=null&&title==null) {
	        
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/post.jsp");
			rd.forward(request, response);
		}
		else if(title!=null) {
			System.out.println("start to insert new record");
			//insert add new record
			PostMapper.AddNewPost(user, title, content);
			URL baseUrl=new URL(request.getHeader("REFERER"));
    		URL url=new URL(baseUrl,"./home");
    		request.setAttribute("url", url.toString());
    		response.sendRedirect(url.toString());	 
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(request, response);
		}
	}
}
