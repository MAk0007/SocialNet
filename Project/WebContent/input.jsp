<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

boolean valid = true;

if(methodID != -1) methodID = Integer.parseInt(method);
switch (methodID){ 
case 1:

%>
<p></p>
<p></p>
<center>
<form action="LoginServlet" method="post">
<input type="text" name="uname" placeholder="username" ><br><p></p>
<input type="password" name="pword" placeholder="password" ><br><p></p>
<input type="submit" value="login">
</form>
</center>
<%
break;
case 2:
valid = false;
	%>
	<p></p>
	<p></p>
	<center>
	<form action="SignupServlet" method="post">
	<input type="text" name="fname" placeholder="firstname" ><br><p></p>
	<input type="text" name="lname" placeholder="lastname" ><br><p></p>
	<input type="text" name="uname" placeholder="username" ><br><p></p>
	<input type="password" name="pword" placeholder="password" ><br><p></p>
	<input type="text" name="dob" placeholder="YYYY/MM/DD" ><br><p></p>
	<input type="text" name="gender" placeholder="gender" ><br><p></p>
		<input type="submit" value="signup">
	</form>
	</center>
<%break;
}
if (valid) {
%>

<%
}
%>
</body>
</html>