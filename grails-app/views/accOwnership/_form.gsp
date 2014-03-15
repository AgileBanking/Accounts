<%@ page import="entities.AccOwnership" %>



<div class="fieldcontain ${hasErrors(bean: accOwnershipInstance, field: 'accOwner', 'error')} required">
	<label for="accOwner">
		<g:message code="accOwnership.accOwner.label" default="Acc Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="accOwner" name="accOwner.id" from="${entities.AccOwner.list()}" optionKey="id" required="" value="${accOwnershipInstance?.accOwner?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accOwnershipInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="accOwnership.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="owner" type="number" value="${accOwnershipInstance.owner}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: accOwnershipInstance, field: 'rights', 'error')} ">
	<label for="rights">
		<g:message code="accOwnership.rights.label" default="Rights" />
		
	</label>
	<g:select name="rights" from="${accOwnershipInstance.constraints.rights.inList}" value="${accOwnershipInstance?.rights}" valueMessagePrefix="accOwnership.rights" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accOwnershipInstance, field: 'ownerNotes', 'error')} ">
	<label for="ownerNotes">
		<g:message code="accOwnership.ownerNotes.label" default="Owner Notes" />
		
	</label>
	<g:textArea name="ownerNotes" cols="40" rows="5" maxlength="255" value="${accOwnershipInstance?.ownerNotes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accOwnershipInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="accOwnership.notes.label" default="Notes" />
		
	</label>
	<g:textArea name="notes" cols="40" rows="5" maxlength="255" value="${accOwnershipInstance?.notes}"/>
</div>

