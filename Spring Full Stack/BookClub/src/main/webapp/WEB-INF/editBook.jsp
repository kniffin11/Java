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
<title>Edit Book</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
	<div style="display: flex; align-items: center; justify-content: space-between;">
    	<h2 class="container">Make Changes to ${book.title}</h2>
		<a href="/books">Back to the shelves!</a>
	</div>
	<div class="container d-flex" style="gap:20px; width: 60%"> <!-- Beginning of Container -->
        <!-- the post method is still needed in order to be sent out  -->
        <form:form action="/editedBook/${book.id}" method="post" modelAttribute="book">
			<!-- this put allows us to update the entire object, instead of specific traits one by one  -->
			<input type="hidden" name="_method" value="put"/>
		    
		    <p>
		        <form:label path="title">Title: </form:label>
		        <form:errors path="title"/>
		        <form:input path="title"/>
		    </p>
		    <p>
		        <form:label path="author">Author: </form:label>
		        <form:errors path="author"/>
		        <form:input path="author"/>
		    </p>
		    <p>
		        <form:label path="myThoughts">My thoughts: </form:label>
		        <form:errors path="myThoughts"/>     
		        <form:textarea path="myThoughts"/>
		    </p>    
		    <input type="submit" value="Submit"/>
		</form:form>  
	</div>
</body>
</html>