<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ page import="com.model.Customer" %>
<body>

 <jsp:include page="task.jsp"></jsp:include><br/><br/>

<%
    String color="";
    Customer customer =(Customer)request.getAttribute("customer");
    if(customer!=null){
    %>
      <h2>My Profile</h2> 
    
    <table  style="background-color:#e6f9ff;border:1px solid #000000;">
      <thead style="background-color:#00ace6;font-weight:bold">
         <tr>
         
          <th>Password</th>
          <th>Name</th>
          <th>Surname</th>
          <th>Floor</th>
          <th>Building</th>
          <th>Room Number</th>
          <th>Edit</th>
         
         </tr>    
      </thead>
      <%
                  		  
        color="#4dd2ff";
        	 
      %>
      <tr style="background-color:<%=color%>">
      
        <td><%=customer.getPassword()%></td>
       <td><%=customer.getName()%></td>
       <td><%=customer.getSurname()%></td>
       <td><%=customer.getFloor()%></td>
       <td><%=customer.getBuilding()%></td>
        <td><%=customer.getRoomNumber()%></td>
       <td><a href="/BBM488ODEV2/showEditMyProfileForm">Edit</a></td>
       
      </tr>
     
      <%
          }
      %>
       
      </table>
    


</body>
</html>