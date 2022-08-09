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
<title>Edit Name</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <h2 class="container">Add a name</h2>
	<div class="container d-flex" style="gap:20px;"> <!-- Beginning of Container -->
        <form:form action="/addedName" method="post" modelAttribute="joyBundle">		    
		    <input type="hidden" name="user" value="${userId}">
		    <p>
		        <form:label path="name">Name: </form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </p>
		    <p>
		        <form:label path="gender">Typical Gender: </form:label>
		    	<form:select path="gender">
		    		<form:option value="Male" >Male</form:option>
		    		<form:option value="Female" >Female</form:option>
		    		<form:option value="Nuetral" >Neutral</form:option>
		    	</form:select>
		    </p>
		    <p>
		        <form:label path="origin">Origin: </form:label>
		        <form:errors path="origin"/>
		        <form:input path="origin"/>
		    </p>
		    <p>
		        <form:label path="meaning">Meaning: </form:label>
		        <form:errors path="meaning"/>     
		        <form:textarea path="meaning"/>
		    </p>    
		    <div style="display: flex; justify-content: space-between;">
			    <input type="submit" value="Submit"/>
			    <a href="/cancel" class="btn">Cancel</a>
		    </div>
		</form:form>  
	</div>
</body>
</html>