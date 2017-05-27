<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter produit</title>
</head>
<body>

<h1>Formulaire d'ajout</h1>
	<form:form action="insererProduit/${idCat}" method="POST" modelAttribute="mProduit">
		<form:input type="hidden" path="id" />
		<form:input type="hidden" path="categorie.id" value="${idCat}" />
		<br />
Designation: <form:input path="designation" />
Description: <form:input path="description" />
Prix: <form:input path="prix" />
		<input value="Ajouter" type="submit">
	</form:form>

<br/>
<a href="<c:url value="/j_spring_security_logout"/>">Se deconnecter</a>
</body>
</html>