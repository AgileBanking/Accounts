
<%@ page import="entities.RiskLevel" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'riskLevel.label', default: 'RiskLevel')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-riskLevel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-riskLevel" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'riskLevel.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="titleInt" title="${message(code: 'riskLevel.titleInt.label', default: 'Title Int')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'riskLevel.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'riskLevel.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'riskLevel.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${riskLevelInstanceList}" status="i" var="riskLevelInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${riskLevelInstance.id}">${fieldValue(bean: riskLevelInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: riskLevelInstance, field: "titleInt")}</td>
					
						<td>${fieldValue(bean: riskLevelInstance, field: "notes")}</td>
					
						<td><g:formatDate date="${riskLevelInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${riskLevelInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${riskLevelInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
