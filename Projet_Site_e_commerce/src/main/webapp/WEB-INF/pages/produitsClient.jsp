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
				<td><a href="${pageContext.request.contextPath}/site/ajouterPanier/${produit.id}/${mPanier}">Ajouter au panier</a>
				
			</tr>
		</c:forEach>
	</table>
	

</body>
</html>