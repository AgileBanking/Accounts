
<%@ page import="entities.CategoryType" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'categoryType.label', default: 'CategoryType')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-categoryType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-categoryType" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="code" title="${message(code: 'categoryType.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="title" title="${message(code: 'categoryType.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="titleInt" title="${message(code: 'categoryType.titleInt.label', default: 'Title Int')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'categoryType.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="recStatus" title="${message(code: 'categoryType.recStatus.label', default: 'Rec Status')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'categoryType.dateCreated.label', default: 'Date Created')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${categoryTypeInstanceList}" status="i" var="categoryTypeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${categoryTypeInstance.id}">${fieldValue(bean: categoryTypeInstance, field: "code")}</g:link></td>
					
						<td>${fieldValue(bean: categoryTypeInstance, field: "title")}</td>
					
						<td>${fieldValue(bean: categoryTypeInstance, field: "titleInt")}</td>
					
						<td>${fieldValue(bean: categoryTypeInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: categoryTypeInstance, field: "recStatus")}</td>
					
						<td><g:formatDate date="${categoryTypeInstance.dateCreated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${categoryTypeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
