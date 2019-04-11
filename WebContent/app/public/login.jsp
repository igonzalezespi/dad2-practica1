<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<form action="<%= request.getContextPath() %>/api/public/login" method="POST">
	<div>
		Usuario: <input type="text" name="user" value="" />
	</div>
	<div>
		Contraseña: <input type="password" name="password" value="" />
	</div>
	<button type="submit">Iniciar sesión</button>
</form>

<script>
  document.getElementById('usuario').focus();
</script>
</body>
</html>