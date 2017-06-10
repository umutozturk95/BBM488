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
                	  
                	 orderState : "",
                     numberOfProduct : "",
                     date :""
                };
                $scope.fk = {
                  product_id : "",
                  customer_id : ""
                };
                      
                $scope.submitOrder = function() {
         
                    var method = "";
                    var url = "";
                   
                     method = "POST";
                     url = '/BBM488ODEV2/editOrder?customer_id='+$scope.fk.customer_id+'&product_id='+$scope.fk.product_id;
                   
         
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
                    window.location.href = '/BBM488ODEV2/listOrder'; 
                }
         
                function _error() {
                	 _clearFormData();
                	
                    
                }
         
              
                function _clearFormData() {
                    //$scope.orderForm.orderState="";
                    //$scope.orderForm.numberOfProduct="";        
                    //$scope.product_id.productId="";
                   
                  
                };
            });
        </script>


</head>
<%@ page import="com.model.Order" %>
<body  data-ng-app="OrderManagement" data-ng-controller="OrderController">
  

  <jsp:include page="task.jsp"></jsp:include> <br/> <br/> 
     <%
     Order  order=(Order)request.getAttribute("order");
     if(order==null){
    	 return;
     }
    %>
   
    
    <form ng-submit="submitOrder()">
    <div style="color: red">${error}</div>
    <table align="left" width="400px"  style="background-color:#cceeff;border:3px solid #000000; table-layout: fixed;">
         <tr><td colspan=2 style="font-weight:bold;" align="center">Edit Order</td></tr>
         
	  <tr>
		<td style="font-weight:bold;">OrderState</td>
		<td>
		<input type="hidden" ng-model="fk.customer_id" ng-init="fk.customer_id='<%=order.getCustomer().getCustomer_id()%>'" value="<%=order.getCustomer().getCustomer_id()%>" />
		<input type="hidden" ng-model="fk.product_id" ng-init="fk.product_id='<%=order.getProduct().getProduct_id()%>'" value="<%=order.getProduct().getProduct_id()%>"/>
		<input type="hidden" ng-model="orderForm.date" ng-init="orderForm.date='<%=order.getDate()%>'" value="<%=order.getDate()%>"/>
		<input type="text" ng-model="orderForm.orderState" ng-init="orderForm.orderState='<%=order.getOrderState()%>'" class="m" value="<%=order.getOrderState()%>"/></td>
		<td>
				
	  </tr>	
	  <tr>
	    <td style="font-weight:bold;">Number Of Product</td>
	    <td>
	    <input type="text" ng-model="orderForm.numberOfProduct" ng-init="orderForm.numberOfProduct='<%=order.getNumberOfProduct()%>'" class="m"  value="<%=order.getNumberOfProduct()%>" />
	    </td>
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