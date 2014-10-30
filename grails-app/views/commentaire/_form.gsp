<%@ page import="IVVQ.social.Commentaire" %>



<div class="fieldcontain ${hasErrors(bean: commentaireInstance, field: 'commentaire', 'error')} required">
	<label for="commentaire">
		<g:message code="commentaire.commentaire.label" default="Commentaire" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="commentaire" required="" value="${commentaireInstance?.commentaire}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: commentaireInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="commentaire.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="date" type="number" min="1414661635607" value="${commentaireInstance.date}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: commentaireInstance, field: 'note', 'error')} required">
	<label for="note">
		<g:message code="commentaire.note.label" default="Note" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="note" type="number" value="${commentaireInstance.note}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: commentaireInstance, field: 'dvd', 'error')} required">
	<label for="dvd">
		<g:message code="commentaire.dvd.label" default="Dvd" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="dvd" name="dvd.id" from="${IVVQ.DVDs.DVD.list()}" optionKey="id" required="" value="${commentaireInstance?.dvd?.id}" class="many-to-one"/>

</div>

