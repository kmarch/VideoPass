
<%@ page import="IVVQ.social.Commentaire" %>
<!DOCTYPE html>
<html>
	<head>
        <r:require modules="bootstrap"/>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'commentaire.label', default: 'Commentaire')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-commentaire" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-commentaire" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="commentaire" title="${message(code: 'commentaire.commentaire.label', default: 'Commentaire')}" />
					
						<g:sortableColumn property="date" title="${message(code: 'commentaire.date.label', default: 'Date')}" />
					
						<g:sortableColumn property="note" title="${message(code: 'commentaire.note.label', default: 'Note')}" />
					
						<th><g:message code="commentaire.dvd.label" default="Dvd" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${commentaireInstanceList}" status="i" var="commentaireInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${commentaireInstance.id}">${fieldValue(bean: commentaireInstance, field: "commentaire")}</g:link></td>
					
						<td>${fieldValue(bean: commentaireInstance, field: "date")}</td>
					
						<td>${fieldValue(bean: commentaireInstance, field: "note")}</td>
					
						<td>${fieldValue(bean: commentaireInstance, field: "dvd")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${commentaireInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
