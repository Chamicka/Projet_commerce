<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Client</title>
<link href="<c:url value="/resource/bootstrap.css"/>" rel="stylesheet">
<link href="<c:url value="/resource/MyStyle.css"/>" rel="stylesheet">
<link href="<c:url value="/resource/tables.css"/>" rel="stylesheet">
</head>

<body>
	<%@include file="/WEB-INF/templates/header.jsp"%>

	<div>
		<c:forEach var="categorie" items="${listeCats}">
			<div style="display: inline-block; margin: 30px; width: 20%;">
				<a
					href="${pageContext.request.contextPath}/site/produitsClient/${categorie.id}"><img
					src="${categorie.photo}" class="img-circle" width="304"
					height="236"></a>
			</div>
		</c:forEach>
	</div>
<br/>
<br/>

	Admin:
	<a href="${pageContext.request.contextPath}/site/admin/categories">
		Se connecter </a>

	<br />
	<br /> <h5 style="text-align:center; font-size: large; color:red">Panier</h5>
	<table class="table">
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
					href="${pageContext.request.contextPath}/site/ajouterPanierAccueil/${ligne.produit.id}">
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
	<%@include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>