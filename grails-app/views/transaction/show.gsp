
<%@ page import="entities.Transaction" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'transaction.label', default: 'Transaction')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-transaction" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-transaction" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list transaction">
			
				<g:if test="${transactionInstance?.account}">
				<li class="fieldcontain">
					<span id="account-label" class="property-label"><g:message code="transaction.account.label" default="Account" /></span>
					
						<span class="property-value" aria-labelledby="account-label"><g:link controller="account" action="show" id="${transactionInstance?.account?.id}">${transactionInstance?.account?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.accRecNo}">
				<li class="fieldcontain">
					<span id="accRecNo-label" class="property-label"><g:message code="transaction.accRecNo.label" default="Acc Rec No" /></span>
					
						<span class="property-value" aria-labelledby="accRecNo-label"><g:fieldValue bean="${transactionInstance}" field="accRecNo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.transCode}">
				<li class="fieldcontain">
					<span id="transCode-label" class="property-label"><g:message code="transaction.transCode.label" default="Trans Code" /></span>
					
						<span class="property-value" aria-labelledby="transCode-label"><g:fieldValue bean="${transactionInstance}" field="transCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.secondaryCode}">
				<li class="fieldcontain">
					<span id="secondaryCode-label" class="property-label"><g:message code="transaction.secondaryCode.label" default="Secondary Code" /></span>
					
						<span class="property-value" aria-labelledby="secondaryCode-label"><g:fieldValue bean="${transactionInstance}" field="secondaryCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.dimension}">
				<li class="fieldcontain">
					<span id="dimension-label" class="property-label"><g:message code="transaction.dimension.label" default="Dimension" /></span>
					
						<span class="property-value" aria-labelledby="dimension-label"><g:fieldValue bean="${transactionInstance}" field="dimension"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.currencyCode}">
				<li class="fieldcontain">
					<span id="currencyCode-label" class="property-label"><g:message code="transaction.currencyCode.label" default="Currency Code" /></span>
					
						<span class="property-value" aria-labelledby="currencyCode-label"><g:fieldValue bean="${transactionInstance}" field="currencyCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.amount}">
				<li class="fieldcontain">
					<span id="amount-label" class="property-label"><g:message code="transaction.amount.label" default="Amount" /></span>
					
						<span class="property-value" aria-labelledby="amount-label"><g:fieldValue bean="${transactionInstance}" field="amount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.rate}">
				<li class="fieldcontain">
					<span id="rate-label" class="property-label"><g:message code="transaction.rate.label" default="Rate" /></span>
					
						<span class="property-value" aria-labelledby="rate-label"><g:fieldValue bean="${transactionInstance}" field="rate"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.localAmount}">
				<li class="fieldcontain">
					<span id="localAmount-label" class="property-label"><g:message code="transaction.localAmount.label" default="Local Amount" /></span>
					
						<span class="property-value" aria-labelledby="localAmount-label"><g:fieldValue bean="${transactionInstance}" field="localAmount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.refDoc}">
				<li class="fieldcontain">
					<span id="refDoc-label" class="property-label"><g:message code="transaction.refDoc.label" default="Ref Doc" /></span>
					
						<span class="property-value" aria-labelledby="refDoc-label"><g:fieldValue bean="${transactionInstance}" field="refDoc"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.customerNotes}">
				<li class="fieldcontain">
					<span id="customerNotes-label" class="property-label"><g:message code="transaction.customerNotes.label" default="Customer Notes" /></span>
					
						<span class="property-value" aria-labelledby="customerNotes-label"><g:fieldValue bean="${transactionInstance}" field="customerNotes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="transaction.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${transactionInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.systemNotes}">
				<li class="fieldcontain">
					<span id="systemNotes-label" class="property-label"><g:message code="transaction.systemNotes.label" default="System Notes" /></span>
					
						<span class="property-value" aria-labelledby="systemNotes-label"><g:fieldValue bean="${transactionInstance}" field="systemNotes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.postDate}">
				<li class="fieldcontain">
					<span id="postDate-label" class="property-label"><g:message code="transaction.postDate.label" default="Post Date" /></span>
					
						<span class="property-value" aria-labelledby="postDate-label"><g:formatDate date="${transactionInstance?.postDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.valueDate}">
				<li class="fieldcontain">
					<span id="valueDate-label" class="property-label"><g:message code="transaction.valueDate.label" default="Value Date" /></span>
					
						<span class="property-value" aria-labelledby="valueDate-label"><g:formatDate date="${transactionInstance?.valueDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.availabilityDate}">
				<li class="fieldcontain">
					<span id="availabilityDate-label" class="property-label"><g:message code="transaction.availabilityDate.label" default="Availability Date" /></span>
					
						<span class="property-value" aria-labelledby="availabilityDate-label"><g:formatDate date="${transactionInstance?.availabilityDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.activationDate}">
				<li class="fieldcontain">
					<span id="activationDate-label" class="property-label"><g:message code="transaction.activationDate.label" default="Activation Date" /></span>
					
						<span class="property-value" aria-labelledby="activationDate-label"><g:formatDate date="${transactionInstance?.activationDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.deactivationDate}">
				<li class="fieldcontain">
					<span id="deactivationDate-label" class="property-label"><g:message code="transaction.deactivationDate.label" default="Deactivation Date" /></span>
					
						<span class="property-value" aria-labelledby="deactivationDate-label"><g:formatDate date="${transactionInstance?.deactivationDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.transGroupID}">
				<li class="fieldcontain">
					<span id="transGroupID-label" class="property-label"><g:message code="transaction.transGroupID.label" default="Trans Group ID" /></span>
					
						<span class="property-value" aria-labelledby="transGroupID-label"><g:fieldValue bean="${transactionInstance}" field="transGroupID"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.transUniqueID}">
				<li class="fieldcontain">
					<span id="transUniqueID-label" class="property-label"><g:message code="transaction.transUniqueID.label" default="Trans Unique ID" /></span>
					
						<span class="property-value" aria-labelledby="transUniqueID-label"><g:fieldValue bean="${transactionInstance}" field="transUniqueID"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.isSystemAccount}">
				<li class="fieldcontain">
					<span id="isSystemAccount-label" class="property-label"><g:message code="transaction.isSystemAccount.label" default="Is System Account" /></span>
					
						<span class="property-value" aria-labelledby="isSystemAccount-label"><g:fieldValue bean="${transactionInstance}" field="isSystemAccount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.userID}">
				<li class="fieldcontain">
					<span id="userID-label" class="property-label"><g:message code="transaction.userID.label" default="User ID" /></span>
					
						<span class="property-value" aria-labelledby="userID-label"><g:fieldValue bean="${transactionInstance}" field="userID"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.postSeqNo}">
				<li class="fieldcontain">
					<span id="postSeqNo-label" class="property-label"><g:message code="transaction.postSeqNo.label" default="Post Seq No" /></span>
					
						<span class="property-value" aria-labelledby="postSeqNo-label"><g:fieldValue bean="${transactionInstance}" field="postSeqNo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.approverId}">
				<li class="fieldcontain">
					<span id="approverId-label" class="property-label"><g:message code="transaction.approverId.label" default="Approver Id" /></span>
					
						<span class="property-value" aria-labelledby="approverId-label"><g:fieldValue bean="${transactionInstance}" field="approverId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.channel}">
				<li class="fieldcontain">
					<span id="channel-label" class="property-label"><g:message code="transaction.channel.label" default="Channel" /></span>
					
						<span class="property-value" aria-labelledby="channel-label"><g:fieldValue bean="${transactionInstance}" field="channel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.orgUnit}">
				<li class="fieldcontain">
					<span id="orgUnit-label" class="property-label"><g:message code="transaction.orgUnit.label" default="Org Unit" /></span>
					
						<span class="property-value" aria-labelledby="orgUnit-label"><g:fieldValue bean="${transactionInstance}" field="orgUnit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="transaction.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${transactionInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="transaction.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${transactionInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${transactionInstance?.userId}">
				<li class="fieldcontain">
					<span id="userId-label" class="property-label"><g:message code="transaction.userId.label" default="User Id" /></span>
					
						<span class="property-value" aria-labelledby="userId-label"><g:fieldValue bean="${transactionInstance}" field="userId"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:transactionInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${transactionInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
