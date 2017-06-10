<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ page import="com.model.Product" %>


<body>


  <jsp:include page="task.jsp"></jsp:include> <br/><br/>
     <%
     Product product=(Product)request.getAttribute("product");
     if(product==null){
    	 return;
     }
    
    %>
  
    
    <form:form action="/BBM488ODEV2/editProduct" method="post">
    <div style="color: red">${error}</div>
    <table align="left" width="400px"  style="background-color:#cceeff;border:3px solid #000000; table-layout: fixed;">
         <tr><td colspan=2 style="font-weight:bold;" align="center">Edit Product</td></tr>
         
	   <tr>
		 <td style="font-weight:bold;">ProductName</td>
		 <td><input type="text" name="productName" class="m" value="<%= product.getProductName()%>"/></td>
	  </tr>
	  <tr>
		<td style="font-weight:bold;">Price</td>
		<td><input type="text" name="price" class="m" value="<%=product.getPrice()%>"/></td>
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