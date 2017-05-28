<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="j_spring_security_check" method="post">
	
			Mail: <input type="text" name="j_username"/>
			<br/>
			
			Mot de passe: <input type="text" name="j_password"/>
			
			<br/>
			<input type="submit" value="se connecter">

	</form>

<c:if test="${not empty erreur}">
<h1 style="color: red">Login ou mot de passe incorrect</h1>
</c:if>

</body>
</html>