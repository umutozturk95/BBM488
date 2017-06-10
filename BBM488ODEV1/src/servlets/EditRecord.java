package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import bean.Person;

import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditRecord
 */
@WebServlet("/EditRecordServlet")
public class EditRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		Person editPerson=(Person)request.getSession().getAttribute("editrecord");
		String firstName=request.getParameter("first_name");
		String last_name=request.getParameter("last_name");
		String phone_number=request.getParameter("phone_number");
		String address=request.getParameter("address");
		String age=request.getParameter("age");
		
		String previousScope=request.getParameter("previousScope");	
		String newScopeType=request.getParameter("type");
		int index=Integer.parseInt(request.getParameter("index"));
		String previousScopeType=null;
		
		List<Person> newRecords=null;
		List<Person> previousRecords=null;
		
		editPerson.setAddress(address);
		editPerson.setName(firstName);
		editPerson.setSurname(last_name);
		editPerson.setPhoneNumber(phone_number);
		editPerson.setAge(age);
		
		if(previousScope.equals("application")){
			previousScopeType="non-secret";
			
		}
		else if(previousScope.equals("session")){
			previousScopeType="secret";
		}
		
		
		if(previousScopeType.equals(newScopeType)!=true){
		   	
			if(newScopeType.equals("non-secret")){
			   newRecords=(List<Person>)getServletContext().getAttribute("addrecords");
			   if(newRecords==null){
				   newRecords=new ArrayList<Person>();
				   getServletContext().setAttribute("addrecords",newRecords);
			   }
			   
			   newRecords.add(editPerson);
			   previousRecords=(List<Person>)request.getSession().getAttribute("addrecords");
			   previousRecords.remove(index);
			}
			else if(newScopeType.equals("secret")){
			   newRecords=(List<Person>)request.getSession().getAttribute("addrecords");						  
			   if(newRecords==null){
				   newRecords=new ArrayList<Person>();
				   request.getSession().setAttribute("addrecords",newRecords);
			   }
			   newRecords.add(editPerson);
			   previousRecords=(List<Person>)getServletContext().getAttribute("addrecords");
			   previousRecords.remove(index);
			}
			
		}
		
		
		request.getRequestDispatcher("listAllRecord.jsp").forward(request,response);
	
	}

}
