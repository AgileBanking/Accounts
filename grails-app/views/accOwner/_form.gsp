<%@ page import="entities.AccOwner" %>



<div class="fieldcontain ${hasErrors(bean: accOwnerInstance, field: 'ownerType', 'error')} ">
	<label for="ownerType">
		<g:message code="accOwner.ownerType.label" default="Owner Type" />
		
	</label>
	<g:select name="ownerType" from="${accOwnerInstance.constraints.ownerType.inList}" value="${accOwnerInstance?.ownerType}" valueMessagePrefix="accOwner.ownerType" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accOwnerInstance, field: 'codeName', 'error')} ">
	<label for="codeName">
		<g:message code="accOwner.codeName.label" default="Code Name" />
		
	</label>
	<g:textField name="codeName" value="${accOwnerInstance?.codeName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accOwnerInstance, field: 'ownerships', 'error')} ">
	<label for="ownerships">
		<g:message code="accOwner.ownerships.label" default="Ownerships" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${accOwnerInstance?.ownerships?}" var="o">
    <li><g:link controller="accOwnership" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="accOwnership" action="create" params="['accOwner.id': accOwnerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'accOwnership.label', default: 'AccOwnership')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: accOwnerInstance, field: 'ownerCategory', 'error')} ">
	<label for="ownerCategory">
		<g:message code="accOwner.ownerCategory.label" default="Owner Category" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${accOwnerInstance?.ownerCategory?}" var="o">
    <li><g:link controller="accOwnerCategory" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="accOwnerCategory" action="create" params="['accOwner.id': accOwnerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'accOwnerCategory.label', default: 'AccOwnerCategory')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: accOwnerInstance, field: 'originOrgUnit', 'error')} ">
	<label for="originOrgUnit">
		<g:message code="accOwner.originOrgUnit.label" default="Origin Org Unit" />
		
	</label>
	<g:field name="originOrgUnit" type="number" value="${accOwnerInstance.originOrgUnit}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accOwnerInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="accOwner.notes.label" default="Notes" />
		
	</label>
	<g:textArea name="notes" cols="40" rows="5" maxlength="2000" value="${accOwnerInstance?.notes}"/>
</div>

