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
<title>Expense</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body style="d-flex">

	<!--  right click index.jsp on package explorer then Open With then external apps, then VS code source file and all changes made their will update here. -->

	<div class="container d-flexbox"> 
	<h1>Save Travels</h1>
	<table class="table table-dark table-hover">
            <thead>
                <tr>
                    <th class="align-middle">Expense</th>
                    <th class="align-middle">Vendor</th>
                    <th class="align-middle">Amount</th>
                    <th class="align-middle">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${allExpenses}" var="i">
                    <tr>
                        <td> <a href="/oneExpense/${i.id}"><c:out value="${i.expenseName}"></c:out></a></td>
                        <td><c:out value="${i.vendor}"></c:out></td>
                        <td><c:out value="${i.amount}"></c:out></td>
                        <td><a href="/editExpense/${i.id}">Edit</a> | <a href="/delete/${i.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
	
	</div>
    <div class="container d-flex" style="gap:20px; width: 60%"> <!-- Beginning of Container -->
        <h2>Add an Expense: </h2>
        <h4>Description must not be blank</h4>
        
        <form:form action="/processExpense" method="post" modelAttribute="expense">
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
    </div> <!-- End of Container -->
</body>
</html>


