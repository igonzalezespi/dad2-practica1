<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error iniciando sesi�n</title>
</head>
<body>
	<p>El usuario o contrase�a no es correcto.</p>
	<a href="<%= request.getContextPath() %>/app/public/login.jsp">Int�ntelo de nuevo</a>
</body>
</html>