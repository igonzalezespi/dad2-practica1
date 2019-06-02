<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.ucam.internal.crop.Crop"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../../libs.jsp"%>

<title>Fincas UCAM</title>
<style>
	.mdl-card__actions .cancel {
		width: 50px;
	}
</style>
</head>
<body style="height:100%; width:100%">
	<%@include file="../parts/header.jsp"%>

	<%
		Crop crop = request.getSession(false).getAttribute("element") != null
				? (Crop) request.getSession(false).getAttribute("element")
				: new Crop();
	%>
	<br>
	<form
		action="<%=request.getContextPath()%>/api/private/crop/actions/<%=crop.getId() == null ? "insert" : "update"%>"
		method="POST">
		<div class="mdl-card mdl-shadow--2dp" style="margin: 0 auto;">
			<div class="mdl-card__title">
				<h2 class="mdl-card__title-text"><%=crop.getId() == null ? "Nuevo cultivo" : ("Editando: " + crop.getName())%></h2>
			</div>
			<div class="mdl-card__supporting-text">
				<input style="display: none;" type="number" id="id" name="id"
					value="<%=crop.getId()%>">
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="text" id="name"
						name="name" value="<%=crop.getName()%>"> <label
						class="mdl-textfield__label" for="crop">Nombre</label>
				</div>
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="number" id="size"
						name="size" value="<%=crop.getSize()%>"> <label
						class="mdl-textfield__label" for="crop">Tamaño (Hectáreas)</label>
				</div>
			</div>
			<div class="mdl-card__actions mdl-card--border">
				<button
					class="save mdl-button mdl-button--raised mdl-button--colored mdl-js-button mdl-js-ripple-effect"
					type="submit" style="width: 60%;">Guardar</button>
				<a class="cancel mdl-button mdl-js-button mdl-js-ripple-effect"
					href="<%=request.getContextPath()%>/api/private/crop/views/crop-search"
					style="width: 25%;"> Cancelar </a>
			</div>
		</div>
	</form>

	<script>
		setTimeout(function() {
			document.getElementById('name').select();
		}, 100);
	</script>
	<%@include file="../parts/footer.jsp"%>
</body>
</html>