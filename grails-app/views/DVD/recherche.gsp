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
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search" >
            </div>
            <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
        </form>


        </div>
    </div>
</div>
</body>
</html>
