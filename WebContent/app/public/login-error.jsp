<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../libs.jsp" %>

<title>Error iniciando sesión</title>
</head>
<body>
		<div class="mdl-card mdl-shadow--2dp"
			 style="margin: 0 auto; transform: translateY(50%);">
		  <div class="mdl-card__title">
		    <h2 class="mdl-card__title-text">Error iniciando sesión</h2>
		  </div>
		  <div class="mdl-card__supporting-text">
			<p>El usuario o contraseña no es correcto.</p>
		  </div>
		  <div class="mdl-card__actions mdl-card--border"
		  		style="text-align: center;">
		    <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
		   			href="<%= request.getContextPath() %>/app/public/login.jsp"
		   			style="width: 90%;">
		      Inténtelo de nuevo
		    </a>
		  </div>
		</div>
</body>
</html>