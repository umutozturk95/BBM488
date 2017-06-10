package servlets;

import java.io.IOException;

import bean.Person;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteRecord
 */
@WebServlet("/DeleteRecordServlet")
public class DeleteRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		int index=Integer.parseInt(request.getParameter("index"));
		String scopeType=request.getParameter("scopeType");
		List <Person> records=new ArrayList<Person>();
		if(scopeType.equals("session")){
			records=(List<Person>)request.getSession().getAttribute("addrecords");
			
		}
		else if(scopeType.equals("application")){
			records=(List<Person>)request.getServletContext().getAttribute("addrecords");
		}
		
		
		
		if(records.size()>0){
			
			records.remove(index);
		}
		
		
		request.getRequestDispatcher("listAllRecord.jsp").forward(request, response);
		
	}

}
