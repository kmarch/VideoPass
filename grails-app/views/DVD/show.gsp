
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
    <div class="col-xs-4 col-sm-6">

        <div class="content">

            <div class="jumbotron">

		<div id="show-DVD" class="content scaffold-show" role="main">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list DVD">
			
				<g:if test="${DVDInstance?.titre}">
						<h1><span class="property-value" aria-labelledby="titre-label"><g:fieldValue bean="${DVDInstance}" field="titre"/></span></h1>

				</g:if>
                <p>
				<g:if test="${DVDInstance?.sortie}">
					<span id="sortie-label" class="property-label"><g:message code="DVD.sortie.label" default="Sortie :" /></span>

						<span class="property-value" aria-labelledby="sortie-label"><g:fieldValue bean="${DVDInstance}" field="sortie"/></span></br>

				</g:if>
			
				<g:if test="${DVDInstance?.duree}">
					<span id="duree-label" class="property-label"><g:message code="DVD.duree.label" default="Duree :" /></span>
					
						<span class="property-value" aria-labelledby="duree-label"><g:fieldValue bean="${DVDInstance}" field="duree"/></span> min</br>

				</g:if>
			
				<g:if test="${DVDInstance?.genre}">
					<span id="genre-label" class="property-label"><g:message code="DVD.genre.label" default="Genre :" /></span>
					
						<span class="property-value" aria-labelledby="genre-label"><g:fieldValue bean="${DVDInstance}" field="genre"/></span></br>

				</g:if>
			
				<g:if test="${DVDInstance?.nbExemplaire}">
					<span id="nbExemplaire-label" class="property-label"><g:message code="DVD.nbExemplaire.label" default="Nb Exemplaire" /></span>
					
						<span class="property-value" aria-labelledby="nbExemplaire-label"><g:fieldValue bean="${DVDInstance}" field="nbExemplaire"/></span></br>

				</g:if>
			

			</p>
			</ol>
            <p><a class="btn btn-primary btn-lg" role="button" href="/VideoPass/commentaire/create/<g:fieldValue bean="${DVDInstance}" field="id"/>" >Déposer une critique</a></p>
			%{--<g:form url="[resource:DVDInstance, action:'delete']" method="DELETE">--}%
				%{--<fieldset class="buttons">--}%
					%{--<g:link class="edit" action="edit" resource="${DVDInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>--}%
					%{--<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />--}%
				%{--</fieldset>--}%
			%{--</g:form>--}%
		</div>

            </div>

                <g:each in="${DVDInstance.commentaire}" var="c">
                    <div class="jumbotron">
                    <h2>${c?.utilisateur.pseudo} : ${c?.note}/5</h2></br>
                    ${c?.commentaire}</br></br>
                    </div>
                </g:each>

            </div>
        </div>
	</body>
</html>
