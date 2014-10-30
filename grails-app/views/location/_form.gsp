<%@ page import="IVVQ.location.Location" %>



<div class="fieldcontain ${hasErrors(bean: locationInstance, field: 'idUtilisateur', 'error')} required">
	<label for="idUtilisateur">
		<g:message code="location.idUtilisateur.label" default="Id Utilisateur" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="idUtilisateur" required="" value="${locationInstance?.idUtilisateur}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: locationInstance, field: 'idFilm', 'error')} required">
	<label for="idFilm">
		<g:message code="location.idFilm.label" default="Id Film" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="idFilm" required="" value="${locationInstance?.idFilm}"/>

</div>

