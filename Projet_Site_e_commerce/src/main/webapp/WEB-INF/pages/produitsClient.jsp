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
	
	<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
    <table class="table table-striped custab">
    <thead>
    <br/>
    <br/>
       <tr>
			<th>Designation</th>
			<th>Photo</th>
			<th>Description</th>
			<th>Prix</th>
			<th>Action</th>
		</tr>
    </thead>
           	<c:forEach var="produit" items="${listeProds}">
			<tr>
				<td>${produit.designation}</td>
				<td><img src="${produit.photo}" class="img-circle" width="200"
					height="150"></td>
				<td>${produit.description}</td>
				<td>${produit.prix}</td>
				<td><a
					href="${pageContext.request.contextPath}/site/ajouterPanier/${produit.id}">Ajouter
						au panier</a>
				</tr>
            	</c:forEach>
    </table>
    </div>
</div>
	
	
	
	<br />
	<br />
	
		<div> <h5 style="font-size: large; color:red;width: 25%; text-align: center">Panier</h5>
	<table class="table table-hover" style="width: 25%">
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
						+1</a>|
					<a
					href="${pageContext.request.contextPath}/site/moinsProduitPanier/${ligne.produit.id}">
						-1</a></td>
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
	</div>
	
	<div style="width: 400px;"><a class="btn btn-info" href="${pageContext.request.contextPath}/site/welcome" role="button">Accueil</a>
	</div>


	<%@include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>