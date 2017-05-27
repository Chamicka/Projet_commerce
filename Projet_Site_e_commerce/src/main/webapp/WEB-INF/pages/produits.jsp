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
				<td><a href="${pageContext.request.contextPath}/site/supprimerProduit/${produit.id}">Supprimer</a>  | <a href="${pageContext.request.contextPath}/site/modifierProduit?idP=${produit.id}"> Editer</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="${pageContext.request.contextPath}/site/admin/categories">Accueil</a>
	<a href="${pageContext.request.contextPath}/site/admin/ajouterProduit?idC=${idCat}">Ajouter un produit</a>
	<a href="${pageContext.request.contextPath}/site/admin/supprimerProduit">Supprimer un produit</a>
	<a href="${pageContext.request.contextPath}/site/admin/modifierProduit">Modifier un produit</a>
	
	<br/>
	<a href="<c:url value="/j_spring_security_logout"/>">Se deconnecter</a>
</body>
</html>