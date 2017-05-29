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
			<th>description</th>
			<th>prix</th>
		</tr>
		<c:forEach var="produit" items="${listeProds}">
			<tr>
				<td>${produit.designation}</td>
				<td>${produit.description}</td>
				<td>${produit.prix}</td>
				<td><a
					href="${pageContext.request.contextPath}/site/ajouterPanier/${produit.id}">Ajouter
						au panier</a>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br /> Panier
	<table>
		<tr>
			<th>Produit</th>
			<th>Quantite</th>
			<th>Prix</th>
			<th>Modifier</th>
		</tr>
		<c:forEach var="ligne" items="${listeLignes}">
			<tr>
				<td>${ligne.produit.designation}</td>
				<td>${ligne.quantite}</td>
				<td>${ligne.prix}</td>
				<td><a
					href="${pageContext.request.contextPath}/site/supprimerProduitPanier/${ligne.id}">Supprimer</a>|
					<a
					href="${pageContext.request.contextPath}/site/ajouterPanier/${ligne.produit.id}">
						+1</a></td>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<table>
		<tr>
			<th>Total</th>
		</tr>
		<tr>
			<td>${total}</td>
		</tr>
	</table>
	<h1>
		<a href="${pageContext.request.contextPath}/site/welcome">ACCUEIL</a>
	</h1>
		<%@include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>