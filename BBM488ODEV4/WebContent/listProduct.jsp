<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
  <script type="text/javascript">
            var app = angular.module("ProductManagement", []);
         
            //Controller Part
            app.controller("ProductController", function($scope, $http) {   
                $scope.deleteProduct = function(product_id) {
                    $http({
                        method : 'DELETE',
                        url : '/BBM488ODEV2/deleteProduct?id=' + product_id
                    }).then(_success,_error );
                };
 
              
                function _success() {
                   window.location.href = '/BBM488ODEV2/listProduct'; 
                   
                }
         
                function _error() {
                	  
               
                }
              
            });
        </script>
</head>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.Product" %>

<body  ng-app="ProductManagement" ng-controller="ProductController">
<jsp:include page="task.jsp"></jsp:include><br/>
<%
    String color="";
    List<Product> products=(List<Product>)request.getAttribute("productList");
    if(products!=null&&products.size()>0){
    %>
      <h2>All the Products</h2> 
    
    <table  style="background-color:#e6f9ff;border:1px solid #000000;">
      <thead style="background-color:#00ace6;font-weight:bold">
         <tr>
          <th>ProductName</th>
          <th>Price</th>
          <th>Edit</th>
          <th>Delete</th>
         </tr>    
      </thead>
      <%
           for(int i=0;i<products.size();i++){
        	  Product product=products.get(i);
        	  if(i%2==0){
        		  color="#4dd2ff";
        	  }
        	  else{
        		  color="#ccf2ff";
        	  }
      %>
       <tr style="background-color:<%=color%>">
       <td><%=product.getProductName()%></td>
       <td><%=product.getPrice()%></td>
      
       <td><a href="showEditProductForm/<%=product.getProduct_id() %>"style="text-decoration:none;">Edit</a></td>
       <td><a  ng-click="deleteProduct(<%=product.getProduct_id() %>)">Delete</a></td>
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