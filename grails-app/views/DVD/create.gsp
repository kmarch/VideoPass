<!DOCTYPE html>
<html>
	<head>
        <r:require modules="bootstrap"/>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'DVD.label', default: 'DVD')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>

    <div class="col-xs-4 col-sm-6">

        <div class="content">
            <div class="jumbotron">
		<div id="create-DVD" class="content scaffold-create" role="main">
			<h1><g:message code="Ajouter un film" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${DVDInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${DVDInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>

                <g:form url="[resource:DVDInstance, action:'save']" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label class="col-sm-3 control-label" for="titre">Titre</label>
                        <div class="col-sm-9"><input type="text" class="form-control" placeholder="Titre" id="titre" name="titre" required="true"></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label" for="duree">Duree</label>
                        <div class="col-sm-9"><input type="number" class="form-control" placeholder="Duree" id="duree" name="duree" required="true"></div>
                    </div>
                    <label class="col-sm-3 control-label" for="genre">Genre</label>
                    <div class="col-sm-9">
                        <select class="form-control" id="genre" name="genre">
                            <option value="science_fiction" selected="selected">Science Fiction</option>
                            <option value="drame">Drame</option>
                            <option value="comedie">Comedie</option>
                            <option value="fantastique">Fantastique</option>
                            <option value="horreur">Horreur</option>
                            <option value="thriller">Thriller</option>
                            <option value="action">Action</option>
                            <option value="documentaire">Documentaire</option>
                        </select>
                        </div>
                    </div>
                    </br>
                    <input class="btn btn-primary btn-lg" type="submit" value="Creer">
                </g:form>
		</div>
        </div>
    </div>
	</body>
</html>
