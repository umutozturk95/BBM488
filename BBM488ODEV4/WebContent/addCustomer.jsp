<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    
  
    <script type="text/javascript">
            var app = angular.module("CustomerManagement", []);
         
            //Controller Part
            app.controller("CustomerController", function($scope, $http) {
                     
                $scope.customerForm = {
                	 username : "",  
                	 password : "",
                     name : "",
                     surname : "",
                     floor : "",
                     building : "",
                     roomNumber : ""  
                };
                      
                $scope.submitCustomer = function() {
         
                    var method = "";
                    var url = "";
                   
                     method = "POST";
                     url = '/BBM488ODEV2/addCustomer';
                   
         
                    $http({
                        method : method,
                        url : url,
                        data : angular.toJson($scope.customerForm),
                        headers : {
                            'Content-Type' : 'application/json'
                        }
                    }).then(_success,_error);
                };
         
             
                
                function _success() {
                     
                    _clearFormData();
                    window.location.href = '/BBM488ODEV2/listCustomer'; 
                }
         
                function _error() {
                	 _clearFormData();
                	
                     
                }
         
              
                function _clearFormData() {
                    $scope.customerForm.building="";
                    $scope.customerForm.floor="";
                    $scope.customerForm.name="";
                    $scope.customerForm.surname="";
                    $scope.customerForm.password="";
                    $scope.customerForm.roomNumber="";
                    $scope.customerForm.username="";
                
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
<body data-ng-app="CustomerManagement" data-ng-controller="CustomerController">
   
     <jsp:include page="task.jsp"></jsp:include><br/><br>    
    <form  ng-submit="submitCustomer()">
    <div style="color: red">${error}</div>
    <table align="left" width="400px"  style="background-color:#cceeff;border:3px solid #000000; table-layout: fixed;">
         
       <tr><td colspan=2 style="font-weight:bold;" align="center">Add Customer</td></tr>
         
	   <tr>
		 <td style="font-weight:bold;">Username</td>
		 <td><input type="text" ng-model="customerForm.username" class="m" value="" /></td>
	  </tr>
	  <tr>
		<td style="font-weight:bold;">Password</td>
		<td><input type="text" ng-model="customerForm.password" class="m" value=""/></td>
	  </tr>	
	  <tr>
	     <td style="font-weight:bold;">Name</td>
		<td><input type="text" ng-model="customerForm.name" class="m" value=""/></td>
	  </tr>
	   <tr>
	     <td style="font-weight:bold;">Surname</td>
		<td><input type="text" ng-model="customerForm.surname" class="m" value=""/></td>
	  </tr>
	   <tr>
	     <td style="font-weight:bold;">Floor</td>
		<td><input type="text" ng-model="customerForm.floor" class="m" value=""/></td>
	  </tr>
	   <tr>
	     <td style="font-weight:bold;">Building</td>
		<td><input type="text" ng-model="customerForm.building" class="m" value=""/></td>
	  </tr>
	   <tr>
	     <td style="font-weight:bold;">RoomNumber</td>
		<td><input type="text"  ng-model="customerForm.roomNumber" class="m" value=""/></td>
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