<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Demo web site</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/fontawesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/solid.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/brands.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/v5-font-face.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarColor02"
				aria-controls="navbarColor02" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarColor02">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link active" href="#">Home
							<span class="visually-hidden">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Features</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Pricing</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
						href="#" role="button" aria-haspopup="true" aria-expanded="false">Dropdown</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a> <a
								class="dropdown-item" href="#">Something else here</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Separated link</a>
						</div></li>
				</ul>
				<div class="btn-group">
					<button type="button" class="btn btn-secondary dropdown-toggle"
						data-toggle="dropdown" aria-expanded="false">

						<i class="fa fa-user"></i>
						<!-- user.username -->
						<security:authentication property="principal.username" />
						<!-- user.roles -->
						(
						<security:authentication property="principal.authorities" />
						)
					</button>
				</div>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<h1 class="text-danger">Hello mec</h1>

			<security:authorize access="hasRole('ADMIN')">
				<a href="${pageContext.request.contextPath}/admin">Administration</a>
			</security:authorize>
			<security:authorize access="hasRole('MANAGER')">
				<a href="${pageContext.request.contextPath}/manager">Manager</a>
			</security:authorize>
			<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">
				<button type="submit" class="btn btn-dark" value="logout">Logout</button>
			</form:form>
		</div>
	</div>

	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/fontawesome.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/solid.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/brands.min.js"></script>
</body>
</html>