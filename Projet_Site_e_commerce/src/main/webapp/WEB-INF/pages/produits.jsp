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
    <a href="${pageContext.request.contextPath}/site/admin/ajouterProduit?idC=${idCat}" class="btn btn-primary btn-xs pull-right"><b>+</b> Ajouter un produit</a>
       <tr>
			<th>Designation</th>
			<th>Photo</th>
			<th>Description</th>
			<th>Disponible</th>
			<th>Prix</th>
			<th>Action</th>
		</tr>
    </thead>
           	<c:forEach var="produit" items="${listeProds}">
			<tr>
				<td>${produit.designation}</td>
				<td><img src="${produit.photo}" class="img-circle"
					width="150" height="100"></td>
				<td>${produit.description}</td>
				<td>${produit.quantite}</td>
				<td>${produit.prix}</td>
                <td class="text-center"><a class='btn btn-info btn-xs' href="${pageContext.request.contextPath}/site/admin/supprimerProduit/${produit.id}"><span class="glyphicon glyphicon-edit"></span> Supprimer</a> <a href="${pageContext.request.contextPath}/site/admin/modifierProduit?idP=${produit.id}&idC=${produit.categorie.id}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Modifier</a></td>
            </tr>
            	</c:forEach>
    </table>
    </div>
</div>

	
<div style="width: 400px;"><a class="btn btn-info" href="${pageContext.request.contextPath}/site/admin/categories" role="button">Accueil</a>
	</div>
		
	<div style="width: 400px;"><a class="btn btn-info" href="<c:url value="/j_spring_security_logout"/>" role="button">Se déconnecter</a>
	</div>
		<%@include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>