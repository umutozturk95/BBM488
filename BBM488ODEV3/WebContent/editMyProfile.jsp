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
 
   <jsp:include page="task.jsp"></jsp:include> <br/><br/>
     <%
     Customer customer=(Customer)request.getAttribute("customer");
     if(customer==null){
    	 return;
    	 
     }
    %>
   
   
    <form:form action="/BBM488ODEV2/editMyProfile" method="post">
     <div style="color: red">${error}</div>
    <table align="left" width="400px"  style="background-color:#cceeff;border:3px solid #000000; table-layout: fixed;">
         <tr><td colspan=2 style="font-weight:bold;" align="center">Edit My Profile
          <input type="hidden" name="username" value="<%=customer.getUsername() %>" />
         </td></tr>
  
	   <tr>
		<td style="font-weight:bold;">Password</td>
		<td><input type="text" name="password" class="m" value="<%=customer.getPassword()%>"/></td>
	  </tr>	
	  <tr>
	     <td style="font-weight:bold;">Name</td>
		<td><input type="text" name="name" class="m" value="<%=customer.getName()%>"/></td>
	  </tr>
	   <tr>
	     <td style="font-weight:bold;">Surname</td>
		<td><input type="text" name="surname" class="m" value="<%=customer.getSurname()%>"/></td>
	  </tr>
	   <tr>
	     <td style="font-weight:bold;">Floor</td>
		<td><input type="text" name="floor" class="m" value="<%=customer.getFloor()%>"/></td>
	  </tr>
	   <tr>
	     <td style="font-weight:bold;">Building</td>
		<td><input type="text" name="building" class="m" value="<%=customer.getBuilding()%>"/></td>
	  </tr>
	   <tr>
	     <td style="font-weight:bold;">RoomNumber</td>
		<td><input type="text" name="roomNumber" class="m" value="<%=customer.getRoomNumber()%>"/></td>
	  </tr>
	  
	 <tr>
		<td></td>
		<td><input type="submit" name="Submit" value="Edit"   style="background-color:#49743D; font-weight:bold;color:#ffffff;"></td>
	 </tr>
	
   </table>
    
  </form:form>
   <br/>
</body>
</html>