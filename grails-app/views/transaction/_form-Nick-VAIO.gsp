<%@ page import="entities.Transaction" %>



<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'account', 'error')} required">
	<label for="account">
		<g:message code="transaction.account.label" default="Account" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="account" name="account.id" from="${entities.Account.list()}" optionKey="id" required="" value="${transactionInstance?.account?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'transCode', 'error')} ">
	<label for="transCode">
		<g:message code="transaction.transCode.label" default="Trans Code" />
		
	</label>
	<g:textField name="transCode" value="${transactionInstance?.transCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'secondaryCode', 'error')} ">
	<label for="secondaryCode">
		<g:message code="transaction.secondaryCode.label" default="Secondary Code" />
		
	</label>
	<g:textField name="secondaryCode" value="${transactionInstance?.secondaryCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'dimension', 'error')} required">
	<label for="dimension">
		<g:message code="transaction.dimension.label" default="Dimension" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="dimension" type="number" value="${transactionInstance.dimension}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'amount', 'error')} required">
	<label for="amount">
		<g:message code="transaction.amount.label" default="Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="amount" value="${fieldValue(bean: transactionInstance, field: 'amount')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'refDoc', 'error')} ">
	<label for="refDoc">
		<g:message code="transaction.refDoc.label" default="Ref Doc" />
		
	</label>
	<g:textField name="refDoc" value="${transactionInstance?.refDoc}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'customerNotes', 'error')} ">
	<label for="customerNotes">
		<g:message code="transaction.customerNotes.label" default="Customer Notes" />
		
	</label>
	<g:textArea name="customerNotes" cols="40" rows="5" maxlength="255" value="${transactionInstance?.customerNotes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'bankNotes', 'error')} ">
	<label for="bankNotes">
		<g:message code="transaction.bankNotes.label" default="Bank Notes" />
		
	</label>
	<g:textArea name="bankNotes" cols="40" rows="5" maxlength="65535" value="${transactionInstance?.bankNotes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'systemNotes', 'error')} ">
	<label for="systemNotes">
		<g:message code="transaction.systemNotes.label" default="System Notes" />
		
	</label>
	<g:textArea name="systemNotes" cols="40" rows="5" maxlength="255" value="${transactionInstance?.systemNotes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'postDate', 'error')} required">
	<label for="postDate">
		<g:message code="transaction.postDate.label" default="Post Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="postDate" precision="day"  value="${transactionInstance?.postDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'valueDate', 'error')} ">
	<label for="valueDate">
		<g:message code="transaction.valueDate.label" default="Value Date" />
		
	</label>
	<g:datePicker name="valueDate" precision="day"  value="${transactionInstance?.valueDate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'availabilityDate', 'error')} ">
	<label for="availabilityDate">
		<g:message code="transaction.availabilityDate.label" default="Availability Date" />
		
	</label>
	<g:datePicker name="availabilityDate" precision="day"  value="${transactionInstance?.availabilityDate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'activationDate', 'error')} ">
	<label for="activationDate">
		<g:message code="transaction.activationDate.label" default="Activation Date" />
		
	</label>
	<g:datePicker name="activationDate" precision="day"  value="${transactionInstance?.activationDate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'deactivationDate', 'error')} ">
	<label for="deactivationDate">
		<g:message code="transaction.deactivationDate.label" default="Deactivation Date" />
		
	</label>
	<g:datePicker name="deactivationDate" precision="day"  value="${transactionInstance?.deactivationDate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'transGroupID', 'error')} ">
	<label for="transGroupID">
		<g:message code="transaction.transGroupID.label" default="Trans Group ID" />
		
	</label>
	<g:field name="transGroupID" type="number" value="${transactionInstance.transGroupID}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'transUniqueID', 'error')} required">
	<label for="transUniqueID">
		<g:message code="transaction.transUniqueID.label" default="Trans Unique ID" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="transUniqueID" type="number" value="${transactionInstance.transUniqueID}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'userID', 'error')} required">
	<label for="userID">
		<g:message code="transaction.userID.label" default="User ID" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="userID" type="number" value="${transactionInstance.userID}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'channel', 'error')} required">
	<label for="channel">
		<g:message code="transaction.channel.label" default="Channel" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="channel" type="number" value="${transactionInstance.channel}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'position', 'error')} required">
	<label for="position">
		<g:message code="transaction.position.label" default="Position" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="position" type="number" value="${transactionInstance.position}" required=""/>
</div>

