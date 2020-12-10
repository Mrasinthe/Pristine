<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Customer Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: purple">
			<div>
				<a href="#" class="navbar-brand"> Customer Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link" style="color:yellow">Customers</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Customers</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success"
					style="background-color: darkblue">Add New Customer</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Email</th>
						<th>Address</th>
						<th>City</th>
						<th>State</th>
						<th>Zip Code</th>
						<th>Phone</th>
						<th>Mobile</th>
						<th>Birthday</th>
						<th>Phone2</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
			
					<c:forEach var="customer" items="${listCustomer}">

						<tr>
 							<td><c:out value="${customer.id}" /></td>
							<td><c:out value="${customer.fname}" /></td>
							<td><c:out value="${customer.lname}" /></td>
							<td><c:out value="${customer.email}" /></td>
							<td><c:out value="${customer.address}" /></td>
							<td><c:out value="${customer.city}" /></td>
							<td><c:out value="${customer.state}" /></td>
							<td><c:out value="${customer.zipcode}" /></td>
							<td><c:out value="${customer.phone}" /></td>
							<td><c:out value="${customer.mobile}" /></td>
							<td><c:out value="${customer.birthday}" /></td>
							<td><c:out value="${customer.phone2}" /></td>

							<td>
								<a href="edit?customerID=<c:out value='${customer.id}' />">Edit</a>
								<a href="delete?customerID=<c:out value='${customer.id}' />">Delete</a>
							</td> 
						</tr>
					</c:forEach>
				
				</tbody>

			</table>
		</div>
	</div>
</body>

</html>