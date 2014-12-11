<%@ page import="IVVQ.DVDs.DVD" %>



<div class="fieldcontain ${hasErrors(bean: DVDInstance, field: 'titre', 'error')} required">
	<label for="titre">
		<g:message code="DVD.titre.label" default="Titre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titre" required="" value="${DVDInstance?.titre}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: DVDInstance, field: 'sortie', 'error')} required">
	<label for="sortie">
		<g:message code="DVD.sortie.label" default="Sortie" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="sortie" type="number" max="1414748030580" value="${DVDInstance.sortie}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: DVDInstance, field: 'duree', 'error')} required">
	<label for="duree">
		<g:message code="DVD.duree.label" default="Duree" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="duree" type="number" value="${DVDInstance.duree}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: DVDInstance, field: 'genre', 'error')} required">
	<label for="genre">
		<g:message code="DVD.genre.label" default="Genre" />
		<span class="required-indicator">*</span>
	</label>
    <g:field name="genre" type="Genre" value="${DVDInstance.genre}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: DVDInstance, field: 'nbExemplaire', 'error')} required">
	<label for="nbExemplaire">
		<g:message code="DVD.nbExemplaire.label" default="Nb Exemplaire" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="nbExemplaire" type="number" value="${DVDInstance.nbExemplaire}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: DVDInstance, field: 'commentaire', 'error')} ">
	<label for="commentaire">
		<g:message code="DVD.commentaire.label" default="Commentaire" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${DVDInstance?.commentaire?}" var="c">
    <li><g:link controller="commentaire" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="commentaire" action="create" params="['DVD.id': DVDInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'commentaire.label', default: 'Commentaire')])}</g:link>
</li>
</ul>


</div>

