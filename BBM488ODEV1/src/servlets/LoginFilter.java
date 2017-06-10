package servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.RequestDispatcher;

import java.util.Map;
/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(
		
filterName="LoginFilter",
urlPatterns="/LoginServlet"
)
public class LoginFilter implements Filter {

   
    public LoginFilter() {
      
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println(" Filter Destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html");
		Map<String,String> admins=Login.getAdmins();
		PrintWriter out=response.getWriter();
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		
		if(admins.containsKey(name)&&(((String)admins.get(name)).equals(password))){
			
			chain.doFilter(request, response);
		}
		else{
			
			out.print("<span style='color:red'>Username or password error!</span><br/>");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
			
		}
		out.close();
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	 
	}

}
