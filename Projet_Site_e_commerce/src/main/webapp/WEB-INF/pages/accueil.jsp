<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
<%--  <link rel="stylesheet" href='<c:url value=""/>' /> --%>
</head>

<body>
	<table>
		<tr>
			<th>Nom</th>
		</tr>
		<c:forEach var="categorie" items="${listeCats}">
			<tr>
				<td><a href="${pageContext.request.contextPath}/site/admin/produits/${categorie.id}">${categorie.nom}</a></td>
				<td><a href="${pageContext.request.contextPath}/site/admin/supprimerCategorie/${categorie.id}">Supprimer</a>  | <a href="${pageContext.request.contextPath}/site/admin/modifierCategorie?idC=${categorie.id}"> Modifier</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="${pageContext.request.contextPath}/site/admin/ajouterCategorie">Ajouter une catégorie</a>

	<br/>
	<a href="<c:url value="/j_spring_security_logout"/>">Se deconnecter</a>
</body>
</html>