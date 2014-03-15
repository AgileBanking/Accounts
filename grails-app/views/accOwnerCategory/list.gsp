
<%@ page import="entities.AccOwnerCategory" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'accOwnerCategory.label', default: 'AccOwnerCategory')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-accOwnerCategory" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-accOwnerCategory" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="accOwnerCategory.categoryType.label" default="Category Type" /></th>
					
						<g:sortableColumn property="code" title="${message(code: 'accOwnerCategory.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="title" title="${message(code: 'accOwnerCategory.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="titleInt" title="${message(code: 'accOwnerCategory.titleInt.label', default: 'Title Int')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'accOwnerCategory.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="recStatus" title="${message(code: 'accOwnerCategory.recStatus.label', default: 'Rec Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${accOwnerCategoryInstanceList}" status="i" var="accOwnerCategoryInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${accOwnerCategoryInstance.id}">${fieldValue(bean: accOwnerCategoryInstance, field: "categoryType")}</g:link></td>
					
						<td>${fieldValue(bean: accOwnerCategoryInstance, field: "code")}</td>
					
						<td>${fieldValue(bean: accOwnerCategoryInstance, field: "title")}</td>
					
						<td>${fieldValue(bean: accOwnerCategoryInstance, field: "titleInt")}</td>
					
						<td>${fieldValue(bean: accOwnerCategoryInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: accOwnerCategoryInstance, field: "recStatus")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${accOwnerCategoryInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
