
<%@ page import="entities.AccountStatus" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'accountStatus.label', default: 'AccountStatus')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-accountStatus" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-accountStatus" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'accountStatus.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="titleInt" title="${message(code: 'accountStatus.titleInt.label', default: 'Title Int')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'accountStatus.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="recStatus" title="${message(code: 'accountStatus.recStatus.label', default: 'Rec Status')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'accountStatus.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'accountStatus.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${accountStatusInstanceList}" status="i" var="accountStatusInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${accountStatusInstance.id}">${fieldValue(bean: accountStatusInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: accountStatusInstance, field: "titleInt")}</td>
					
						<td>${fieldValue(bean: accountStatusInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: accountStatusInstance, field: "recStatus")}</td>
					
						<td><g:formatDate date="${accountStatusInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${accountStatusInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${accountStatusInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
