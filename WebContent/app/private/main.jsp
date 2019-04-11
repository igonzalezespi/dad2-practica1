<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.ucam.internal.auth.AuthService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../libs.jsp" %>

<title>Fincas UCAM</title>
<style>
	.mdl-list__item:hover {
		background-color: rgb(226, 231, 255);
    	border-radius: 6px;
    	cursor: pointer;
	}
	
	a.mdl-list__item {
		text-decoration: none;
	}
</style>
</head>
<body>
<%@include file="./parts/header.jsp" %>
<div>
	<ul class="main-menu mdl-list"
		style="width: 400px; margin: 0 auto;">
	  <li class="mdl-list__item">
	    <span class="mdl-list__item-primary-content">
	      Cultivos
	    </span>
	  </li>
	  <li class="mdl-list__item">
	    <span class="mdl-list__item-primary-content">
	      Fincas
	    </span>
	  </li>
	  <%
	  	if (AuthService.isAdmin(request)) {
	  		out.println(
	  			"<a class=\"mdl-list__item\"" +
	  		  	"    href=\"" + request.getContextPath() + "/app/private/user/user-search.jsp\">" +
	  			"  <span class=\"mdl-list__item-primary-content\">" +
		        "    Usuarios" +
		        "  </span>" +
		  		"</a>"
		  	);
	  	}
	  %>
	</ul>
</div>
<%@include file="./parts/footer.jsp" %>
</body>
</html>