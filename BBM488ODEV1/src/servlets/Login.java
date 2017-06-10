package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static  Map<String,String> admins;
    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    	System.out.println("Login Servlet");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public void init(ServletConfig config) throws ServletException  {
    	
    	admins=new LinkedHashMap<String,String>();
    	admins.put("admin1","123");
    	admins.put("admin2", "124");
    	System.out.println("Servlet Init ");
    	
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   response.setContentType("text/html");
	   PrintWriter out=response.getWriter();
	   out.print("<h2>Welcome "+request.getParameter("name")+"</h2>");
	   request.getRequestDispatcher("addRecord.jsp").include(request,response);
       out.close();   	  
	  
	   
	}
  public static  Map<String,String> getAdmins(){
	  
	  return  admins;
  }
}
