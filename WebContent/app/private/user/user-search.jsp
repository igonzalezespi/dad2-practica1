<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.ucam.internal.user.User"%>
<%@ page import="java.util.Hashtable"%>
<%@ page import="java.util.Enumeration"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../../libs.jsp" %>

<title>Fincas UCAM</title>
<style>
	table, table-title {
	    width: 500px;
	    margin: 0 auto;
	    margin-bottom: 20px;
    }
    
    .table-title {
        height: 40px;
    	line-height: 40px;
    	text-align: center;
    	font-size: 30px;
    }
</style>
</head>
<body>
<%@include file="../parts/header.jsp" %>

<div class="table-title">
	Usuarios
</div>
<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
  <thead>
    <tr>
      <th class="mdl-data-table__cell--non-numeric"
      	  style="width: 30%;">
      	  Login
      </th>
      <th class="mdl-data-table__cell--non-numeric"
      	  style="width: 30%;">
      	  Nombre
      </th>
      <th class="mdl-data-table__cell--non-numeric"
      	  style="width: 40%;">
      	  Apellidos
      </th>
      <th class="mdl-data-table__cell--non-numeric">
      	<a class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored"
      	   href="<%= request.getContextPath() %>/api/private/user/views/user-edit">
      	  <i class="material-icons">add</i>
      	</a>
      </th>
    </tr>
  </thead>
  <tbody>
  	<%
  		Hashtable<Number,User> list = request.getSession(false).getAttribute("list") != null ? (Hashtable<Number,User>) request.getSession(false).getAttribute("list") : null;
  		if (list != null && list.size() > 0) {
			Enumeration<Number> i = list.keys();
	  		Number id;
	  		User user;

	  		while(i.hasMoreElements()) {
	  			id = (Number) i.nextElement();
	  			user = list.get(id);
	  		    out.println("<tr><td class=\"mdl-data-table__cell--non-numeric\">" + user.getLogin() +
	  		    		"</td><td class=\"mdl-data-table__cell--non-numeric\">" + user.getName() + 
  		 	     		"</td><td class=\"mdl-data-table__cell--non-numeric\">" + user.getSurname() + 
  		 	     		"</td><td class=\"mdl-data-table__cell--non-numeric\">" +
  		  		 	     		"<a class=\"mdl-button mdl-js-button mdl-button--icon mdl-button--colored\" href=\"" + request.getContextPath() + 
  		  		 	     		"/api/private/user/views/user-edit?id=" + id + "\"><i class=\"material-icons\">edit</i></a>"+
  		  		 	     		"<a class=\"mdl-button mdl-js-button mdl-button--icon\" style=\"color: #ce3a3a;\" href=\"" + request.getContextPath() + 
  		  		 	     		"/api/private/user/actions/remove?id=" + id + "\"><i class=\"material-icons\">delete</i></a>"+
  		  		 	     		"</td></tr>");
	  		}
  		} else {
  			out.println("<tr><td colspan=\"4\" style=\"text-align: center; font-style: italic;\">No se encontraron datos</td></tr>");
  		}
  	%>
  </tbody>
</table>

<%@include file="../parts/footer.jsp" %>
</body>
</html>