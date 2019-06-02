<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.ucam.internal.farm.Farm"%>
<%@ page import="edu.ucam.internal.crop.Crop"%>
<%@ page import="java.util.Hashtable"%>
<%@ page import="java.util.Enumeration"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../../libs.jsp"%>

<title>Fincas UCAM</title>

<style>
.detail {
	margin: 5px;
}

.detail-title {
	font-size: 21px;
	margin-left: 11px;
}

table.mdl-data-table {
	border: none;
}

table.mdl-data-table td {
	border: none;
}

table tr th:first-child .mdl-checkbox {
	display: none;
}
</style>
</head>
<body style="height: 100%; width: 100%">
	<%@include file="../parts/header.jsp"%>

	<%
		Farm farm = request.getSession(false).getAttribute("element") != null
				? (Farm) request.getSession(false).getAttribute("element")
				: new Farm();
	%>
	<br>
	<form
		action="<%=request.getContextPath()%>/api/private/farm/actions/<%=farm.getId() == null ? "insert" : "update"%>"
		method="POST">
		<div class="mdl-card mdl-shadow--2dp" style="margin: 0 auto;">
			<div class="mdl-card__title">
				<h2 class="mdl-card__title-text"><%=farm.getId() == null ? "Nueva finca" : ("Editando: " + farm.getName())%></h2>
			</div>
			<div class="mdl-card__supporting-text">
				<input style="display: none;" type="number" id="id" name="id"
					value="<%=farm.getId()%>" /> <input style="display: none;"
					type="text" id="crops" name="crops"
					value="<%=farm.getCropsString()%>" />

				<div
					class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
					<input class="mdl-textfield__input" type="text" id="name"
						name="name" value="<%=farm.getName()%>"> <label
						class="mdl-textfield__label" for="name">Nombre</label>
				</div>
			</div>

			<div class=detail>
				<p class="detail-title">Cultivos</p>

				<table id="crops-table"
					class="mdl-data-table mdl-js-data-table mdl-data-table--selectable">
					<thead>
						<tr>
							<th class="mdl-data-table__cell--non-numeric" style="width: 50%;">
								Nombre</th>
							<th class="mdl-data-table__cell--numeric" style="width: 30%;">
								Tamaño</th>
						</tr>
					</thead>
					<tbody>
						<%
							Hashtable<Number, Crop> crops = request.getSession(false).getAttribute("crops") != null
									? (Hashtable<Number, Crop>) request.getSession(false).getAttribute("crops")
									: null;
							if (crops != null && crops.size() > 0) {
								Enumeration<Number> i = crops.keys();
								Number id;
								Crop crop = null;

								while (i.hasMoreElements()) {
									id = (Number) i.nextElement();
									crop = crops.get(id);
									out.println("<tr id=\"" + crop.getId() + "\"><td class=\"mdl-data-table__cell--non-numeric\">"
											+ crop.getName() + "</td><td class=\"mdl-data-table__cell--numeric\">"
											+ crop.getFormattedSize() + "</td></tr>");
								}
							} else {
								out.println(
										"<tr><td colspan=\"4\" style=\"text-align: center; font-style: italic;\">No se encontraron cultivos</td></tr>");
							}
						%>
					</tbody>
				</table>
			</div>
			<div class="mdl-card__actions mdl-card--border">
				<button
					class="save mdl-button mdl-button--raised mdl-button--colored mdl-js-button mdl-js-ripple-effect"
					type="submit" style="width: 60%;">Guardar</button>
				<a class="cancel mdl-button mdl-js-button mdl-js-ripple-effect"
					href="<%=request.getContextPath()%>/api/private/farm/views/farm-search"
					style="width: 25%;"> Cancelar </a>
			</div>
		</div>
	</form>

	<script>
		var crops = [];

		window.onload = function() {
			setTimeout(
					function() {
						document.getElementById('name').select();

						// Consultando cultivos de la finca y seleccionándolos
						if (document.getElementById('crops').value) {
							crops = document.getElementById('crops').value
									.split('-').map(function(val) {
										return Number(val)
									});
							for (var i = 0; i < crops.length; i++) {
								document.getElementById(crops[i])
										.getElementsByTagName('label')[0].classList
										.add("is-checked");
								document.getElementById(crops[i])
										.getElementsByTagName('input')[0].checked = true;
							}
						}

						// Guardando cambios en el FORM
						document
								.getElementById('crops-table')
								.addEventListener(
										'click',
										function(e) {
											var id;
											if (e.target.tagName.toLowerCase() === 'input'
													&& e.target.type
															.toLowerCase() === 'checkbox') {
												id = Number(e.target.parentElement.parentElement.parentElement.id);
												if (id) {
													if (e.target.checked) {
														add(id);
													} else {
														remove(id);
													}
												}
												document
														.getElementById('crops').value = crops
														.join('-');
											}

											function add(id) {
												crops.push(id);
											}

											function remove(id) {
												var i;
												var deletePosition;
												for (i = 0; i < crops.length; i++) {
													if (crops[i] == id) {
														deletePosition = i;
														break;
													}
												}
												if (typeof deletePosition === 'number') {
													crops.splice(
															deletePosition, 1)
												}
											}
										});
					}, 300);
		};
	</script>
	<%@include file="../parts/footer.jsp"%>
</body>
</html>