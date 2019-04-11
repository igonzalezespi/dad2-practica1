<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<style>
	.main-content {
		padding: 20px;
	}
	.mdl-layout__drawer-button {
		background: none;
	}
</style>

<header class="mdl-layout__header"
		style="margin-bottom: 10px;">
  <div class="mdl-layout__header-row">
    <!-- Title -->
    <span class="mdl-layout-title">Fincas UCAM</span>
    <div class="mdl-layout-spacer"></div>
    <nav class="mdl-navigation">
      <a id="logout" class="mdl-button mdl-js-button mdl-button--icon" href="<%= request.getContextPath() %>/api/private/logout">
		<i class="material-icons">power_settings_new</i>
	  </a>
	  <div class="mdl-tooltip" data-mdl-for="logout">Cerrar sesión</div>
    </nav>
  </div>
</header>
<button class="mdl-layout__drawer-button"
	onclick="history.back()">
	<i class="material-icons">arrow_back</i>
</button>

<div class="main-content">
