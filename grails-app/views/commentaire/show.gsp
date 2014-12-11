
<%@ page import="IVVQ.social.Commentaire" %>
<!DOCTYPE html>
<html>
<head>
    <r:require modules="bootstrap"/>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'Commentaire.label', default: 'Commentaire')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div class="col-xs-4 col-sm-6">

    <div class="content">
        <div class="jumbotron">
		<div id="show-commentaire" class="content scaffold-show" role="main">
			<h2><g:message code="Commentaire : " args="[entityName]" /></h2>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list commentaire">

                <g:if test="${commentaireInstance?.note}">
                    <h3> Note : <span class="property-value" aria-labelledby="note-label"><g:fieldValue bean="${commentaireInstance}" field="note"/></span>/5</h3>

                </g:if>

				<g:if test="${commentaireInstance?.commentaire}">

                    <h3>	<span class="property-value" aria-labelledby="commentaire-label"><g:fieldValue bean="${commentaireInstance}" field="commentaire"/></span></h3>

                </g:if>



				<g:if test="${commentaireInstance?.listeSousCommentaire}">
				<li class="fieldcontain">
					<span id="listeSousCommentaire-label" class="property-label"><g:message code="commentaire.listeSousCommentaire.label" default="Liste Sous Commentaire" /></span>
					
						<g:each in="${commentaireInstance.listeSousCommentaire}" var="l">
						<span class="property-value" aria-labelledby="listeSousCommentaire-label"><g:link controller="sousCommentaire" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>

			
			</ol>
		</div>
        </div></div>
    </div>
	</body>
</html>
