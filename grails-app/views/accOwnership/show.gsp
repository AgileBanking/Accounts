
<%@ page import="entities.AccOwnership" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'accOwnership.label', default: 'AccOwnership')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-accOwnership" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-accOwnership" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list accOwnership">
			
				<g:if test="${accOwnershipInstance?.accOwner}">
				<li class="fieldcontain">
					<span id="accOwner-label" class="property-label"><g:message code="accOwnership.accOwner.label" default="Acc Owner" /></span>
					
						<span class="property-value" aria-labelledby="accOwner-label"><g:link controller="accOwner" action="show" id="${accOwnershipInstance?.accOwner?.id}">${accOwnershipInstance?.accOwner?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnershipInstance?.owner}">
				<li class="fieldcontain">
					<span id="owner-label" class="property-label"><g:message code="accOwnership.owner.label" default="Owner" /></span>
					
						<span class="property-value" aria-labelledby="owner-label"><g:fieldValue bean="${accOwnershipInstance}" field="owner"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnershipInstance?.rights}">
				<li class="fieldcontain">
					<span id="rights-label" class="property-label"><g:message code="accOwnership.rights.label" default="Rights" /></span>
					
						<span class="property-value" aria-labelledby="rights-label"><g:fieldValue bean="${accOwnershipInstance}" field="rights"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnershipInstance?.ownerNotes}">
				<li class="fieldcontain">
					<span id="ownerNotes-label" class="property-label"><g:message code="accOwnership.ownerNotes.label" default="Owner Notes" /></span>
					
						<span class="property-value" aria-labelledby="ownerNotes-label"><g:fieldValue bean="${accOwnershipInstance}" field="ownerNotes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnershipInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="accOwnership.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${accOwnershipInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnershipInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="accOwnership.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${accOwnershipInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnershipInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="accOwnership.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${accOwnershipInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnershipInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="accOwnership.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${accOwnershipInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:accOwnershipInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${accOwnershipInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
