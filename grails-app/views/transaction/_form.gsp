<%@ page import="entities.Transaction" %>



<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'account', 'error')} required">
	<label for="account">
		<g:message code="transaction.account.label" default="Account" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="account" name="account.id" from="${entities.Account.list()}" optionKey="id" required="" value="${transactionInstance?.account?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'accRecNo', 'error')} required">
	<label for="accRecNo">
		<g:message code="transaction.accRecNo.label" default="Acc Rec No" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="accRecNo" type="number" value="${transactionInstance.accRecNo}" required=""/>
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

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'currencyCode', 'error')} ">
	<label for="currencyCode">
		<g:message code="transaction.currencyCode.label" default="Currency Code" />
		
	</label>
	<g:textField name="currencyCode" value="${transactionInstance?.currencyCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'amount', 'error')} required">
	<label for="amount">
		<g:message code="transaction.amount.label" default="Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="amount" value="${fieldValue(bean: transactionInstance, field: 'amount')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'rate', 'error')} required">
	<label for="rate">
		<g:message code="transaction.rate.label" default="Rate" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="rate" value="${fieldValue(bean: transactionInstance, field: 'rate')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'localAmount', 'error')} required">
	<label for="localAmount">
		<g:message code="transaction.localAmount.label" default="Local Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="localAmount" value="${fieldValue(bean: transactionInstance, field: 'localAmount')}" required=""/>
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

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="transaction.notes.label" default="Notes" />
		
	</label>
	<g:textArea name="notes" cols="40" rows="5" maxlength="250" value="${transactionInstance?.notes}"/>
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

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'transUniqueID', 'error')} ">
	<label for="transUniqueID">
		<g:message code="transaction.transUniqueID.label" default="Trans Unique ID" />
		
	</label>
	<g:textField name="transUniqueID" value="${transactionInstance?.transUniqueID}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'isSystemAccount', 'error')} required">
	<label for="isSystemAccount">
		<g:message code="transaction.isSystemAccount.label" default="Is System Account" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="isSystemAccount" type="number" value="${transactionInstance.isSystemAccount}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'userID', 'error')} required">
	<label for="userID">
		<g:message code="transaction.userID.label" default="User ID" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="userID" type="number" value="${transactionInstance.userID}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'postSeqNo', 'error')} required">
	<label for="postSeqNo">
		<g:message code="transaction.postSeqNo.label" default="Post Seq No" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="postSeqNo" type="number" value="${transactionInstance.postSeqNo}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'approverId', 'error')} ">
	<label for="approverId">
		<g:message code="transaction.approverId.label" default="Approver Id" />
		
	</label>
	<g:field name="approverId" type="number" value="${transactionInstance.approverId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'channel', 'error')} required">
	<label for="channel">
		<g:message code="transaction.channel.label" default="Channel" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="channel" type="number" value="${transactionInstance.channel}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'orgUnit', 'error')} required">
	<label for="orgUnit">
		<g:message code="transaction.orgUnit.label" default="Org Unit" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="orgUnit" type="number" value="${transactionInstance.orgUnit}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'userId', 'error')} required">
	<label for="userId">
		<g:message code="transaction.userId.label" default="User Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="userId" type="number" value="${transactionInstance.userId}" required=""/>
</div>

