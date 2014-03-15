
<%@ page import="entities.StatementFrequency" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'statementFrequency.label', default: 'StatementFrequency')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-statementFrequency" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-statementFrequency" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="code" title="${message(code: 'statementFrequency.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="title" title="${message(code: 'statementFrequency.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="titleInt" title="${message(code: 'statementFrequency.titleInt.label', default: 'Title Int')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'statementFrequency.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="recStatus" title="${message(code: 'statementFrequency.recStatus.label', default: 'Rec Status')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'statementFrequency.dateCreated.label', default: 'Date Created')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${statementFrequencyInstanceList}" status="i" var="statementFrequencyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${statementFrequencyInstance.id}">${fieldValue(bean: statementFrequencyInstance, field: "code")}</g:link></td>
					
						<td>${fieldValue(bean: statementFrequencyInstance, field: "title")}</td>
					
						<td>${fieldValue(bean: statementFrequencyInstance, field: "titleInt")}</td>
					
						<td>${fieldValue(bean: statementFrequencyInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: statementFrequencyInstance, field: "recStatus")}</td>
					
						<td><g:formatDate date="${statementFrequencyInstance.dateCreated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${statementFrequencyInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
