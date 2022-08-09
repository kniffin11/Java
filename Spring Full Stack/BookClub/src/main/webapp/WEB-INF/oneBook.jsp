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
<title>One Book</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div style="display: flex; align-items: center; justify-content: space-between;">
			<h2><i>${book.title}</i></h2>
			<a href="/books">back to the shelves</a>
		</div>
		<div>
			<% if(session.getAttribute("userName").equals("${book.user.userName}")){ %>
				<h4>You read ${book.title} by ${book.author}.</h4>
			<% }else{ %>
				<h4>${book.user.userName} read ${book.title} by ${book.author}.</h4>
			<% } %>
			<br>
			<h4>Here are ${book.user.userName}'s thoughts: </h4>
			<br>
			<p><i>${book.myThoughts}</i></p>
			<br>
			<% if(session.getAttribute("userName").equals("${book.user.userName}")){ %>
				<a href="/book/${book.id}/edit">Edit</a>
			<% } %>
		</div>
	</div>
</body>
</html>