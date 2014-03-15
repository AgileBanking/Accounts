
<%@ page import="entities.StatementDelivery" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'statementDelivery.label', default: 'StatementDelivery')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-statementDelivery" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-statementDelivery" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="code" title="${message(code: 'statementDelivery.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="title" title="${message(code: 'statementDelivery.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="titleInt" title="${message(code: 'statementDelivery.titleInt.label', default: 'Title Int')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'statementDelivery.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="recStatus" title="${message(code: 'statementDelivery.recStatus.label', default: 'Rec Status')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'statementDelivery.dateCreated.label', default: 'Date Created')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${statementDeliveryInstanceList}" status="i" var="statementDeliveryInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${statementDeliveryInstance.id}">${fieldValue(bean: statementDeliveryInstance, field: "code")}</g:link></td>
					
						<td>${fieldValue(bean: statementDeliveryInstance, field: "title")}</td>
					
						<td>${fieldValue(bean: statementDeliveryInstance, field: "titleInt")}</td>
					
						<td>${fieldValue(bean: statementDeliveryInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: statementDeliveryInstance, field: "recStatus")}</td>
					
						<td><g:formatDate date="${statementDeliveryInstance.dateCreated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${statementDeliveryInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
