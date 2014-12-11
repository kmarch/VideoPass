<!DOCTYPE html>
<html>
	<head>
        <r:require modules="bootstrap"/>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'utilisateur.label', default: 'Utilisateur')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
    <div class="col-xs-4 col-sm-6">

        <div class="content">
		<div id="create-utilisateur" class="content scaffold-create" role="main">
			<h1><g:message code="Inscription" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${utilisateurInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${utilisateurInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:utilisateurInstance, action:'save']" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: "S'enregistrer")}" />
				</fieldset>
			</g:form>
		</div>
            </div></div>
	</body>
</html>
