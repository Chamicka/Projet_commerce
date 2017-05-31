<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Client</title>
<link href="<c:url value="/resource/bootstrap.css"/>" rel="stylesheet">
<link href="<c:url value="/resource/MyStyle.css"/>" rel="stylesheet">
<link href="<c:url value="/resource/tables.css"/>" rel="stylesheet">
<link href="<c:url value="/resource/navbar.css"/>" rel="stylesheet">
</head>

<body>
	<%@include file="/WEB-INF/templates/header.jsp"%>
	<div style="float:right; width: 25%">
		<h5
			style="font-size: large; color: red; width: 100%; text-align: center">Panier</h5>
		<table class="table table-hover" style="width: 100%">
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
							+1</a>| <a
						href="${pageContext.request.contextPath}/site/moinsProduitPanierAccueil/${ligne.produit.id}">
							-1</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<br />
		<table class="table table-hover" style="width: 100%; text-align: center" >
			<tr>
				<th style="text-align:center">Total</th>
			</tr>
			<tr>
				<td>${total}</td>
			</tr>
		</table>
	</div>
	<div style="width: 400px; float:right"><a class="btn btn-info" href="${pageContext.request.contextPath}/site/client/validerCommande" role="button">Valider la commande</a>
	<h3>${msg}</h3>
	</div>
	<div>
		<c:forEach var="categorie" items="${listeCats}">
			<div
				style="display: inline-block; margin: auto; margin: 50px; width: 230px; position: relative; padding: 10px">
				<a
					href="${pageContext.request.contextPath}/site/produitsClient/${categorie.id}"><img
					src="${categorie.photo}" class="img-circle" width="200"
					height="150"></a> <br />
				<h6 style="text-align: center; font-size: large;">${categorie.nom}</h6>
			</div>
		</c:forEach>
	</div>

	<form:form action="trouverByKeyWord" method="POST" modelAttribute="word">
		Rechercher un produit: <form:input path="${word}" />
		<input value="Rechercher" type="submit">
	</form:form>
	
	<%@include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>