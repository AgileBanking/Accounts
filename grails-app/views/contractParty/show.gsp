
<%@ page import="entities.ContractParty" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contractParty.label', default: 'ContractParty')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-contractParty" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-contractParty" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list contractParty">
			
				<g:if test="${contractPartyInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="property-label"><g:message code="contractParty.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${contractPartyInstance}" field="type"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contractPartyInstance?.contract}">
				<li class="fieldcontain">
					<span id="contract-label" class="property-label"><g:message code="contractParty.contract.label" default="Contract" /></span>
					
						<span class="property-value" aria-labelledby="contract-label"><g:link controller="contract" action="show" id="${contractPartyInstance?.contract?.id}">${contractPartyInstance?.contract?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${contractPartyInstance?.role}">
				<li class="fieldcontain">
					<span id="role-label" class="property-label"><g:message code="contractParty.role.label" default="Role" /></span>
					
						<span class="property-value" aria-labelledby="role-label"><g:link controller="partyRole" action="show" id="${contractPartyInstance?.role?.id}">${contractPartyInstance?.role?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${contractPartyInstance?.party}">
				<li class="fieldcontain">
					<span id="party-label" class="property-label"><g:message code="contractParty.party.label" default="Party" /></span>
					
						<span class="property-value" aria-labelledby="party-label"><g:fieldValue bean="${contractPartyInstance}" field="party"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${contractPartyInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="contractParty.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${contractPartyInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:contractPartyInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${contractPartyInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
