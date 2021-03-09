package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter {
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
		if(this.encoding!=null) {
			System.out.println("set encoding");
			request.setCharacterEncoding(encoding);
		}
		
		chain.doFilter(request, response);

	}
	
	@Override
	public void destroy() {
		System.out.println("destroy encoding");
		this.encoding = null;
		this.filterConfig = null;
	}

}
