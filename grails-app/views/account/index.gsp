
<%@ page import="entities.Account" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'account.label', default: 'Account')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-account" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-account" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="accNo" title="${message(code: 'account.accNo.label', default: 'Acc No')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'account.name.label', default: 'Name')}" />
					
						<th><g:message code="account.accStatus.label" default="Acc Status" /></th>
					
						<g:sortableColumn property="productPolicy" title="${message(code: 'account.productPolicy.label', default: 'Product Policy')}" />
					
						<g:sortableColumn property="dateOpened" title="${message(code: 'account.dateOpened.label', default: 'Date Opened')}" />
					
						<g:sortableColumn property="lastMovement" title="${message(code: 'account.lastMovement.label', default: 'Last Movement')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${accountInstanceList}" status="i" var="accountInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${accountInstance.id}">${fieldValue(bean: accountInstance, field: "accNo")}</g:link></td>
					
						<td>${fieldValue(bean: accountInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: accountInstance, field: "accStatus")}</td>
					
						<td>${fieldValue(bean: accountInstance, field: "productPolicy")}</td>
					
						<td><g:formatDate date="${accountInstance.dateOpened}" /></td>
					
						<td><g:formatDate date="${accountInstance.lastMovement}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${accountInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
