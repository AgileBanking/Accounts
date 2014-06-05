<%@ page import="entities.Contract" %>



<div class="fieldcontain ${hasErrors(bean: contractInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="contract.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${contractInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contractInstance, field: 'registrationId', 'error')} ">
	<label for="registrationId">
		<g:message code="contract.registrationId.label" default="Registration Id" />
		
	</label>
	<g:textField name="registrationId" value="${contractInstance?.registrationId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contractInstance, field: 'parties', 'error')} ">
	<label for="parties">
		<g:message code="contract.parties.label" default="Parties" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${contractInstance?.parties?}" var="p">
    <li><g:link controller="contractParty" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="contractParty" action="create" params="['contract.id': contractInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'contractParty.label', default: 'ContractParty')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: contractInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="contract.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${contractInstance?.notes}"/>
</div>

