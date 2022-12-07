<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New User</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Username</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Age</th>
						<th>Nationality</th>
						<th>National Identity</th>
						<th>Functionality</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.idUser}" /></td>
							<td><c:out value="${user.username}" /></td>
							<td><c:out value="${user.firstName}" /></td>
							<td><c:out value="${user.lastName}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.phone}" /></td>
							<td><c:out value="${user.age}" /></td>
							<td><c:out value="${user.nationality}" /></td>
							<td><c:out value="${user.nationalIdentity}" /></td>
							<td><c:out value="${user.functionality}" /></td>
							<td><a href="edit?id=<c:out value='${user.idUser}' />">Edit</a>
								<a onclick="return confirm('Etes-vous sûr ?')" 
								   href="delete?id=<c:out value='${user.idUser}'/>">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>