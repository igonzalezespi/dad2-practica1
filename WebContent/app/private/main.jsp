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
	
	a {
		text-decoration: none;
	}
</style>
<script>
	var goBack = function() {
		location.replace(location.origin + <%=request.getContextPath()%> + "/app/public/login.jsp");
	}
</script>
</head>
<body style="height:100%; width:100%">
<%@include file="./parts/header.jsp" %>
<div class="main-menu mdl-list"
	 style="width: 400px; margin: 0 auto;">
  	<a class="mdl-list__item"
  	   href="<%=request.getContextPath()%>/api/private/crop/views/crop-search">
	    <span class="mdl-list__item-primary-content">
	      Cultivos
	    </span>
    </a>
  	<a class="mdl-list__item"
  	   href="<%=request.getContextPath()%>/api/private/farm/views/farm-search">
	    <span class="mdl-list__item-primary-content">
	      Fincas
	    </span>
    </a>

  <%
  	if (AuthService.isAdmin(request)) {
  		out.println(
  			"<a class=\"mdl-list__item\" href=\"" + request.getContextPath() + "/api/private/user/views/user-search\">" +
  			"  	<span class=\"mdl-list__item-primary-content\">" +
	        "   	Usuarios" +
	        "  	</span>" +
	  		"</a>"
	  	);
  	}
  %>
</div>
<%@include file="./parts/footer.jsp" %>

</body>
</html>