<%@ page import="IVVQ.social.Commentaire" %>



<div class="fieldcontain ${hasErrors(bean: commentaireInstance, field: 'commentaire', 'error')} required">
	<label for="commentaire">
		<g:message code="commentaire.commentaire.label" default="Commentaire" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="commentaire" required="" value="${commentaireInstance?.commentaire}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: commentaireInstance, field: 'dateCommentaire', 'error')} required">
	<label for="dateCommentaire">
		<g:message code="commentaire.dateCommentaire.label" default="Date Commentaire" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="dateCommentaire" type="number" value="${commentaireInstance.dateCommentaire}" required=""/>

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

<div class="fieldcontain ${hasErrors(bean: commentaireInstance, field: 'listeSousCommentaire', 'error')} ">
	<label for="listeSousCommentaire">
		<g:message code="commentaire.listeSousCommentaire.label" default="Liste Sous Commentaire" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${commentaireInstance?.listeSousCommentaire?}" var="l">
    <li><g:link controller="sousCommentaire" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="sousCommentaire" action="create" params="['commentaire.id': commentaireInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'sousCommentaire.label', default: 'SousCommentaire')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: commentaireInstance, field: 'utilisateur', 'error')} required">
	<label for="utilisateur">
		<g:message code="commentaire.utilisateur.label" default="Utilisateur" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="utilisateur" name="utilisateur.id" from="${IVVQ.utilisateurs.Utilisateur.list()}" optionKey="id" required="" value="${commentaireInstance?.utilisateur?.id}" class="many-to-one"/>

</div>

