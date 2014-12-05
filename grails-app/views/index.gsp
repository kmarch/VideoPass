<!DOCTYPE html>
<html>
	<head>
        <r:require modules="bootstrap"/>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>

			<div id="controller-list" role="navigation">

				<ul>
                    <div class="col-xs-4 col-sm-6">

                        <div class="content">

                            <h3>Derniers films</h3>

                            <div class="element1">
                                <IMG SRC="images/asterix.png"/>
                            </div>
                            <div class="element1">
                                <IMG SRC="images/interstellar.png"/>
                            </div>
                            <div class="element1">
                                <IMG SRC="images/fury.png"/>
                            </div>
                            <div class="element1">
                                <IMG SRC="images/gonegirl.png"/>
                            </div>
                            <div class="element1">
                                <IMG SRC="images/hobbit.png"/>
                            </div>

                        </br></br>

                            <div class="element1">
                                <IMG SRC="images/hunger.png"/>
                            </div>
                            <div class="element1">
                                <IMG SRC="images/labyrinthe.png"/>
                            </div>
                            <div class="element1">
                                <IMG SRC="images/rec.png"/>
                            </div>
                            <div class="element1">
                                <IMG SRC="images/samba.png"/>
                            </div>
                            <div class="element1">
                                <IMG SRC="images/serena.png"/>
                            </div>
                        </div>

					<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
						<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
					</g:each>
				</ul>
			</div>

	</body>
</html>
