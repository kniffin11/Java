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
<title>Fruit Store</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/styleIndex.css">
</head>
<body>
	<nav class="center-it"><h1>Send an Omikuji!</h1></nav>
	<div class="center-it">
		<div class="box center-it">
			<form action="/info" method="post">
				<label for="num">Pick any number from 5 to 25.</label>
				<br>
				<select name="num">
					<% for(int i = 5; i < 26; i++){ %>
					<option><%= i %></option>
					<% } %>
				</select>
				<br>
				<label for="cityName" class="form-label">Enter the name of any city.</label>
				<input type="text" name="cityName" class="form-control"></input>
				<label for="person" class="form-label">Enter the name of any real person.</label>
				<input type="text" name="person" class="form-control"></input>
				<label for="hobby" class="form-label">Enter professional endeavor or hobby.</label>
				<input type="text" name="hobby" class="form-control"></input>
				<label for="livingThing" class="form-label">Enter any type of living thing.</label>
				<input type="text" name="livingThing" class="form-control"></input>
				<label for="compliment" class="form-label">Say something nice to someone.</label>
				<input type="text" name="compliment" class="form-control"></input>
				<label class="form-label">Send and show a friend</label>
				<br>
				<input type="submit" value="Send"></input>
			</form>
		</div>
	</div>
</body>
</html>