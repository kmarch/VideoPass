
<%@ page import="IVVQ.social.Commentaire" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'commentaire.label', default: 'Commentaire')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-commentaire" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-commentaire" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list commentaire">
			
				<g:if test="${commentaireInstance?.commentaire}">
				<li class="fieldcontain">
					<span id="commentaire-label" class="property-label"><g:message code="commentaire.commentaire.label" default="Commentaire" /></span>
					
						<span class="property-value" aria-labelledby="commentaire-label"><g:fieldValue bean="${commentaireInstance}" field="commentaire"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${commentaireInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="property-label"><g:message code="commentaire.date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:fieldValue bean="${commentaireInstance}" field="date"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${commentaireInstance?.note}">
				<li class="fieldcontain">
					<span id="note-label" class="property-label"><g:message code="commentaire.note.label" default="Note" /></span>
					
						<span class="property-value" aria-labelledby="note-label"><g:fieldValue bean="${commentaireInstance}" field="note"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${commentaireInstance?.dvd}">
				<li class="fieldcontain">
					<span id="dvd-label" class="property-label"><g:message code="commentaire.dvd.label" default="Dvd" /></span>
					
						<span class="property-value" aria-labelledby="dvd-label"><g:link controller="DVD" action="show" id="${commentaireInstance?.dvd?.id}">${commentaireInstance?.dvd?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:commentaireInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${commentaireInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
