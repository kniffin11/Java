<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- c:out ; c:forEach ; c:if -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Formatting (like dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Login or Register</title>
	<!-- Bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
		crossorigin="anonymous">

</head>

<body>
	<h1 style="color: orange; display: flex; justify-content: center;">Joy Bundler Names </h1>
	<div class="container"
		style="display:flex; justify-content: space-evenly; background-color: skyblue; border-radius: 2%; padding: 10px;">
		<div>
			<h1>Register</h1>
			<form:form action="/register" method="post" modelAttribute="newUser">
				<div class="form-group">
					<form:label path="userName">User Name: </form:label>
					<form:errors path="userName" />
					<form:input path="userName" class="form-control" />
				</div>
				<div class="form-group">
					<form:label path="email">Email: </form:label>
					<form:errors path="email" />
					<form:input path="email" class="form-control" />
				</div>
				<div class="form-group">
					<form:label path="password">Password: </form:label>
					<form:errors path="password" />
					<form:input path="password" class="form-control" />
				</div>
				<div class="form-group">
					<form:label path="confirm">Confirm Password: </form:label>
					<form:errors path="confirm" />
					<form:input path="confirm" class="form-control" />
				</div>
				<input type="submit" value="Register" class="btn btn-primary"
					style="margin: 10px 0;" />
			</form:form>
		</div>

		<div>
			<h1>Login</h1>
			<form:form action="/login" method="post" modelAttribute="newLogin">
				<div class="form-group">
					<form:label path="email">Email: </form:label>
					<form:errors path="email" />
					<form:input path="email" class="form-control" />
				</div>
				<div class="form-group">
					<form:label path="password">Password: </form:label>
					<form:errors path="password" />
					<form:input path="password" class="form-control" />
				</div>
				<input type="submit" value="Login" class="btn btn-primary"
					style="margin: 10px 0;" />
			</form:form>
		</div>
	</div>
</body>

</html>