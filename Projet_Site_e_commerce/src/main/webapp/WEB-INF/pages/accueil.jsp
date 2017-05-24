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
				<td><a href="${pageContext.request.contextPath}/site/produits">${categorie.nom}</a></td>
				<td><a href="${pageContext.request.contextPath}/site/supprimerCategorie/${categorie.id}">Supprimer</a>  | <a href="${pageContext.request.contextPath}/site/modifierCategorie?idC=${categorie.id}"> Modifier</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="${pageContext.request.contextPath}/site/ajouterCategorie">Ajouter une catégorie</a>
	<a href="${pageContext.request.contextPath}/site/supprimerCategorie">Supprimer une catégorie</a>
	<a href="${pageContext.request.contextPath}/site/modifierCategorie">Modifier une catégorie</a>
</body>
</html>