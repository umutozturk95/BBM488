<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ page import="com.model.Order" %>
<body>
  

  <jsp:include page="task.jsp"></jsp:include> <br/> <br/> 
     <%
     Order  order=(Order)request.getAttribute("order");
     if(order==null){
    	 return;
     }
    %>
   
    
    <form:form action="/BBM488ODEV2/editOrder" method="post">
    <div style="color: red">${error}</div>
    <table align="left" width="400px"  style="background-color:#cceeff;border:3px solid #000000; table-layout: fixed;">
         <tr><td colspan=2 style="font-weight:bold;" align="center">Edit Order</td></tr>
         
	  <tr>
		<td style="font-weight:bold;">OrderState</td>
		<td>
		<input type="hidden" name="customer_id" value="<%=order.getCustomer().getCustomer_id()%>" />
		<input type="hidden" name="product_id" value="<%=order.getProduct().getProduct_id()%>"/>
		<input type="hidden" name="numberOfProduct" value="<%=order.getNumberOfProduct()%>" />
		<input type="text" name="orderState" class="m" value="<%=order.getOrderState()%>"/></td>
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