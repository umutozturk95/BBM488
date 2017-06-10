<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Person" %>
<body>
   <jsp:include page="link.html"></jsp:include>
    <%
    String color="";
    List<Person> applicationScopeUsers=(List<Person>)getServletContext().getAttribute("addrecords");
    if(applicationScopeUsers!=null&& applicationScopeUsers.size()>0){
    %>
      <h2>Non-secret records</h2> 
    
    <table  style="background-color:#e6f9ff;border:1px solid #000000;">
      <thead style="background-color:#00ace6;font-weight:bold">
         <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Phone Number</th>
          <th>Address</th>
          <th>Age</th>
          <th>Edit</th>
          <th>Delete</th>
         </tr>    
      </thead>
      <%
           for(int i=0;i<applicationScopeUsers.size();i++){
        	  Person person=applicationScopeUsers.get(i);
        	  if(i%2==0){
        		  color="#4dd2ff";
        	  }
        	  else{
        		  color="#ccf2ff";
        	  }
      %>
      <tr style="background-color:<%=color%>">
       <td><%=person.getName()%></td>
       <td><%=person.getSurname()%></td>
       <td><%=person.getPhoneNumber()%></td>
       <td><%=person.getAddress()%></td>
       <td><%=person.getAge()%></td>
       <td><a href="editRecord.jsp?index=<%=i %>&scopeType=application">Edit</a></td>
       <td><a href="DeleteRecordServlet?index=<%=i %>&scopeType=application">Delete</a></td>
      </tr>
     
      <%
          }
      %>
       
      </table>
    <%	        
     }
    %>
    <br/>
    <br/>
     
     <% 
     List<Person> sessionScopePersons=(List<Person>)request.getSession().getAttribute("addrecords");
     if(sessionScopePersons!=null&& sessionScopePersons.size()>0){
    %>
    
    <h2>Secret records</h2>
    
     <table style="background-color:#e6f9ff;border:1px solid #000000;">
      <thead style="background-color:#00ace6;font-weight:bold">
         <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Phone Number</th>
          <th>Address</th>
          <th>Age</th>
          <th>Edit</th>
          <th>Delete</th>
         </tr>    
      </thead>
      <%
           for(int i=0;i<sessionScopePersons.size();i++){
        	  Person person=sessionScopePersons.get(i);
        	  if(i%2==0){
        		  color="#4dd2ff";
        	  }
        	  else{
        		  color="#ccf2ff";
        	  }
      %>
      <tr style="background-color:<%=color%>">
       <td><%=person.getName()%></td>
       <td><%=person.getSurname()%></td>
       <td><%=person.getPhoneNumber()%></td>
       <td><%=person.getAddress()%></td>
       <td><%=person.getAge()%></td>
       <td><a href="editRecord.jsp?index=<%=i%>&scopeType=session">Edit</a></td>
       <td><a href="DeleteRecordServlet?index=<%=i%>&scopeType=session">Delete</a></td>
      </tr>
      
      <%
          }
      %>
       
      </table>
   
    <%
     }
    %>
</body>
</html>