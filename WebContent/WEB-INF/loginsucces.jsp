<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>connexion réussis</title>
</head>
<body>
<%@ include file="header.jsp"  %>

	<h1>Bienvenue <c:out value="${pseudo}"></c:out></h1>
	
	<footer><%@ include file="footer.jsp" %></footer>
</body>
</html>