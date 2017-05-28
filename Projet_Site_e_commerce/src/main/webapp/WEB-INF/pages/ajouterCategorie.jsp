<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter catégorie</title>
</head>
<body>

<h1>Formulaire d'ajout</h1>
	<form:form action="insererCategorie" method="POST" modelAttribute="mCategorie" enctype="multipart/form-data">
		<form:input type="hidden" path="id" />
		<br />
Nom: <form:input path="nom" />
Description <form:input path="description" />
Photo <input type="file" name="file"/>

		<input value="Ajouter" type="submit">
	</form:form>

<br/>
<a href="<c:url value="/j_spring_security_logout"/>">Se deconnecter</a>
</body>
</html>