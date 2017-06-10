<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
 
 <script type="text/javascript">
             var app = angular.module("OrderManagement", []);
         
            //Controller Part
             app.controller("OrderController", function($scope, $http) {
                     
                $scope.orderForm = {
                	  
                	 orderState : "New",
                     numberOfProduct : ""
                };
                $scope.product_id = {
                  productId : ""
                };
                      
                $scope.submitOrder = function() {
         
                    var method = "";
                    var url = "";
                   
                     method = "POST";
                     url = '/BBM488ODEV2/addOrder/'+$scope.product_id.productId;
                   
         
                    $http({
                        method : method,
                        url : url,
                        data : angular.toJson($scope.orderForm),
                        headers : {
                            'Content-Type' : 'application/json'
                        }
                    }).then(_success,_error);
                };
         
             
                
                function _success() {
                     
                    _clearFormData();
                    window.location.href = '/BBM488ODEV2/listMyOrder'; 
                }
         
                function _error() {
                	 _clearFormData();
                	
                    
                }
         
              
                function _clearFormData() {
                    $scope.orderForm.orderState="";
                    $scope.orderForm.numberOfProduct="";
                    $scope.product_id.productId="";
                   
                  
                };
            });
        </script>

 <style>
 input.m{
       width: 100%;
       box-sizing: border-box;

 }
 </style>
</head>
<%@ page import="com.model.Product" %>
<%@ page import="java.util.*" %>
<body data-ng-app="OrderManagement" data-ng-controller="OrderController">

   
    <jsp:include page="task.jsp"></jsp:include><br/><br/>
    
    <%
    
       List<Product> products=(List<Product>)request.getAttribute("products");
       if(products==null ||products.size()==0){
    	  return;
    		   
       }
    
    %>
    
    
    <form ng-submit="submitOrder()" >
     <div style="color: red">${error}</div>
    <table align="left" width="400px"  style="background-color:#cceeff;border:3px solid #000000; table-layout: fixed;">
         <tr><td colspan=2 style="font-weight:bold;" align="center">Add Order</td></tr>
         
	   <tr>
		 <td style="font-weight:bold;">ProductName</td>
		 <td>
		   <select ng-model="product_id.productId">
		     <%
		       for(int i=0;i<products.size();i++){
		       
		     %>
		       <option  class="m" value="<%=products.get(i).getProduct_id()%>"><%=products.get(i).getProductName()%></option>
		     <%
		     }
		     %>
		   </select>		 
		 </td>
	  </tr>
	  <tr>
		<td style="font-weight:bold;">Number of Products</td>
		<td><input type="text"  ng-model="orderForm.numberOfProduct" class="m" value=""/>
		
		</td>
	  </tr>	
	
	 <tr>
		<td></td>
		<td><input type="submit" name="Submit" value="Add"   style="background-color:#49743D; font-weight:bold;color:#ffffff;"></td>
	 </tr>
	
   </table>
    
  </form>
   <br/>
</body>
</html>