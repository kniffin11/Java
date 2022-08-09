<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Expense</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
	<h1 style="color: purple; display: flex; justify-content: center;">Book Club</h1>
	<p style="display: flex; justify-content: center;">A place for friends to share thoughts on books</p>
	<div class="container" style="display:flex; justify-content: space-evenly;">
		<div>
			<h1>Register</h1>
			<form:form action="/register" method="post" modelAttribute="newUser">
		    <div class="form-group">
		        <form:label path="userName">User Name: </form:label>
		        <form:errors path="userName"/>
		        <form:input path="userName" class="form-control"/>
		    </div>
		    <div class="form-group">
		        <form:label path="email">Email: </form:label>
		        <form:errors path="email"/>
		        <form:input path="email" class="form-control"/>
		    </div>
		    <div class="form-group">
		        <form:label path="password">Password: </form:label>
		        <form:errors path="password"/>
		        <form:input path="password" class="form-control"/>
		    </div>
		    <div class="form-group">
		        <form:label path="confirm">Confirm Password: </form:label>
		        <form:errors path="confirm"/>     
		        <form:input path="confirm" class="form-control"/>
		        <br>
		    </div>    
		    <input type="submit" value="Register" class="btn btn-primary"/>
			</form:form> 
		</div>
	
		<div>
			<h1>Login</h1>
			<form:form action="/login" method="post" modelAttribute="newLogin">
		    <div class="form-group">
		        <form:label path="email">Email: </form:label>
		        <form:errors path="email"/>
		        <form:input path="email" class="form-control"/>
		    </div>
		    <div class="form-group">
		        <form:label path="password">Password: </form:label>
		        <form:errors path="password"/>
		        <form:input path="password" class="form-control"/>
		        <br>
		    </div>   
		    <input type="submit" value="Login" class="btn btn-primary"/>
		</form:form> 
		</div>
	</div>
</body>
</html>