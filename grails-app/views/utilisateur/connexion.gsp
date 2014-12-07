<%--
  Created by IntelliJ IDEA.
  User: Mathieu
  Date: 14/11/2014
  Time: 15:35
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <r:require modules="bootstrap"/>
    <meta name="layout" content="main">
    <title>Connexion</title>
</head>

<body>
<g:if test="${session.login}">
    <p>Vous êtes déja enregistré</p>
</g:if>
<g:else>

    <g:form url="[ressource:utilisateurInstance, action:'connexion']" role ="form">
        <div class="col-xs-4 col-sm-6">

                        <div class="content">
        <div >
            <label for="id">Pseudo</label>
            <input type="text" class="form-control" placeholder="Pseudo" id="pseudo" name="pseudo" required="true">
        </div>
        <div >
            <label for="mdp">Mot de passe</label>
            <input type="password" class="form-control" placeholder="Mot de passe" id="mdp" name="mdp" required="true">
        </div>
        <button type="submit"> Connexion</button>
        </div></div>
    </g:form>
</g:else>

</body>
</html>