<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Client</title>
<%--  <link rel="stylesheet" href='<c:url value=""/>' /> --%>
</head>

<body>
	<table>
		<tr>
			<th>Nom</th>
		</tr>
		<c:forEach var="categorie" items="${listeCats}">
			<tr>
				<td><a
					href="${pageContext.request.contextPath}/site/produitsClient/${categorie.id}">${categorie.nom}</a></td>

			</tr>
		</c:forEach>
	</table>
	Client:
	<a href="${pageContext.request.contextPath}/site/">Inscription</a>
	Client:
	<a href="${pageContext.request.contextPath}/site/">Se connecter</a>
	Admin:
	<a href="${pageContext.request.contextPath}/site/admin/categories">
		Se connecter </a>

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
					href="${pageContext.request.contextPath}/site/supprimerProduitPanierAccueil/${ligne.id}">Supprimer</a>|
					<a
					href="${pageContext.request.contextPath}/site/ajouterPanier/${ligne.produit.id}/${idCat}">
						+1</a></td>
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
</body>
</html>