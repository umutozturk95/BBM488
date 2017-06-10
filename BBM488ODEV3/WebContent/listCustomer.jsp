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
<%@ page import="com.model.Customer" %>
<body>
<jsp:include page="task.jsp"></jsp:include><br/>

<%
    String color="";
    List<Customer> customers=(List<Customer>)request.getAttribute("customerList");
    if(customers!=null&&customers.size()>0){
    %>
      <h2>All the Customers</h2> 
    
    <table  style="background-color:#e6f9ff;border:1px solid #000000;">
      <thead style="background-color:#00ace6;font-weight:bold">
         <tr>
          <th>UserName</th>
          <th>Password</th>
          <th>Name</th>
          <th>Surname</th>
          <th>Floor</th>
          <th>Building</th>
          <th>Room Number</th>
          <th>Edit</th>
          <th>Delete</th>
         </tr>    
      </thead>
      <%
           for(int i=0;i<customers.size();i++){
        	  Customer customer=customers.get(i);
        	  if(i%2==0){
        		  color="#4dd2ff";
        	  }
        	  else{
        		  color="#ccf2ff";
        	  }
      %>
      <tr style="background-color:<%=color%>">
       <td><%=customer.getUsername()%></td>
        <td><%=customer.getPassword()%></td>
       <td><%=customer.getName()%></td>
       <td><%=customer.getSurname()%></td>
       <td><%=customer.getFloor()%></td>
       <td><%=customer.getBuilding()%></td>
        <td><%=customer.getRoomNumber()%></td>
       <td><a href="showEditCustomerForm/<%=customer.getCustomer_id()%>">Edit</a></td>
       <td><a href="deleteCustomer?id=<%=customer.getCustomer_id()%>">Delete</a></td>
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