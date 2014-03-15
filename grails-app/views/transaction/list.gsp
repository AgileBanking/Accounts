
<%@ page import="entities.Transaction" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'transaction.label', default: 'Transaction')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-transaction" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-transaction" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="transaction.account.label" default="Account" /></th>
					
						<g:sortableColumn property="accRecNo" title="${message(code: 'transaction.accRecNo.label', default: 'Acc Rec No')}" />
					
						<g:sortableColumn property="transCode" title="${message(code: 'transaction.transCode.label', default: 'Trans Code')}" />
					
						<g:sortableColumn property="secondaryCode" title="${message(code: 'transaction.secondaryCode.label', default: 'Secondary Code')}" />
					
						<g:sortableColumn property="dimension" title="${message(code: 'transaction.dimension.label', default: 'Dimension')}" />
					
						<g:sortableColumn property="currencyCode" title="${message(code: 'transaction.currencyCode.label', default: 'Currency Code')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${transactionInstanceList}" status="i" var="transactionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${transactionInstance.id}">${fieldValue(bean: transactionInstance, field: "account")}</g:link></td>
					
						<td>${fieldValue(bean: transactionInstance, field: "accRecNo")}</td>
					
						<td>${fieldValue(bean: transactionInstance, field: "transCode")}</td>
					
						<td>${fieldValue(bean: transactionInstance, field: "secondaryCode")}</td>
					
						<td>${fieldValue(bean: transactionInstance, field: "dimension")}</td>
					
						<td>${fieldValue(bean: transactionInstance, field: "currencyCode")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${transactionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
