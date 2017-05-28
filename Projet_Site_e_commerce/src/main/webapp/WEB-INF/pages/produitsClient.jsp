<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produits</title>
</head>
<body>
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
					href="${pageContext.request.contextPath}/site/ajouterPanier/${produit.id}/${idCat}">Ajouter
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
					href="${pageContext.request.contextPath}/site/supprimerProduitPanier/${idCat}/${ligne.id}">Supprimer</a>|
					<a
					href="${pageContext.request.contextPath}/site/ajouterPanier/${ligne.produit.id}/${idCat}">
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
</body>
</html>