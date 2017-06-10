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
     
     
 
  </style>
</head>
<body>
     
  <form action="LoginServlet" method="post">
    <table align="left" width="300px"  style="background-color:#cceeff;border:3px solid #000000; table-layout: fixed;">
         <tr><td colspan=2 style="font-weight:bold;" align="center">LOGIN</td></tr>
         
	   <tr>
		 <td style="font-weight:bold;">Username</td>
		 <td><input type="text" name="name" class="m" value="" /></td>
	  </tr>
	  <tr>
		<td style="font-weight:bold;">Password</td>
		<td><input type="password" name="password" class="m" value=""/></td>
	  </tr>	
	 <tr>
		<td></td>
		<td><input type="submit" name="Submit" value="Login"   style="background-color:#49743D; font-weight:bold;color:#ffffff;"></td>
	 </tr>
	
</table>
  
  </form>
</body>
</html>