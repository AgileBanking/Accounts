
<%@ page import="entities.Account" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'account.label', default: 'Account')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-account" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-account" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list account">
			
				<g:if test="${accountInstance?.accNo}">
				<li class="fieldcontain">
					<span id="accNo-label" class="property-label"><g:message code="account.accNo.label" default="Acc No" /></span>
					
						<span class="property-value" aria-labelledby="accNo-label"><g:fieldValue bean="${accountInstance}" field="accNo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="account.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${accountInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.parties}">
				<li class="fieldcontain">
					<span id="parties-label" class="property-label"><g:message code="account.parties.label" default="Parties" /></span>
					
						<g:each in="${accountInstance.parties}" var="p">
						<span class="property-value" aria-labelledby="parties-label"><g:link controller="contractParty" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.accStatus}">
				<li class="fieldcontain">
					<span id="accStatus-label" class="property-label"><g:message code="account.accStatus.label" default="Acc Status" /></span>
					
						<span class="property-value" aria-labelledby="accStatus-label"><g:link controller="accountStatus" action="show" id="${accountInstance?.accStatus?.id}">${accountInstance?.accStatus?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.accTypes}">
				<li class="fieldcontain">
					<span id="accTypes-label" class="property-label"><g:message code="account.accTypes.label" default="Acc Types" /></span>
					
						<g:each in="${accountInstance.accTypes}" var="a">
						<span class="property-value" aria-labelledby="accTypes-label"><g:link controller="accountType" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.productPolicy}">
				<li class="fieldcontain">
					<span id="productPolicy-label" class="property-label"><g:message code="account.productPolicy.label" default="Product Policy" /></span>
					
						<span class="property-value" aria-labelledby="productPolicy-label"><g:fieldValue bean="${accountInstance}" field="productPolicy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.dateOpened}">
				<li class="fieldcontain">
					<span id="dateOpened-label" class="property-label"><g:message code="account.dateOpened.label" default="Date Opened" /></span>
					
						<span class="property-value" aria-labelledby="dateOpened-label"><g:formatDate date="${accountInstance?.dateOpened}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.lastMovement}">
				<li class="fieldcontain">
					<span id="lastMovement-label" class="property-label"><g:message code="account.lastMovement.label" default="Last Movement" /></span>
					
						<span class="property-value" aria-labelledby="lastMovement-label"><g:formatDate date="${accountInstance?.lastMovement}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.statementFreq}">
				<li class="fieldcontain">
					<span id="statementFreq-label" class="property-label"><g:message code="account.statementFreq.label" default="Statement Freq" /></span>
					
						<span class="property-value" aria-labelledby="statementFreq-label"><g:fieldValue bean="${accountInstance}" field="statementFreq"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.balanceCalc}">
				<li class="fieldcontain">
					<span id="balanceCalc-label" class="property-label"><g:message code="account.balanceCalc.label" default="Balance Calc" /></span>
					
						<span class="property-value" aria-labelledby="balanceCalc-label"><g:fieldValue bean="${accountInstance}" field="balanceCalc"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.previousBalance}">
				<li class="fieldcontain">
					<span id="previousBalance-label" class="property-label"><g:message code="account.previousBalance.label" default="Previous Balance" /></span>
					
						<span class="property-value" aria-labelledby="previousBalance-label"><g:fieldValue bean="${accountInstance}" field="previousBalance"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.ytdDebit}">
				<li class="fieldcontain">
					<span id="ytdDebit-label" class="property-label"><g:message code="account.ytdDebit.label" default="Ytd Debit" /></span>
					
						<span class="property-value" aria-labelledby="ytdDebit-label"><g:fieldValue bean="${accountInstance}" field="ytdDebit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.ytdCredit}">
				<li class="fieldcontain">
					<span id="ytdCredit-label" class="property-label"><g:message code="account.ytdCredit.label" default="Ytd Credit" /></span>
					
						<span class="property-value" aria-labelledby="ytdCredit-label"><g:fieldValue bean="${accountInstance}" field="ytdCredit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.blocked}">
				<li class="fieldcontain">
					<span id="blocked-label" class="property-label"><g:message code="account.blocked.label" default="Blocked" /></span>
					
						<span class="property-value" aria-labelledby="blocked-label"><g:fieldValue bean="${accountInstance}" field="blocked"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.debitLimit}">
				<li class="fieldcontain">
					<span id="debitLimit-label" class="property-label"><g:message code="account.debitLimit.label" default="Debit Limit" /></span>
					
						<span class="property-value" aria-labelledby="debitLimit-label"><g:fieldValue bean="${accountInstance}" field="debitLimit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.shadowAccounts}">
				<li class="fieldcontain">
					<span id="shadowAccounts-label" class="property-label"><g:message code="account.shadowAccounts.label" default="Shadow Accounts" /></span>
					
						<g:each in="${accountInstance.shadowAccounts}" var="s">
						<span class="property-value" aria-labelledby="shadowAccounts-label"><g:link controller="shadowAccount" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="account.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${accountInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.migratedAccNo}">
				<li class="fieldcontain">
					<span id="migratedAccNo-label" class="property-label"><g:message code="account.migratedAccNo.label" default="Migrated Acc No" /></span>
					
						<span class="property-value" aria-labelledby="migratedAccNo-label"><g:fieldValue bean="${accountInstance}" field="migratedAccNo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="account.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${accountInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="account.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${accountInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="account.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${accountInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.available}">
				<li class="fieldcontain">
					<span id="available-label" class="property-label"><g:message code="account.available.label" default="Available" /></span>
					
						<span class="property-value" aria-labelledby="available-label"><g:fieldValue bean="${accountInstance}" field="available"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.currencyIso2}">
				<li class="fieldcontain">
					<span id="currencyIso2-label" class="property-label"><g:message code="account.currencyIso2.label" default="Currency Iso2" /></span>
					
						<span class="property-value" aria-labelledby="currencyIso2-label"><g:fieldValue bean="${accountInstance}" field="currencyIso2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.excess}">
				<li class="fieldcontain">
					<span id="excess-label" class="property-label"><g:message code="account.excess.label" default="Excess" /></span>
					
						<span class="property-value" aria-labelledby="excess-label"><g:fieldValue bean="${accountInstance}" field="excess"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.feedingAccount}">
				<li class="fieldcontain">
					<span id="feedingAccount-label" class="property-label"><g:message code="account.feedingAccount.label" default="Feeding Account" /></span>
					
						<span class="property-value" aria-labelledby="feedingAccount-label"><g:link controller="account" action="show" id="${accountInstance?.feedingAccount?.id}">${accountInstance?.feedingAccount?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.interestAccount}">
				<li class="fieldcontain">
					<span id="interestAccount-label" class="property-label"><g:message code="account.interestAccount.label" default="Interest Account" /></span>
					
						<span class="property-value" aria-labelledby="interestAccount-label"><g:link controller="account" action="show" id="${accountInstance?.interestAccount?.id}">${accountInstance?.interestAccount?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.lastRecNo}">
				<li class="fieldcontain">
					<span id="lastRecNo-label" class="property-label"><g:message code="account.lastRecNo.label" default="Last Rec No" /></span>
					
						<span class="property-value" aria-labelledby="lastRecNo-label"><g:fieldValue bean="${accountInstance}" field="lastRecNo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.masterProduct}">
				<li class="fieldcontain">
					<span id="masterProduct-label" class="property-label"><g:message code="account.masterProduct.label" default="Master Product" /></span>
					
						<span class="property-value" aria-labelledby="masterProduct-label"><g:fieldValue bean="${accountInstance}" field="masterProduct"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.maxExcessAllowed}">
				<li class="fieldcontain">
					<span id="maxExcessAllowed-label" class="property-label"><g:message code="account.maxExcessAllowed.label" default="Max Excess Allowed" /></span>
					
						<span class="property-value" aria-labelledby="maxExcessAllowed-label"><g:fieldValue bean="${accountInstance}" field="maxExcessAllowed"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.passbookLastPageLine}">
				<li class="fieldcontain">
					<span id="passbookLastPageLine-label" class="property-label"><g:message code="account.passbookLastPageLine.label" default="Passbook Last Page Line" /></span>
					
						<span class="property-value" aria-labelledby="passbookLastPageLine-label"><g:fieldValue bean="${accountInstance}" field="passbookLastPageLine"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.passbookLastPrintedEvent}">
				<li class="fieldcontain">
					<span id="passbookLastPrintedEvent-label" class="property-label"><g:message code="account.passbookLastPrintedEvent.label" default="Passbook Last Printed Event" /></span>
					
						<span class="property-value" aria-labelledby="passbookLastPrintedEvent-label"><g:fieldValue bean="${accountInstance}" field="passbookLastPrintedEvent"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.riskLevel}">
				<li class="fieldcontain">
					<span id="riskLevel-label" class="property-label"><g:message code="account.riskLevel.label" default="Risk Level" /></span>
					
						<span class="property-value" aria-labelledby="riskLevel-label"><g:link controller="riskLevel" action="show" id="${accountInstance?.riskLevel?.id}">${accountInstance?.riskLevel?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${accountInstance?.transactions}">
				<li class="fieldcontain">
					<span id="transactions-label" class="property-label"><g:message code="account.transactions.label" default="Transactions" /></span>
					
						<g:each in="${accountInstance.transactions}" var="t">
						<span class="property-value" aria-labelledby="transactions-label"><g:link controller="transaction" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:accountInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${accountInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
