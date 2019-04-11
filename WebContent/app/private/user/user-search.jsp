<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../../libs.jsp" %>

<title>Fincas UCAM</title>
<style>
	table, .table-actions {
	    width: 500px;
	    margin: 0 auto;
	    margin-bottom: 20px;
    }
</style>
</head>
<body>
<%@include file="../parts/header.jsp" %>

<div class="table-actions"
	 style="display: flex; flex-direction: row;">
	<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored"
			style="flex: 0 0 90px;">
		Añadir
	</button>
	<div class="table-title"
		 style="flex: 1; text-align: center; line-height: 36px; font-size: 30px;">
		Usuarios
	</div>
	<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
			style="flex: 0 0 90px;">
		Borrar
	</button>
</div>
<table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
  <thead>
    <tr>
      <th class="mdl-data-table__cell--non-numeric"
      	  style="width: 100%;">
      	  Nombre
      </th>
    </tr>
  </thead>
  <tbody>
    <tr><td class="mdl-data-table__cell--non-numeric">Judith</td></tr>
    <tr><td class="mdl-data-table__cell--non-numeric">Nolan</td></tr>
    <tr><td class="mdl-data-table__cell--non-numeric">Madeline</td></tr>
    <tr><td class="mdl-data-table__cell--non-numeric">Iván</td></tr>
  </tbody>
</table>

<%@include file="../parts/footer.jsp" %>
</body>
</html>