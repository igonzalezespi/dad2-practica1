<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../libs.jsp" %>

<title>�Cerrar sesi�n?</title>
</head>
<body>
	Ya ha iniciado sesi�n. �Desea <a href="<%= request.getContextPath() %>/api/private/logout">cerrar sesi�n</a>
	 o <a href="<%= request.getContextPath() %>/app/private/main.jsp">volver</a>?
</body>
</html>