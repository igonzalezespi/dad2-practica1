<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.ucam.internal.user.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../../libs.jsp"%>

<title>Fincas UCAM</title>
</head>
<body style="height:100%; width:100%">
	<%@include file="../parts/header.jsp"%>

	<%
		User user = request.getSession(false).getAttribute("element") != null
				? (User) request.getSession(false).getAttribute("element")
				: new User();
	%>
	<br>
	<form
		action="<%=request.getContextPath()%>/api/private/user/actions/<%=user.getId() == null ? "insert" : "update"%>"
		method="POST">
		<div class="mdl-card mdl-shadow--2dp" style="margin: 0 auto;">
			<div class="mdl-card__title">
				<h2 class="mdl-card__title-text"><%=user.getId() == null ? "Nuevo usuario" : ("Editando: " + user.getName() + " " + user.getSurname())%></h2>
			</div>
			<div class="mdl-card__supporting-text">
				<input style="display: none;" type="number" id="id" name="id"
					value="<%=user.getId()%>">
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="text" id="login"
						name="login" value="<%=user.getLogin()%>" required> <label
						class="mdl-textfield__label" for="user">Login *</label>
				</div>
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="text" id="name"
						name="name" value="<%=user.getName()%>"> <label
						class="mdl-textfield__label" for="user">Nombre</label>
				</div>
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="text" id="surname"
						name="surname" value="<%=user.getSurname()%>"> <label
						class="mdl-textfield__label" for="user">Apellidos</label>
				</div>
			</div>
			<div class="mdl-card__actions mdl-card--border">
				<button
					class="save mdl-button mdl-button--raised mdl-button--colored mdl-js-button mdl-js-ripple-effect"
					type="submit" style="width: 60%;">Guardar</button>
				<a class="cancel mdl-button mdl-js-button mdl-js-ripple-effect"
					href="<%=request.getContextPath()%>/api/private/user/views/user-search"
					style="width: 25%;"> Cancelar </a>
			</div>
		</div>
	</form>

	<script>
		setTimeout(function() {
			document.getElementById('login').select();
		}, 100);
	</script>
	<%@include file="../parts/footer.jsp"%>
</body>
</html>