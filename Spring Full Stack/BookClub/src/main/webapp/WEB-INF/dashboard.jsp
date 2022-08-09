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
<title>Dashboard</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body class="container d-flexbox">
	<div style="display: flex; align-items: center; justify-content: space-between;">
		<h1 style="color: green;" >Welcome, ${userName}</h1>
		<a href="/logout">Logout</a>
	</div>
	<div style="display: flex; align-items: center; justify-content: space-between;">
		<p>Books from everyones shelves!</p>
		<p><a href="/books/new">Add a book to your shelf</a></p>
	</div>
	<div class="container d-flexbox"> 
		<table class="table table-dark table-hover">
            <thead>
                <tr>
                    <th class="align-middle">ID</th>
                    <th class="align-middle">Title</th>
                    <th class="align-middle">Author Name</th>
                    <th class="align-middle">Posted By</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${allBooks}" var="i">
                    <tr>
                        <td> <c:out value="${i.id}"></c:out></td>
                        <td><a href="/books/${i.id}"><c:out value="${i.title}"></c:out></a></td>
                        <td><c:out value="${i.author}"></c:out></td>
                        <td><c:out value="${i.user.userName}"></c:out></td>                 
                    </tr>
                </c:forEach>
            </tbody>
        </table>
	</div>
</body>
</html>