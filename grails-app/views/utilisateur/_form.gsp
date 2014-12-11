<%@ page import="IVVQ.utilisateurs.Utilisateur" %>



<div class="fieldcontain ${hasErrors(bean: utilisateurInstance, field: 'pseudo', 'error')} required">
	<label for="pseudo">
		<g:message code="utilisateur.pseudo.label" default="Pseudo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="pseudo" required="" value="${utilisateurInstance?.pseudo}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: utilisateurInstance, field: 'mdp', 'error')} required">
	<label for="mdp">
		<g:message code="utilisateur.mdp.label" default="Mdp" />
		<span class="required-indicator">*</span>
	</label>
	<g:passwordField name="mdp" required="" value="${utilisateurInstance?.mdp}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: utilisateurInstance, field: 'dateNaissance', 'error')} required">
	<label for="dateNaissance">
		<g:message code="utilisateur.dateNaissance.label" default="Date Naissance" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="dateNaissance" type="date" max="1414661636757" value="${utilisateurInstance?.dateNaissance}" required=""/>

</div>


</div>

