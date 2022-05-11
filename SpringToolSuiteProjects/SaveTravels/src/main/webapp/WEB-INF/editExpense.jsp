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
    <h2 class="container">Make Changes to ${expense.expenseName}</h2>
	<div class="container d-flex" style="gap:20px; width: 60%"> <!-- Beginning of Container -->
        <!-- the post method is still needed in order to be sent out  -->
        <form:form action="/editedExpense/${expense.id}" method="post" modelAttribute="expense">
			<!-- this put allows us to update the entire object, instead of specific traits one by one  -->
			<input type="hidden" name="_method" value="put"/>
		    
		    <p>
		        <form:label path="expenseName">Expense Name: </form:label>
		        <form:errors path="expenseName"/>
		        <form:input path="expenseName"/>
		    </p>
		    <p>
		        <form:label path="vendor">Vendor: </form:label>
		        <form:errors path="vendor"/>
		        <form:input path="vendor"/>
		    </p>
		    <p>
		        <form:label path="amount">Amount: </form:label>
		        <form:errors path="amount"/>
		        <form:input type="number" step="0.01" path="amount"/>
		    </p>
		    <p>
		        <form:label path="description">Description: </form:label>
		        <form:errors path="description"/>     
		        <form:textarea path="description"/>
		    </p>    
		    <input type="submit" value="Submit"/>
		</form:form>  
	</div>
</body>
</html>