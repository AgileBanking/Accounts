
<%@ page import="entities.ShadowAccount" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'shadowAccount.label', default: 'ShadowAccount')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-shadowAccount" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-shadowAccount" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list shadowAccount">
			
				<g:if test="${shadowAccountInstance?.account}">
				<li class="fieldcontain">
					<span id="account-label" class="property-label"><g:message code="shadowAccount.account.label" default="Account" /></span>
					
						<span class="property-value" aria-labelledby="account-label"><g:link controller="account" action="show" id="${shadowAccountInstance?.account?.id}">${shadowAccountInstance?.account?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${shadowAccountInstance?.dimension}">
				<li class="fieldcontain">
					<span id="dimension-label" class="property-label"><g:message code="shadowAccount.dimension.label" default="Dimension" /></span>
					
						<span class="property-value" aria-labelledby="dimension-label"><g:fieldValue bean="${shadowAccountInstance}" field="dimension"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shadowAccountInstance?.previousBalance}">
				<li class="fieldcontain">
					<span id="previousBalance-label" class="property-label"><g:message code="shadowAccount.previousBalance.label" default="Previous Balance" /></span>
					
						<span class="property-value" aria-labelledby="previousBalance-label"><g:fieldValue bean="${shadowAccountInstance}" field="previousBalance"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shadowAccountInstance?.ytdDebit}">
				<li class="fieldcontain">
					<span id="ytdDebit-label" class="property-label"><g:message code="shadowAccount.ytdDebit.label" default="Ytd Debit" /></span>
					
						<span class="property-value" aria-labelledby="ytdDebit-label"><g:fieldValue bean="${shadowAccountInstance}" field="ytdDebit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shadowAccountInstance?.ytdCredit}">
				<li class="fieldcontain">
					<span id="ytdCredit-label" class="property-label"><g:message code="shadowAccount.ytdCredit.label" default="Ytd Credit" /></span>
					
						<span class="property-value" aria-labelledby="ytdCredit-label"><g:fieldValue bean="${shadowAccountInstance}" field="ytdCredit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shadowAccountInstance?.available}">
				<li class="fieldcontain">
					<span id="available-label" class="property-label"><g:message code="shadowAccount.available.label" default="Available" /></span>
					
						<span class="property-value" aria-labelledby="available-label"><g:fieldValue bean="${shadowAccountInstance}" field="available"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shadowAccountInstance?.blocked}">
				<li class="fieldcontain">
					<span id="blocked-label" class="property-label"><g:message code="shadowAccount.blocked.label" default="Blocked" /></span>
					
						<span class="property-value" aria-labelledby="blocked-label"><g:fieldValue bean="${shadowAccountInstance}" field="blocked"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shadowAccountInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="shadowAccount.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${shadowAccountInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${shadowAccountInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="shadowAccount.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${shadowAccountInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${shadowAccountInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="shadowAccount.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${shadowAccountInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:shadowAccountInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${shadowAccountInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
