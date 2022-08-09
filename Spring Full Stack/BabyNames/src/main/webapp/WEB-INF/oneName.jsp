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
<title>One Name</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
</head>
<body>
	<div class="container" >
		<div style="display: flex; align-items: center; justify-content: space-between; padding: 10px 0;'">
			<h2><i>${joyBundle.name}</i></h2>
			<a href="/home">Go Back</a>
		</div>
		<div>
			<h3>(Added by ${joyBundle.user.userName})</h3>
			<br>
			<h4>Gender: ${joyBundle.gender}</h4>
			<h4>Origin: ${joyBundle.origin}</h4>
			<p><i>Meaning: ${joyBundle.meaning}</i></p>
			<br>
			// you have to pass it in ass a model attribute then can use it here
			<c:choose>
				<c:when test="${joyBundle.user.id == userId}">
			<a href="/names/${joyBundle.id}/edit">Edit</a>
				</c:when>
			</c:choose>
			
		</div>
	</div>
</body>
</html>