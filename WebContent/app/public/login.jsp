<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.ucam.internal.auth.AuthService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../libs.jsp" %>

<title>Login</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/api/public/login"
		method="POST">
		<div class="mdl-card mdl-shadow--2dp"
			 style="margin: 0 auto; transform: translateY(50%);">
		  <div class="mdl-card__title">
		    <h2 class="mdl-card__title-text">Inicio de sesión</h2>
		  </div>
		  <div class="mdl-card__supporting-text">
			<div class="mdl-textfield mdl-js-textfield">
				<input class="mdl-textfield__input" type="text" id="user" name="user">
				<label class="mdl-textfield__label" for="user">Usuario</label>
			</div>
			<div class="mdl-textfield mdl-js-textfield">
				<input class="mdl-textfield__input" type="text" id="password" name="password">
				<label class="mdl-textfield__label" for="user">Contraseña</label>
			</div>
		  </div>
		  <div class="mdl-card__actions mdl-card--border"
		  		style="text-align: center;">
		    <button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
		   			type="submit"
		   			style="width: 90%;">
		      Entrar
		    </button>
		  </div>
		</div>
	</form>

	<%
		
	%>

	<script>
		setTimeout(function() {
			document.getElementById('user').focus();
		}, 100);
	</script>
</body>
</html>