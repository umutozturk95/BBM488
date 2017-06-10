<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
    input.m{
       width: 100%;
       box-sizing: border-box;

     }
     textarea {
	     width: 100%;
         box-sizing: border-box;
      }
    
  </style>

</head>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Person" %>
<body>
   <jsp:include page="link.html"></jsp:include>
   <br/>
   <br/>
   
 <%!
 
  List<Person> records;
 
 %>
 
 <%
   int index=Integer.parseInt(request.getParameter("index"));
   String scopeName=request.getParameter("scopeType");
   if(scopeName.equals("application")){
	   records=(List<Person>)request.getServletContext().getAttribute("addrecords");
	   
   }
   else if(scopeName.equals("session")){
	   records=(List<Person>)request.getSession().getAttribute("addrecords");
   }
 
   Person person=records.get(index);
   request.getSession().setAttribute("editrecord",person);
    
 %>
 

  <form method="post" action="EditRecordServlet">
     <table align="left" width="400px" style="background-color:#e6f7ff;border:3px solid #000000;">
        <tr><td colspan=2 style="font-weight:bold;" align="center">Edit User</td></tr>
        <tr><td colspan=2 align="center" height="10px"></td></tr>
	    <tr>
		   <td>First Name</td>
		   <td><input type="text" class="m" name="first_name" value="<%=person.getName()%>"></td>
	    </tr>
	    <tr>
		  <td>Last Name</td>
		  <td><input type="text"  class="m" name="last_name" value="<%=person.getSurname()%>"></td>
	   </tr>
	   <tr>
		<td>Phone Number</td>
		<td><input type="text" class="m" name="phone_number" value="<%=person.getPhoneNumber()%>"></td>
	   </tr>
	  <tr>
		<td>Address</td>
		<td><textarea name="address"><%=person.getAddress()%></textarea></td>
	  </tr>
	  <tr>
		<td>Age</td>
		<td><input type="text" class="m" name="age" value="<%=person.getAge()%>"></td>
	  </tr>
	  
	  <tr>
	    <td>Record Type</td>
		<td>
		   <%
		    if(scopeName.equals("application")){
		   
		   %>
		   
		     <input type="radio"  name="type" value="non-secret" checked="checked">Non-secret
		     &nbsp;
		     <input type="radio"  name="type" value="secret">Secret
		   <%
		     }
		    else{
		   %>
		   
		    <input type="radio"  name="type" value="secret" checked="checked">Secret
		     &nbsp;
		    <input type="radio"  name="type" value="non-secret">Non-secret
		    		   
		   <%
		    }
		   %>
		   
		 
		</td>
	  
	  </tr>
	  
	<tr>
		 <td>
		   <input type="hidden" name="previousScope"value="<%=scopeName%>"/>
		   <input type="hidden" name="index" value="<%=index%>"/>
		</td>
		
		<td><input type="submit" name="Submit" value="Edit" style="background-color:#49743D;font-weight:bold;color:#ffffff;"></td>
	</tr>
	
</table>
</form>


</body>
</html>