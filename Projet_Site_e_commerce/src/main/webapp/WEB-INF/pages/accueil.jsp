<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
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
    <a href="${pageContext.request.contextPath}/site/admin/ajouterCategorie" class="btn btn-primary btn-xs pull-right"><b>+</b> Ajouter une categorie</a>
       <tr>
			<th>Nom</th>
			<th>Photo</th>
			<th>Description</th>
			<th>Action</th>
		</tr>
    </thead>
           	<c:forEach var="categorie" items="${listeCats}">
			<tr>
				<td><a
					href="${pageContext.request.contextPath}/site/admin/produits/${categorie.id}">${categorie.nom}</a></td>
				<td><img src="${categorie.photo}" class="img-circle"
					width="150" height="100"></td>
				<td>${categorie.description}</td>
                <td class="text-center"><a class='btn btn-info btn-xs' href="${pageContext.request.contextPath}/site/admin/supprimerCategorie/${categorie.id}"><span class="glyphicon glyphicon-edit"></span> Supprimer</a> <a href="${pageContext.request.contextPath}/site/admin/modifierCategorie?idC=${categorie.id}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Modifier</a></td>
            </tr>
            	</c:forEach>
    </table>
    </div>
</div>

	<br />
	<br />
	<br />
	<a href="<c:url value="/j_spring_security_logout"/>">Se deconnecter</a>
	<%@include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>