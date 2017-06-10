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
            var app = angular.module("CustomerManagement", []);
         
         
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
                     url = '/BBM488ODEV2/editMyProfile';
                   
         
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
                    window.location.href = '/BBM488ODEV2/viewMyProfile'; 
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


</head>
<%@ page import="com.model.Customer" %>
<body  data-ng-app="CustomerManagement" data-ng-controller="CustomerController">
 
   <jsp:include page="task.jsp"></jsp:include> <br/><br/>
     <%
     Customer customer=(Customer)request.getAttribute("customer");
     if(customer==null){
    	 return;
    	 
     }
    %>
   
   
    <form ng-submit="submitCustomer()">
     <div style="color: red">${error}</div>
    <table align="left" width="400px"  style="background-color:#cceeff;border:3px solid #000000; table-layout: fixed;">
         <tr><td colspan=2 style="font-weight:bold;" align="center">Edit My Profile
          <input type="hidden"  ng-model="customerForm.username" class="m"  ng-init="customerForm.username='<%= customer.getUsername()%>'" value="<%= customer.getUsername()%>" />
         </td></tr>
  
	   <tr>
		<td style="font-weight:bold;">Password</td>
		<td><input type="text" ng-model="customerForm.password" class="m" ng-init="customerForm.password='<%=customer.getPassword()%>'" value="<%=customer.getPassword()%>"/></td>
	  </tr>	
	  <tr>
	     <td style="font-weight:bold;">Name</td>
		<td><input type="text" ng-model="customerForm.name" class="m" ng-init="customerForm.name='<%=customer.getName()%>'"  value="<%=customer.getName()%>"/></td>
	  </tr>
	   <tr>
	     <td style="font-weight:bold;">Surname</td>
		<td><input type="text"  ng-model="customerForm.surname" class="m" ng-init="customerForm.surname='<%=customer.getSurname()%>'"  value="<%=customer.getSurname()%>"/></td>
	  </tr>
	   <tr>
	     <td style="font-weight:bold;">Floor</td>
		<td><input type="text" ng-model="customerForm.floor" class="m" ng-init="customerForm.floor='<%=customer.getFloor()%>'" value="<%=customer.getFloor()%>"/></td>
	  </tr>
	   <tr>
	     <td style="font-weight:bold;">Building</td>
		<td><input type="text" ng-model="customerForm.building" class="m" ng-init="customerForm.building='<%=customer.getBuilding()%>'"  value="<%=customer.getBuilding()%>"/></td>
	  </tr>
	   <tr>
	     <td style="font-weight:bold;">RoomNumber</td>
		<td><input type="text"  ng-model="customerForm.roomNumber" class="m" ng-init="customerForm.roomNumber='<%=customer.getRoomNumber()%>'"  value="<%=customer.getRoomNumber()%>"/></td>
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