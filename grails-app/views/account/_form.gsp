<%@ page import="entities.Account" %>



<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'accNo', 'error')} ">
	<label for="accNo">
		<g:message code="account.accNo.label" default="Acc No" />
		
	</label>
	<g:textField name="accNo" maxlength="40" value="${accountInstance?.accNo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="account.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${accountInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'accOwner', 'error')} required">
	<label for="accOwner">
		<g:message code="account.accOwner.label" default="Acc Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="accOwner" name="accOwner.id" from="${entities.AccOwner.list()}" optionKey="id" required="" value="${accountInstance?.accOwner?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'accStatus', 'error')} required">
	<label for="accStatus">
		<g:message code="account.accStatus.label" default="Acc Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="accStatus" name="accStatus.id" from="${entities.AccountStatus.list()}" optionKey="id" required="" value="${accountInstance?.accStatus?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'accType', 'error')} required">
	<label for="accType">
		<g:message code="account.accType.label" default="Acc Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="accType" name="accType.id" from="${entities.AccountType.list()}" optionKey="id" required="" value="${accountInstance?.accType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'productPolicy', 'error')} required">
	<label for="productPolicy">
		<g:message code="account.productPolicy.label" default="Product Policy" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="productPolicy" type="number" value="${accountInstance.productPolicy}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'dateOpened', 'error')} required">
	<label for="dateOpened">
		<g:message code="account.dateOpened.label" default="Date Opened" />
		<span class="required-indicator">*</span>
	</label>
	${accountInstance?.dateOpened?.toString()}
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'lastMovement', 'error')} required">
	<label for="lastMovement">
		<g:message code="account.lastMovement.label" default="Last Movement" />
		<span class="required-indicator">*</span>
	</label>
	${accountInstance?.lastMovement?.toString()}
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'statementFreq', 'error')} required">
	<label for="statementFreq">
		<g:message code="account.statementFreq.label" default="Statement Freq" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="statementFreq" from="${accountInstance.constraints.statementFreq.inList}" required="" value="${fieldValue(bean: accountInstance, field: 'statementFreq')}" valueMessagePrefix="account.statementFreq"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'previousBalance', 'error')} required">
	<label for="previousBalance">
		<g:message code="account.previousBalance.label" default="Previous Balance" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="previousBalance" value="${fieldValue(bean: accountInstance, field: 'previousBalance')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'ytdDebit', 'error')} required">
	<label for="ytdDebit">
		<g:message code="account.ytdDebit.label" default="Ytd Debit" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ytdDebit" value="${fieldValue(bean: accountInstance, field: 'ytdDebit')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'ytdCredit', 'error')} required">
	<label for="ytdCredit">
		<g:message code="account.ytdCredit.label" default="Ytd Credit" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ytdCredit" value="${fieldValue(bean: accountInstance, field: 'ytdCredit')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'blocked', 'error')} required">
	<label for="blocked">
		<g:message code="account.blocked.label" default="Blocked" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="blocked" value="${fieldValue(bean: accountInstance, field: 'blocked')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'debitLimit', 'error')} required">
	<label for="debitLimit">
		<g:message code="account.debitLimit.label" default="Debit Limit" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="debitLimit" value="${fieldValue(bean: accountInstance, field: 'debitLimit')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'shadowAccounts', 'error')} ">
	<label for="shadowAccounts">
		<g:message code="account.shadowAccounts.label" default="Shadow Accounts" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${accountInstance?.shadowAccounts?}" var="s">
    <li><g:link controller="shadowAccount" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="shadowAccount" action="create" params="['account.id': accountInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'shadowAccount.label', default: 'ShadowAccount')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="account.notes.label" default="Notes" />
		
	</label>
	<g:textArea name="notes" cols="40" rows="5" maxlength="250" value="${accountInstance?.notes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'migratedAccNo', 'error')} ">
	<label for="migratedAccNo">
		<g:message code="account.migratedAccNo.label" default="Migrated Acc No" />
		
	</label>
	<g:textField name="migratedAccNo" value="${accountInstance?.migratedAccNo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'available', 'error')} required">
	<label for="available">
		<g:message code="account.available.label" default="Available" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="available" value="${fieldValue(bean: accountInstance, field: 'available')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'currencyIso2', 'error')} ">
	<label for="currencyIso2">
		<g:message code="account.currencyIso2.label" default="Currency Iso2" />
		
	</label>
	<g:textField name="currencyIso2" value="${accountInstance?.currencyIso2}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'excess', 'error')} required">
	<label for="excess">
		<g:message code="account.excess.label" default="Excess" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="excess" value="${fieldValue(bean: accountInstance, field: 'excess')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'feedingAccount', 'error')} required">
	<label for="feedingAccount">
		<g:message code="account.feedingAccount.label" default="Feeding Account" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="feedingAccount" name="feedingAccount.id" from="${entities.Account.list()}" optionKey="id" required="" value="${accountInstance?.feedingAccount?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'interestAccount', 'error')} required">
	<label for="interestAccount">
		<g:message code="account.interestAccount.label" default="Interest Account" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="interestAccount" name="interestAccount.id" from="${entities.Account.list()}" optionKey="id" required="" value="${accountInstance?.interestAccount?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'lastRecNo', 'error')} required">
	<label for="lastRecNo">
		<g:message code="account.lastRecNo.label" default="Last Rec No" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="lastRecNo" type="number" value="${accountInstance.lastRecNo}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'masterProduct', 'error')} required">
	<label for="masterProduct">
		<g:message code="account.masterProduct.label" default="Master Product" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="masterProduct" type="number" value="${accountInstance.masterProduct}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'maxExcessAllowed', 'error')} required">
	<label for="maxExcessAllowed">
		<g:message code="account.maxExcessAllowed.label" default="Max Excess Allowed" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="maxExcessAllowed" value="${fieldValue(bean: accountInstance, field: 'maxExcessAllowed')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'passbookLastPageLine', 'error')} required">
	<label for="passbookLastPageLine">
		<g:message code="account.passbookLastPageLine.label" default="Passbook Last Page Line" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="passbookLastPageLine" type="number" value="${accountInstance.passbookLastPageLine}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'passbookLastPrintedEvent', 'error')} required">
	<label for="passbookLastPrintedEvent">
		<g:message code="account.passbookLastPrintedEvent.label" default="Passbook Last Printed Event" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="passbookLastPrintedEvent" type="number" value="${accountInstance.passbookLastPrintedEvent}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'riskLevel', 'error')} required">
	<label for="riskLevel">
		<g:message code="account.riskLevel.label" default="Risk Level" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="riskLevel" name="riskLevel.id" from="${entities.RiskLevel.list()}" optionKey="id" required="" value="${accountInstance?.riskLevel?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'statementDelivery', 'error')} required">
	<label for="statementDelivery">
		<g:message code="account.statementDelivery.label" default="Statement Delivery" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="statementDelivery" name="statementDelivery.id" from="${entities.StatementDelivery.list()}" optionKey="id" required="" value="${accountInstance?.statementDelivery?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'statementFrequency', 'error')} required">
	<label for="statementFrequency">
		<g:message code="account.statementFrequency.label" default="Statement Frequency" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="statementFrequency" name="statementFrequency.id" from="${entities.StatementFrequency.list()}" optionKey="id" required="" value="${accountInstance?.statementFrequency?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'transactions', 'error')} ">
	<label for="transactions">
		<g:message code="account.transactions.label" default="Transactions" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${accountInstance?.transactions?}" var="t">
    <li><g:link controller="transaction" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="transaction" action="create" params="['account.id': accountInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'transaction.label', default: 'Transaction')])}</g:link>
</li>
</ul>

</div>

