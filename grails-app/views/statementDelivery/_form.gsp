<%@ page import="entities.StatementDelivery" %>



<div class="fieldcontain ${hasErrors(bean: statementDeliveryInstance, field: 'code', 'error')} ">
	<label for="code">
		<g:message code="statementDelivery.code.label" default="Code" />
		
	</label>
	<g:textField name="code" maxlength="3" value="${statementDeliveryInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: statementDeliveryInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="statementDelivery.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${statementDeliveryInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: statementDeliveryInstance, field: 'titleInt', 'error')} ">
	<label for="titleInt">
		<g:message code="statementDelivery.titleInt.label" default="Title Int" />
		
	</label>
	<g:textField name="titleInt" value="${statementDeliveryInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: statementDeliveryInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="statementDelivery.notes.label" default="Notes" />
		
	</label>
	<g:textArea name="notes" cols="40" rows="5" maxlength="250" value="${statementDeliveryInstance?.notes}"/>
</div>

