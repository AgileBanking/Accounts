<%@ page import="entities.PartyRole" %>



<div class="fieldcontain ${hasErrors(bean: partyRoleInstance, field: 'role', 'error')} ">
	<label for="role">
		<g:message code="partyRole.role.label" default="Role" />
		
	</label>
	<g:textField name="role" value="${partyRoleInstance?.role}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partyRoleInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="partyRole.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${partyRoleInstance?.notes}"/>
</div>

