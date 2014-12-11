
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
    <div class="col-xs-4 col-sm-6">

        <div class="content">
				<g:each in="${DVDInstanceList}" status="i" var="DVDInstance">
                    <div class="jumbotron">
                        <g:if test="${DVDInstance?.titre}">
                            <h1><span class="property-value" aria-labelledby="titre-label"><g:fieldValue bean="${DVDInstance}" field="titre"/></span></h1>
                        </g:if>

                        <p>
                            <g:if test="${DVDInstance?.sortie}">
                                <span id="sortie-label" class="property-label"><g:message code="DVD.sortie.label" default="Sortie" /></span>
                                :
                                <span class="property-value" aria-labelledby="sortie-label"><g:fieldValue bean="${DVDInstance}" field="sortie"/></span>
                                </br>
                            </g:if>

                            <g:if test="${DVDInstance?.duree}">
                                <span id="duree-label" class="property-label"><g:message code="DVD.duree.label" default="Duree" /></span>
                                :
                                <span class="property-value" aria-labelledby="duree-label"><g:fieldValue bean="${DVDInstance}" field="duree"/></span> min
                                </br>
                            </g:if>

                            <g:if test="${DVDInstance?.genre}">
                                <span id="genre-label" class="property-label"><g:message code="DVD.genre.label" default="Genre" /></span>
                                :
                                <span class="property-value" aria-labelledby="genre-label"><g:fieldValue bean="${DVDInstance}" field="genre"/></span>
                                </br>
                            </g:if>
                        </p>
                        <p><a class="btn btn-primary btn-lg" role="button" href="/VideoPass/DVD/show/<g:fieldValue bean="${DVDInstance}" field="id"/>" >Voir critiques</a></p>
                    </div>

				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${DVDInstanceCount ?: 0}" />
			</div>
		</div>
        </div>

	</body>
</html>
