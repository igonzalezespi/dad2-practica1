<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<style>
header {
	position: absolute;
	top: 0px;
	left: 0px;
	height: 64px;
	right: 0px;
	overflow: hidden;
}

.main-content {
	padding: 20px;
	position: absolute;
	top: 64px;
	bottom: 128px;
	left: 0px;
	right: 0px;
	overflow: auto;
}

.mdl-layout__drawer-button {
	background: none;
}
</style>

<header class="mdl-layout__header" style="display: flex; margin-bottom: 10px;">
	<div class="mdl-layout__header-row">
		<!-- Title -->
		<span class="mdl-layout-title">Fincas UCAM</span>
		<div class="mdl-layout-spacer"></div>
		<nav class="mdl-navigation">
			<a id="logout" class="mdl-button mdl-js-button mdl-button--icon"
				href="<%=request.getContextPath()%>/api/private/logout"> <i
				class="material-icons">power_settings_new</i>
			</a>
			<div class="mdl-tooltip" data-mdl-for="logout">Cerrar sesión</div>
		</nav>
	</div>
</header>

<div class="main-content">