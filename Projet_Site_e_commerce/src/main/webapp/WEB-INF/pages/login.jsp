<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resource/bootstrap.css"/>" rel="stylesheet">
<link href="<c:url value="/resource/login.css"/>" rel="stylesheet">
<link href="<c:url value="/resource/MyStyle.css"/>" rel="stylesheet">

</head>
<body>
<%@include file="/WEB-INF/templates/header.jsp" %>
	<section class="login-info" style="margin:100px;">
		<div class="container">
			<div class="row main">
				<div class="form-header">
					<h1 class="text-center ">Login</h1>
				</div>
				<div class="main-content">
					<form action="j_spring_security_check" method="post">
						<div class="input-group ">
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-envelope" aria-hidden="true"></span></span>
							<input id="email" type="text" class="form-control"
								name="j_username" placeholder="Entrez votre nom">
						</div>
						<div class="input-group">
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-lock" aria-hidden="true"></span></span> <input
								id="password" type="password" class="form-control"
								name="j_password" placeholder="Entrez votre mot de passe">
						</div>

						<div class="checkbox">
							<label class="remember"> <input name="remember"
								type="checkbox"> Remember Me
							</label>
						</div>

						<div class="form-group ">
							<input type="submit"
								class="btn btn-danger btn-lg btn-block login-button" value="Se connecter">
						</div>
					</form>


				</div>
			</div>
		</div>
	</section>

<c:if test="${not empty erreur}">
		<h1 style="color: red; text-align: center">Login ou mot de passe incorrect</h1>
	</c:if>
	<%@include file="/WEB-INF/templates/footer.jsp" %>
</body>
</html>