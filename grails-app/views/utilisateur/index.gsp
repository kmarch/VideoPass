
<%@ page import="IVVQ.utilisateurs.Utilisateur" %>
<!DOCTYPE html>
<html>
	<head>
        <r:require modules="bootstrap"/>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'utilisateur.label', default: 'Utilisateur')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-utilisateur" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-utilisateur" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="pseudo" title="${message(code: 'utilisateur.pseudo.label', default: 'Pseudo')}" />
					
						<g:sortableColumn property="mdp" title="${message(code: 'utilisateur.mdp.label', default: 'Mdp')}" />
					
						<g:sortableColumn property="dateNaissance" title="${message(code: 'utilisateur.dateNaissance.label', default: 'Date Naissance')}" />
					
						<g:sortableColumn property="isAdmin" title="${message(code: 'utilisateur.isAdmin.label', default: 'Is Admin')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${utilisateurInstanceList}" status="i" var="utilisateurInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${utilisateurInstance.id}">${fieldValue(bean: utilisateurInstance, field: "pseudo")}</g:link></td>
					
						<td>${fieldValue(bean: utilisateurInstance, field: "mdp")}</td>
					
						<td>${fieldValue(bean: utilisateurInstance, field: "dateNaissance")}</td>
					
						<td><g:formatBoolean boolean="${utilisateurInstance.isAdmin}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${utilisateurInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
