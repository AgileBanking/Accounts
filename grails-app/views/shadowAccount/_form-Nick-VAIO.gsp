<%@ page import="entities.ShadowAccount" %>



<div class="fieldcontain ${hasErrors(bean: shadowAccountInstance, field: 'account', 'error')} required">
	<label for="account">
		<g:message code="shadowAccount.account.label" default="Account" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="account" name="account.id" from="${entities.Account.list()}" optionKey="id" required="" value="${shadowAccountInstance?.account?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: shadowAccountInstance, field: 'dimension', 'error')} required">
	<label for="dimension">
		<g:message code="shadowAccount.dimension.label" default="Dimension" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="dimension" type="number" min="1" value="${shadowAccountInstance.dimension}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: shadowAccountInstance, field: 'previousBalance', 'error')} required">
	<label for="previousBalance">
		<g:message code="shadowAccount.previousBalance.label" default="Previous Balance" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="previousBalance" value="${fieldValue(bean: shadowAccountInstance, field: 'previousBalance')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: shadowAccountInstance, field: 'ytdDebit', 'error')} required">
	<label for="ytdDebit">
		<g:message code="shadowAccount.ytdDebit.label" default="Ytd Debit" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ytdDebit" value="${fieldValue(bean: shadowAccountInstance, field: 'ytdDebit')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: shadowAccountInstance, field: 'ytdCredit', 'error')} required">
	<label for="ytdCredit">
		<g:message code="shadowAccount.ytdCredit.label" default="Ytd Credit" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ytdCredit" value="${fieldValue(bean: shadowAccountInstance, field: 'ytdCredit')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: shadowAccountInstance, field: 'available', 'error')} required">
	<label for="available">
		<g:message code="shadowAccount.available.label" default="Available" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="available" value="${fieldValue(bean: shadowAccountInstance, field: 'available')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: shadowAccountInstance, field: 'blocked', 'error')} required">
	<label for="blocked">
		<g:message code="shadowAccount.blocked.label" default="Blocked" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="blocked" value="${fieldValue(bean: shadowAccountInstance, field: 'blocked')}" required=""/>
</div>

