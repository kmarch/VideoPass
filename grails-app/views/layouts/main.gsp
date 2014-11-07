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
		<r:layoutResources />
        <r:require modules="bootstrap"/>
	</head>
	<body>
    <div style="width:1200px; margin:0 auto;">
    <nav class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
              <!-- Collect the nav links, forms, and other content for toggling -->
            <p class="navbar-text">VideoPass</p>
            <ul class="navbar-right">
            <button type="button" class="btn btn-default navbar-btn">Sign in</button>
            <button type="button" class="btn btn-default navbar-btn">Register</button>
                  </ul>
        </div><!-- /.container-fluid -->
    </nav>
        <div class="container-fluid">
            <div class="sidebar">
                <h1>Menu gauche</h1>
            </div>
            <div class="content">
		        <g:layoutBody/>
		        <r:layoutResources />
            </div>
        </div>
        </div>
	</body>
</html>
