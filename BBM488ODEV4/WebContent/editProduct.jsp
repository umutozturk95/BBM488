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
            var app = angular.module("ProductManagement", []);
         
            //Controller Part
            app.controller("ProductController", function($scope, $http) {
                     
                $scope.productForm = {
                	 productName : "",  
                	 price : "",
                     
                };
                      
                $scope.submitProduct = function() {
         
                    var method = "";
                    var url = "";
                   
                     method = "POST";
                     url = '/BBM488ODEV2/editProduct';
                   
         
                    $http({
                        method : method,
                        url : url,
                        data : angular.toJson($scope.productForm),
                        headers : {
                            'Content-Type' : 'application/json'
                        }
                    }).then(_success,_error);
                };
                                
                function _success() {
                     
                    _clearFormData();
                    window.location.href = '/BBM488ODEV2/listProduct'; 
                }
         
                function _error() {
                	 _clearFormData();               	
                    
                }
         
              
                function _clearFormData() {
                    $scope.productForm.productName="";
                    $scope.productForm.price="";
                  
                };
            });
        </script>

</head>
<%@ page import="com.model.Product" %>


<body data-ng-app="ProductManagement" data-ng-controller="ProductController">


  <jsp:include page="task.jsp"></jsp:include> <br/><br/>
     <%
     Product product=(Product)request.getAttribute("product");
     if(product==null){
    	 return;
     }
    
    %>
  
    
    <form ng-submit="submitProduct()">
    <div style="color: red">${error}</div>
    <table align="left" width="400px"  style="background-color:#cceeff;border:3px solid #000000; table-layout: fixed;">
         <tr><td colspan=2 style="font-weight:bold;" align="center">Edit Product</td></tr>
         
	   <tr>
		 <td style="font-weight:bold;">ProductName</td>
		 <td><input type="text"  ng-model="productForm.productName" class="m" ng-init="productForm.productName='<%= product.getProductName()%>'" class="m" value="<%= product.getProductName()%>"/></td>
	  </tr>
	  <tr>
		<td style="font-weight:bold;">Price</td>
		<td><input type="text"   ng-model="productForm.price" class="m" ng-init="productForm.price='<%=product.getPrice()%>'"  class="m" value="<%=product.getPrice()%>"/></td>
	  </tr>	
	 
	 <tr>
		<td></td>
		<td><input type="submit" name="Submit" value="Edit"   style="background-color:#49743D; font-weight:bold;color:#ffffff;"></td>
	 </tr>
	
   </table>
    
  </form>
   <br/>


</body>
</html>