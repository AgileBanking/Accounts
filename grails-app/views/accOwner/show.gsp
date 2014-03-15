
<%@ page import="entities.AccOwner" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'accOwner.label', default: 'AccOwner')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-accOwner" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-accOwner" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list accOwner">
			
				<g:if test="${accOwnerInstance?.ownerType}">
				<li class="fieldcontain">
					<span id="ownerType-label" class="property-label"><g:message code="accOwner.ownerType.label" default="Owner Type" /></span>
					
						<span class="property-value" aria-labelledby="ownerType-label"><g:fieldValue bean="${accOwnerInstance}" field="ownerType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnerInstance?.codeName}">
				<li class="fieldcontain">
					<span id="codeName-label" class="property-label"><g:message code="accOwner.codeName.label" default="Code Name" /></span>
					
						<span class="property-value" aria-labelledby="codeName-label"><g:fieldValue bean="${accOwnerInstance}" field="codeName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnerInstance?.ownerships}">
				<li class="fieldcontain">
					<span id="ownerships-label" class="property-label"><g:message code="accOwner.ownerships.label" default="Ownerships" /></span>
					
						<g:each in="${accOwnerInstance.ownerships}" var="o">
						<span class="property-value" aria-labelledby="ownerships-label"><g:link controller="accOwnership" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnerInstance?.ownerCategory}">
				<li class="fieldcontain">
					<span id="ownerCategory-label" class="property-label"><g:message code="accOwner.ownerCategory.label" default="Owner Category" /></span>
					
						<g:each in="${accOwnerInstance.ownerCategory}" var="o">
						<span class="property-value" aria-labelledby="ownerCategory-label"><g:link controller="accOwnerCategory" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnerInstance?.originOrgUnit}">
				<li class="fieldcontain">
					<span id="originOrgUnit-label" class="property-label"><g:message code="accOwner.originOrgUnit.label" default="Origin Org Unit" /></span>
					
						<span class="property-value" aria-labelledby="originOrgUnit-label"><g:fieldValue bean="${accOwnerInstance}" field="originOrgUnit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnerInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="accOwner.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${accOwnerInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnerInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="accOwner.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${accOwnerInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnerInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="accOwner.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${accOwnerInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnerInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="accOwner.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${accOwnerInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:accOwnerInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${accOwnerInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
