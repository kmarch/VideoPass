<%@ page import="IVVQ.utilisateurs.Utilisateur" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <g:layoutHead/>
    <g:javascript library="application"/>
    <r:layoutResources/>
    <r:require modules="bootstrap"/>
</head>

<body>

<nav class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container-fluid">
        <div class="col-md-8 col-md-offset-2">
            <!-- Brand and toggle get grouped for better mobile display -->
            <!-- Collect the nav links, forms, and other content for toggling -->
            <p class="navbar-text">VideoPass</p>
            <ul class="navbar-right">


                <g:if test="${!session.login}">
                <p class="navbar-text navbar-right"><g:link controller="utilisateur" action="create">Register</g:link></p>

                <p class="navbar-text navbar-right"><g:link controller="utilisateur" action="connexion">Sign in</g:link></p>
                </g:if>
                <g:else>
                    <p class="navbar-text navbar-right"><g:link controller="utilisateur" action="deconnexion">Sign out</g:link></p>
                    <p class="navbar-text navbar-right"> Bienvenue : ${session.login}</p>
                </g:else>
            </ul>
        </div>
    </div><!-- /.container-fluid -->

</nav>

<div class="row">
    <div class="col-xs-2 col-sm-1 col-md-offset-2">
        <div class="container-fluid">
            <ul class="nav nav-pills nav-stacked" role="tablist">
<g:if test="${session.login}">
                <li role="presentation"><a href="/VideoPass/utilisateur/show/${session.index}.gsp">Mon profil</a></li>
                <li role="presentation"><a href="/VideoPass/DVD/index.gsp">Films</a></li>
                <li role="presentation"><a href="/VideoPass/DVD/recherche.gsp">Recherche</a></li>
                <li role="presentation"><a href="/VideoPass/DVD/create.gsp">Ajouter film</a></li>
</g:if>
<g:else>
    <li role="presentation"><a href="/VideoPass/utilisateur/connexion.gsp">Mon profil</a></li>
    <li role="presentation"><a href="/VideoPass/utilisateur/connexion.gsp">Films</a></li>
    <li role="presentation"><a href="/VideoPass/utilisateur/connexion.gsp">Recherche</a></li>
    <li role="presentation"><a href="/VideoPass/utilisateur/connexion.gsp">Ajouter film</a></li>
</g:else>
            </ul>

        </div>
    </div>


            <g:layoutBody/>
            <r:layoutResources/>
        </div>

    </div>
</div>
</body>
</html>
