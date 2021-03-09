package filter;

import java.io.IOException;
import java.net.URL;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PostMapper;

public class LoginFilter implements Filter {
	protected String encoding = null;
	protected FilterConfig filterConfig = null;
	
	@Override
	public void init(FilterConfig filterConfig) {
		this.filterConfig=filterConfig;
		this.encoding=filterConfig.getInitParameter("encoding");
		System.out.println("set init encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// セッションが存在しない場合NULLを返す
        HttpSession session = ((HttpServletRequest)request).getSession(false);

        if(session != null){
            // セッションがNULLでなければ、通常どおりの遷移
            chain.doFilter(request, response);
        }else{
            // セッションがNullならば、ログイン画面へ飛ばす
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
            dispatcher.forward(request, response);
        }
	}
	
	@Override
	public void destroy() {
		this.filterConfig = null;
	}
	
}
