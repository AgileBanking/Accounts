<%@ page import="entities.ContractParty" %>



<div class="fieldcontain ${hasErrors(bean: contractPartyInstance, field: 'contract', 'error')} required">
	<label for="contract">
		<g:message code="contractParty.contract.label" default="Contract" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="contract" name="contract.id" from="${entities.Contract.list()}" optionKey="id" required="" value="${contractPartyInstance?.contract?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contractPartyInstance, field: 'role', 'error')} required">
	<label for="role">
		<g:message code="contractParty.role.label" default="Role" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="role" name="role.id" from="${entities.PartyRole.list()}" optionKey="id" required="" value="${contractPartyInstance?.role?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contractPartyInstance, field: 'party', 'error')} ">
	<label for="party">
		<g:message code="contractParty.party.label" default="Party" />
		
	</label>
	<g:textField name="party" value="${contractPartyInstance?.party}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contractPartyInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="contractParty.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${contractPartyInstance?.notes}"/>
</div>

