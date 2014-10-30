
<%@ page import="IVVQ.DVDs.DVD" %>
<!DOCTYPE html>
<html>
	<head>
        <r:require modules="bootstrap"/>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'DVD.label', default: 'DVD')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-DVD" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-DVD" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="titre" title="${message(code: 'DVD.titre.label', default: 'Titre')}" />
					
						<g:sortableColumn property="sortie" title="${message(code: 'DVD.sortie.label', default: 'Sortie')}" />
					
						<g:sortableColumn property="duree" title="${message(code: 'DVD.duree.label', default: 'Duree')}" />
					
						<g:sortableColumn property="genre" title="${message(code: 'DVD.genre.label', default: 'Genre')}" />
					
						<g:sortableColumn property="nbExemplaire" title="${message(code: 'DVD.nbExemplaire.label', default: 'Nb Exemplaire')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${DVDInstanceList}" status="i" var="DVDInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${DVDInstance.id}">${fieldValue(bean: DVDInstance, field: "titre")}</g:link></td>
					
						<td>${fieldValue(bean: DVDInstance, field: "sortie")}</td>
					
						<td>${fieldValue(bean: DVDInstance, field: "duree")}</td>
					
						<td>${fieldValue(bean: DVDInstance, field: "genre")}</td>
					
						<td>${fieldValue(bean: DVDInstance, field: "nbExemplaire")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${DVDInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
