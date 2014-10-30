
<%@ page import="IVVQ.DVDs.DVD" %>
<!DOCTYPE html>
<html>
	<head>
        <r:require modules="bootstrap"/>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'DVD.label', default: 'DVD')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-DVD" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-DVD" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list DVD">
			
				<g:if test="${DVDInstance?.titre}">
				<li class="fieldcontain">
					<span id="titre-label" class="property-label"><g:message code="DVD.titre.label" default="Titre" /></span>
					
						<span class="property-value" aria-labelledby="titre-label"><g:fieldValue bean="${DVDInstance}" field="titre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${DVDInstance?.sortie}">
				<li class="fieldcontain">
					<span id="sortie-label" class="property-label"><g:message code="DVD.sortie.label" default="Sortie" /></span>
					
						<span class="property-value" aria-labelledby="sortie-label"><g:fieldValue bean="${DVDInstance}" field="sortie"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${DVDInstance?.duree}">
				<li class="fieldcontain">
					<span id="duree-label" class="property-label"><g:message code="DVD.duree.label" default="Duree" /></span>
					
						<span class="property-value" aria-labelledby="duree-label"><g:fieldValue bean="${DVDInstance}" field="duree"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${DVDInstance?.genre}">
				<li class="fieldcontain">
					<span id="genre-label" class="property-label"><g:message code="DVD.genre.label" default="Genre" /></span>
					
						<span class="property-value" aria-labelledby="genre-label"><g:fieldValue bean="${DVDInstance}" field="genre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${DVDInstance?.nbExemplaire}">
				<li class="fieldcontain">
					<span id="nbExemplaire-label" class="property-label"><g:message code="DVD.nbExemplaire.label" default="Nb Exemplaire" /></span>
					
						<span class="property-value" aria-labelledby="nbExemplaire-label"><g:fieldValue bean="${DVDInstance}" field="nbExemplaire"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${DVDInstance?.commentaire}">
				<li class="fieldcontain">
					<span id="commentaire-label" class="property-label"><g:message code="DVD.commentaire.label" default="Commentaire" /></span>
					
						<g:each in="${DVDInstance.commentaire}" var="c">
						<span class="property-value" aria-labelledby="commentaire-label"><g:link controller="commentaire" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:DVDInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${DVDInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
