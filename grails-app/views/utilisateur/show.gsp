
<%@ page import="IVVQ.utilisateurs.Utilisateur" %>
<!DOCTYPE html>
<html>
	<head>
        <r:require modules="bootstrap"/>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'utilisateur.label', default: 'Utilisateur')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
    <div class="col-xs-4 col-sm-6">

        <div class="content">
    <div class="jumbotron">

		<div id="show-utilisateur" class="content scaffold-show" role="main">
			<ol class="property-list utilisateur">
			
				<g:if test="${utilisateurInstance?.pseudo}">
					<h1><span class="property-value" aria-labelledby="pseudo-label"><g:fieldValue bean="${utilisateurInstance}" field="pseudo"/></span></h1>

				</g:if>

				<g:if test="${utilisateurInstance?.dateNaissance}">
						<span class="property-value" aria-labelledby="dateNaissance-label"><g:fieldValue bean="${utilisateurInstance}" field="dateNaissance"/></span>

				</g:if>

			
			</ol>

            <p><a class="btn btn-primary btn-lg" role="button" href="/VideoPass/utilisateur/edit/<g:fieldValue bean="${utilisateurInstance}" field="id"/>" >Editer</a></p>

		</div>
        </div>
        <div class="jumbotron">
            <h2>Vos commentaires :</h2>
            <g:each in="${utilisateurInstance.listeCommentaires}" var="c">
                    <h3><span class="property-value" aria-labelledby="commentaire-label"><g:link controller="commentaire" action="show" id="${c.id}">${c?.dvd.titre} : ${c?.note}/5</g:link></span></h3>
            </g:each>
        </div>
        </div></div>
	</body>
</html>
