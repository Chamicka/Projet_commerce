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
				<td><a href="${pageContext.request.contextPath}/site/produitsClient/${categorie.id}">${categorie.nom}</a></td>
				
			</tr>
		</c:forEach>
	</table>
Admin: <a href="${pageContext.request.contextPath}/site/admin/categories"> Se connecter </a>
</body>
</html>