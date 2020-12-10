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
					class="nav-link" style="color: yellow">Customers</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${customer != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${customer == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${customer != null}">
                                    Edit User
                                </c:if>
						<c:if test="${customer == null}">
                                    Add New User
                                </c:if>
					</h2>
				</caption>

				<c:if test="${customer != null}">
					<input type="hidden" name="customerID"
						value="<c:out value='${customer.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>First Name</label> <input type="text"
						value="<c:out value='${customer.fname}' />" class="form-control"
						name="fname" required="required"> 
				</fieldset>
				<fieldset class="form-group">
					<label>Last Name</label> <input type="text"
						value="<c:out value='${customer.lname}' />" class="form-control"
						name="lname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Email</label> <input type="email"
						value="<c:out value='${customer.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${customer.address}' />" class="form-control"
						name="address">
				</fieldset>
				<tr>

					<fieldset class="form-group">
						<label>City</label> <input type="text"
							value="<c:out value='${customer.city}' />" class="form-control"
							name="city">
					</fieldset>

					<fieldset class="form-group">
						<label>State</label> <input type="text"
							value="<c:out value='${customer.state}' />" class="form-control"
							name="state">
					</fieldset>

					<fieldset class="form-group">
						<label>Zip Code</label> <input type="text"
							value="<c:out value='${customer.zipcode}' />"
							class="form-control" name="zipcode">
					</fieldset>

				<fieldset class="form-group">
					<label>Phone</label> <input type="text"
						value="<c:out value='${customer.phone}' />" class="form-control"
						name="phone">
				</fieldset>

				<fieldset class="form-group">
					<label>Mobile</label> <input type="text"
						value="<c:out value='${customer.mobile}' />" class="form-control"
						name="mobile">
				</fieldset>

				<fieldset class="form-group">
					<label>Birthday</label> <input type="date"
						value="<c:out value='${customer.birthday}' />"
						class="form-control" name="birthday">
				</fieldset>

				<fieldset class="form-group">
					<label>Phone 2</label> <input type="text"
						value="<c:out value='${customer.phone2}' />" class="form-control"
						name="phone2">
				</fieldset>

				<button type="submit" class="btn btn-success"
					style="background-color: darkblue">Save</button>
				</form>
			</div>
		</div>
	</div>


</body>

</html>