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
<title>Home</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body class="container d-flexbox">
	<div style="display: flex; align-items: center; justify-content: space-between; padding: 10px;gap:10px;'">
		<h1 style="color: orange;">Hello, ${userName}. Here are some name suggestions.</h1>
		<a href="/logout">Logout</a>
	</div>
	<div class="container d-flexbox" style="padding: 10px;"> 
		<h3>Baby Names</h3>
		<table class="table table-hover">
            <tbody>
                <c:forEach items="${allJoyBundles}" var="i">
                    <tr>
                        <td><a href="/names/${i.id}"><c:out value="${i.name}"></c:out></a></td>
                        <td><c:out value="${i.gender}"></c:out></td>
                        <td>Origin: <c:out value="${i.origin}"></c:out></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="/names/new">New Name</a>
	</div>
</body>
</html>