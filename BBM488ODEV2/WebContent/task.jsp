<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
 
  a{
     
    display: inline-block;
    background: #0099e6;
    color: white;
    padding: 5px;
    text-align: center;
    border-radius: 5px;
    font-weight: bold;
     
  }

</style>
</head>
<body>
 
 
 <h3>TEA SHOP!</h3>

 <%
   if(request.getSession().getAttribute("type").equals("admin")){
 
 %>
 
 <a href="/BBM488ODEV2/showAddCustomerForm">Add Customer</a>  
 <a href="/BBM488ODEV2/showAddProductForm">Add Product</a>
 <a href="/BBM488ODEV2/listCustomer">List Customers</a>
 <a href="/BBM488ODEV2/listProduct">List Products</a>
 <a href="/BBM488ODEV2/listOrder">List Orders</a>
 
 
 <%
   }
   else{
 %>
 
  <a href="/BBM488ODEV2/listMyOrder">List My Orders</a>
  <a href="/BBM488ODEV2/viewMyProfile">View My Profile </a>
  <a href="/BBM488ODEV2/showAddOrderForm">Add Order</a>
 
 <%
   }
 %>
 
 <a href="/BBM488ODEV2/logout">Logout</a>
 <div style="color: blue">${message}</div>
 
  
</body>
</html>