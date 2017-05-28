<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription</title>
</head>
<body>

<h1>Informations personnelles</h1>
	<form:form action="" method="POST" modelAttribute="">
		<form:input type="hidden" path="id" />
		<br />
Nom: <form:input path="nom" />
Adresse: <form:input path="adresse" />
Mail :<form:input path="mail" />
Telephone <form:input path="tel" />
		<input value="Inscription" type="submit">
	</form:form>

</body>
</html>