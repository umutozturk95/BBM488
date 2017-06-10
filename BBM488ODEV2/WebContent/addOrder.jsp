<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <style>
 input.m{
       width: 100%;
       box-sizing: border-box;

 }
 </style>
</head>
<%@ page import="com.model.Product" %>
<%@ page import="java.util.*" %>
<body>

   
    <jsp:include page="task.jsp"></jsp:include><br/><br/>
    
    <%
    
       List<Product> products=(List<Product>)request.getAttribute("products");
       if(products==null ||products.size()==0){
    	  return;
    		   
       }
    
    %>
    
    
    <form:form action="addOrder" method="post">
     <div style="color: red">${error}</div>
    <table align="left" width="400px"  style="background-color:#cceeff;border:3px solid #000000; table-layout: fixed;">
         <tr><td colspan=2 style="font-weight:bold;" align="center">Add Order</td></tr>
         
	   <tr>
		 <td style="font-weight:bold;">ProductName</td>
		 <td>
		   <select name="productname">
		     <%
		       for(int i=0;i<products.size();i++){
		       
		     %>
		       <option value="<%=products.get(i).getProductName()%>"><%=products.get(i).getProductName()%></option>
		     <%
		     }
		     %>
		   </select>		 
		 </td>
	  </tr>
	  <tr>
		<td style="font-weight:bold;">Number of Products</td>
		<td><input type="text" name="numberOfProduct" class="m" value=""/>
		<input type="hidden" name="orderState" value="New" />
		</td>
	  </tr>	
	
	 <tr>
		<td></td>
		<td><input type="submit" name="Submit" value="Add"   style="background-color:#49743D; font-weight:bold;color:#ffffff;"></td>
	 </tr>
	
   </table>
    
  </form:form>
   <br/>
</body>
</html>