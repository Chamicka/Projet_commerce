<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produits</title>
<link href="<c:url value="/resource/bootstrap.css"/>" rel="stylesheet">
<link href="<c:url value="/resource/MyStyle.css"/>" rel="stylesheet">
<link href="<c:url value="/resource/tables.css"/>" rel="stylesheet">
</head>
<body>
<%@include file="/WEB-INF/templates/header.jsp"%>
	<table>
		<tr>
			<th>designation</th>
			<th>Photo</th>
			<th>description</th>
			<th>prix</th>
		</tr>
		<c:forEach var="produit" items="${listeProds}">
			<tr>
				<td>${produit.designation}</td>
				<td><img src="${produit.photo}" class="img-circle"
					width="150" height="100"></td>
				<td>${produit.description}</td>
				<td>${produit.prix}</td>
				<td><a
					href="${pageContext.request.contextPath}/site/admin/supprimerProduit/${produit.id}">Supprimer</a>
					| <a
					href="${pageContext.request.contextPath}/site/admin/modifierProduit?idP=${produit.id}&idC=${produit.categorie.id}">
						Editer</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="${pageContext.request.contextPath}/site/admin/categories">Accueil</a>
	<a
		href="${pageContext.request.contextPath}/site/admin/ajouterProduit?idC=${idCat}">Ajouter
		un produit</a>

	<br />
	<a href="<c:url value="/j_spring_security_logout"/>">Se deconnecter</a>
		<%@include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>