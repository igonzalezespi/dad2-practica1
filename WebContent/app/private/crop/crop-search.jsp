<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
table, .table-title {
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

.back-button {
	float: left;
	margin-top: 5px;
}
</style>
</head>
<body style="height:100%; width:100%">
	<%@include file="../parts/header.jsp"%>

	<div class="table-title">
		<a
			class="back-button mdl-button mdl-js-button mdl-button--icon mdl-button--colored"
			href="<%=request.getContextPath()%>/app/private/main.jsp">
			<i class="material-icons">arrow_back</i>
		</a> Cultivos
	</div>
	<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
		<thead>
			<tr>
				<th class="mdl-data-table__cell--non-numeric" style="width: 40%;">
					Nombre</th>
				<th class="mdl-data-table__cell--numeric" style="width: 40%;">
					Tama�o (H)</th>
				<th class="mdl-data-table__cell--non-numeric"><a
					class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored"
					href="<%=request.getContextPath()%>/api/private/crop/views/crop-edit">
						<i class="material-icons">add</i>
				</a></th>
			</tr>
		</thead>
		<tbody>
			<%
				Hashtable<Number, Crop> list = request.getSession(false).getAttribute("list") != null
						? (Hashtable<Number, Crop>) request.getSession(false).getAttribute("list")
						: null;
				if (list != null && list.size() > 0) {
					Enumeration<Number> i = list.keys();
					Number id;
					Crop crop;

					while (i.hasMoreElements()) {
						id = (Number) i.nextElement();
						crop = list.get(id);
						out.println("<tr><td class=\"mdl-data-table__cell--non-numeric\">" + crop.getName()
								+ "</td><td class=\"mdl-data-table__cell--numeric\">" + crop.getFormattedSize()
								+ "</td><td class=\"mdl-data-table__cell--non-numeric\">"
								+ "<a class=\"mdl-button mdl-js-button mdl-button--icon mdl-button--colored\" href=\""
								+ request.getContextPath() + "/api/private/crop/views/crop-edit?id=" + id
								+ "\"><i class=\"material-icons\">edit</i></a>"
								+ "<a class=\"mdl-button mdl-js-button mdl-button--icon\" style=\"color: #ce3a3a;\" href=\""
								+ request.getContextPath() + "/api/private/crop/actions/remove?id=" + id
								+ "\"><i class=\"material-icons\">delete</i></a>" + "</td></tr>");
					}
				} else {
					out.println(
							"<tr><td colspan=\"4\" style=\"text-align: center; font-style: italic;\">No se encontraron datos</td></tr>");
				}
			%>
		</tbody>
	</table>

	<%@include file="../parts/footer.jsp"%>
</body>
</html>