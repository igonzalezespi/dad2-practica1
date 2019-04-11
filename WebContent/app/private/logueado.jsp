<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../libs.jsp" %>

<title>¿Cerrar sesión?</title>
</head>
<body>
	Ya ha iniciado sesión. ¿Desea <a href="<%= request.getContextPath() %>/api/private/logout">cerrar sesión</a>
	 o <a href="<%= request.getContextPath() %>/app/private/main.jsp">volver</a>?
</body>
</html>