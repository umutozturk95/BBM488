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
<%@ page import="com.model.Order" %>
<%@ page import="com.model.Customer" %>
<%@ page import="com.model.Product" %>
<body>
<jsp:include page="task.jsp"></jsp:include><br/>
<%
    String color="";
    List<Order> orders=(List<Order>)request.getAttribute("orderMyList");
    if(orders!=null&&orders.size()>0){
    %>
      <h2>All My Orders</h2> 
    
    <table  style="background-color:#e6f9ff;border:1px solid #000000;">
      <thead style="background-color:#00ace6;font-weight:bold">
         <tr>
          <th>ProductName</th>
          <th>OrderState</th>
          <th>NumberOfProduct</th>
         </tr>    
      </thead>
      <%
           for(int i=0;i<orders.size();i++){
        	  Order order=orders.get(i);
        	  if(i%2==0){
        		  color="#4dd2ff";
        	  }
        	  else{
        		  color="#ccf2ff";
        	  }
      %>
      <tr style="background-color:<%=color%>">
       <td><%=order.getProduct().getProductName()%></td>
        <td><%=order.getOrderState()%></td>
       <td><%=order.getNumberOfProduct()%></td>
       
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