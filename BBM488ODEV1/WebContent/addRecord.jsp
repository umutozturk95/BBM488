<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <style type="text/css">
    input.m{
       width: 100%;
       box-sizing: border-box;

     }
     textarea {
	     width: 100%;
         box-sizing: border-box;
      }
    
  </style>

</head>
<body>

 <jsp:include page="link.html"></jsp:include>
 <br/>
 <br/>
 
<form  method="post" action="AddRecordServlet">

<table align="left" width="400px" style="background-color:#e6f7ff;border:3px solid #000000;">
<tr><td colspan=2 style="font-weight:bold;" align="center">Add Record</td></tr>
<tr><td colspan=2 align="center" height="10px"></td></tr>
	<tr>
		<td style="font-weight:bold;">First Name</td>
		<td><input type="text" name="first_name" class="m" value=""></td>
	</tr>
	<tr>
		<td style="font-weight:bold;">Last Name</td>
		<td><input type="text" name="last_name" class="m" value=""></td>
	</tr>
	<tr>
		<td style="font-weight:bold;">Phone Number</td>
		<td><input type="text" name="phoneNumber" class="m" value=""></td>
	</tr>
	<tr>
		<td style="font-weight:bold;">Address</td>
		<td><textarea  cols="17" name="address"></textarea>  
	</tr>
	
	<tr>
		<td style="font-weight:bold;">Age</td>
		<td><input type="text"  name="age" class="m" value=""></td>
	</tr>
	<tr>
		<td style="font-weight:bold;">Record Type</td>
		<td><input type="radio"  name="type" value="secret">Secret
		   &nbsp;
		   <input type="radio"  name="type" value="non-secret">Non-secret
		</td>
		
	</tr>
	
	<tr>
		<td></td>
		<td><input type="submit" name="Submit" value="Save" style="background-color:#49743D;font-weight:bold;color:#ffffff;"></td>
	</tr>
	
</table>
</form>
<br/>
<br/>

</body>
</html>