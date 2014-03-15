
<%@ page import="entities.AccOwnership" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'accOwnership.label', default: 'AccOwnership')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-accOwnership" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-accOwnership" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="accOwnership.accOwner.label" default="Acc Owner" /></th>
					
						<g:sortableColumn property="owner" title="${message(code: 'accOwnership.owner.label', default: 'Owner')}" />
					
						<g:sortableColumn property="rights" title="${message(code: 'accOwnership.rights.label', default: 'Rights')}" />
					
						<g:sortableColumn property="ownerNotes" title="${message(code: 'accOwnership.ownerNotes.label', default: 'Owner Notes')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'accOwnership.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'accOwnership.dateCreated.label', default: 'Date Created')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${accOwnershipInstanceList}" status="i" var="accOwnershipInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${accOwnershipInstance.id}">${fieldValue(bean: accOwnershipInstance, field: "accOwner")}</g:link></td>
					
						<td>${fieldValue(bean: accOwnershipInstance, field: "owner")}</td>
					
						<td>${fieldValue(bean: accOwnershipInstance, field: "rights")}</td>
					
						<td>${fieldValue(bean: accOwnershipInstance, field: "ownerNotes")}</td>
					
						<td>${fieldValue(bean: accOwnershipInstance, field: "notes")}</td>
					
						<td><g:formatDate date="${accOwnershipInstance.dateCreated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${accOwnershipInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
