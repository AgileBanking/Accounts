
<%@ page import="entities.ShadowAccount" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'shadowAccount.label', default: 'ShadowAccount')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-shadowAccount" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-shadowAccount" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="shadowAccount.account.label" default="Account" /></th>
					
						<g:sortableColumn property="dimension" title="${message(code: 'shadowAccount.dimension.label', default: 'Dimension')}" />
					
						<g:sortableColumn property="previousBalance" title="${message(code: 'shadowAccount.previousBalance.label', default: 'Previous Balance')}" />
					
						<g:sortableColumn property="ytdDebit" title="${message(code: 'shadowAccount.ytdDebit.label', default: 'Ytd Debit')}" />
					
						<g:sortableColumn property="ytdCredit" title="${message(code: 'shadowAccount.ytdCredit.label', default: 'Ytd Credit')}" />
					
						<g:sortableColumn property="available" title="${message(code: 'shadowAccount.available.label', default: 'Available')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${shadowAccountInstanceList}" status="i" var="shadowAccountInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${shadowAccountInstance.id}">${fieldValue(bean: shadowAccountInstance, field: "account")}</g:link></td>
					
						<td>${fieldValue(bean: shadowAccountInstance, field: "dimension")}</td>
					
						<td>${fieldValue(bean: shadowAccountInstance, field: "previousBalance")}</td>
					
						<td>${fieldValue(bean: shadowAccountInstance, field: "ytdDebit")}</td>
					
						<td>${fieldValue(bean: shadowAccountInstance, field: "ytdCredit")}</td>
					
						<td>${fieldValue(bean: shadowAccountInstance, field: "available")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${shadowAccountInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
