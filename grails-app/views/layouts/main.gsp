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
                <p class="navbar-text navbar-right"><a href="#" class="navbar-link">Register</a></p>

                <p class="navbar-text navbar-right"><a href="#" class="navbar-link">Sign in</a></p>
            </ul>
        </div>
    </div><!-- /.container-fluid -->

</nav>

<div class="row">
    <div class="col-xs-2 col-sm-1 col-md-offset-2">
        <div class="container-fluid">
            <ul class="nav nav-pills nav-stacked" role="tablist">
                <li role="presentation"><a href="#">Mon profil</a></li>
                <li role="presentation"><a href="#">Actualité</a></li>
                <li role="presentation"><a href="#">Films</a></li>
                <li role="presentation"><a href="#">Playlist</a></li>
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
