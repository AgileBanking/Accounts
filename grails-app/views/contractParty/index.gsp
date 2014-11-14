
<%@ page import="entities.ContractParty" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'contractParty.label', default: 'ContractParty')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-contractParty" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-contractParty" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="type" title="${message(code: 'contractParty.type.label', default: 'Type')}" />
					
						<th><g:message code="contractParty.contract.label" default="Contract" /></th>
					
						<th><g:message code="contractParty.role.label" default="Role" /></th>
					
						<g:sortableColumn property="party" title="${message(code: 'contractParty.party.label', default: 'Party')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'contractParty.notes.label', default: 'Notes')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${contractPartyInstanceList}" status="i" var="contractPartyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${contractPartyInstance.id}">${fieldValue(bean: contractPartyInstance, field: "type")}</g:link></td>
					
						<td>${fieldValue(bean: contractPartyInstance, field: "contract")}</td>
					
						<td>${fieldValue(bean: contractPartyInstance, field: "role")}</td>
					
						<td>${fieldValue(bean: contractPartyInstance, field: "party")}</td>
					
						<td>${fieldValue(bean: contractPartyInstance, field: "notes")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${contractPartyInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
