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
		<h1><g:message code="Critique" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${commentaireInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${commentaireInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>

<g:form url="[resource:commentaireInstance, action:'saveCom']" class="form-horizontal" role="form">
            <div class="form-group">
                <label class="col-sm-3 control-label" for="commentaire">Commentaire</label>
                <div class="col-sm-9"><input type="text" class="form-control" placeholder="Commentaire" id="commentaire" name="commentaire" required="true"></div>
            </div>
    <div class="form-group">
        <label class="col-sm-3 control-label" for="note">Note</label>
        <div class="col-sm-9"><input type="number" class="form-control" placeholder="Note" id="note" name="note" required="true" max="5" min="0"></div>
    </div>
    %{--<label class="col-sm-3 control-label" for="note">Note</label>--}%
    %{--<div class="col-sm-9"><select class="form-control" id="note" name="Note">--}%
        %{--<option value=1 selected="selected">1</option>--}%
        %{--<option value=2>2</option>--}%
        %{--<option value=3>3</option>--}%
        %{--<option value=4>4</option>--}%
        %{--<option value=5>5</option>--}%
    %{--</select></div>--}%
<input class="btn btn-primary btn-lg" type="submit" value="Ajouter">
</g:form>
        </div>
    </div></div>
	</body>
</html>
