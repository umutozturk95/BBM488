package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Person;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddRecordServlet")
public class AddRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("text/html");
         PrintWriter out=response.getWriter();
         
		 String firstName=request.getParameter("first_name");
         String lastName=request.getParameter("last_name");
         String phoneNumber=request.getParameter("phoneNumber");
         String address=request.getParameter("address");
         String age=request.getParameter("age");
         String type=request.getParameter("type");
         Person newPerson=new Person(firstName, lastName, phoneNumber, address, age);
         
         if(firstName==null||lastName==null||phoneNumber==null||address==null||age==null||type==null){
        	
        	
        	out.print("<span style='color:red'>All fields must be filled!</span><br/>"); 
        	request.getRequestDispatcher("addRecord.jsp").include(request, response);
        	out.close();
            return;	 
         }
         if(firstName.trim().length()==0||lastName.trim().length()==0||phoneNumber.trim().length()==0||address.trim().length()==0||age.trim().length()==0||type.trim().length()==0){
        	
        	 out.print("<span style='color:red'>All fields must be filled!</span><br/>");  
        	 request.getRequestDispatcher("addRecord.jsp").include(request, response);
         	 out.close();
             return;	 
        	 
         }
         
         
         List<Person> personList;
         if(type.equals("secret")){
        	 
        	 HttpSession session=request.getSession();
        	 
        	 if(session.getAttribute("addrecords")==null){
        		  personList=new ArrayList<Person>();
        		 personList.add(newPerson);
        		 session.setAttribute("addrecords",personList);
        		 
        	 }
        	 else{
        		 
        		 personList=(List<Person>)session.getAttribute("addrecords");
        		 personList.add(newPerson);
        	 }
         }
         else if(type.equals("non-secret")){
        	 ServletContext context=getServletContext();
        	 
        	 if(context.getAttribute("addrecords")==null){
        		 
        		personList=new ArrayList<Person>();
        		personList.add(newPerson);
        		context.setAttribute("addrecords",personList);
        	 }
        	 else{
        		 personList=(List<Person>)context.getAttribute("addrecords");
        		 personList.add(newPerson);
        		 
        		 
        	 }
        	 
         }
          
         request.getRequestDispatcher("listAllRecord.jsp").forward(request,response);
		
	}

}
