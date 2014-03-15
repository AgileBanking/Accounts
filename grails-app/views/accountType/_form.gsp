<%@ page import="entities.AccountType" %>



<div class="fieldcontain ${hasErrors(bean: accountTypeInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="accountType.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" maxlength="40" required="" value="${accountTypeInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountTypeInstance, field: 'titleInt', 'error')} required">
	<label for="titleInt">
		<g:message code="accountType.titleInt.label" default="Title Int" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titleInt" maxlength="40" required="" value="${accountTypeInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountTypeInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="accountType.notes.label" default="Notes" />
		
	</label>
	<g:textArea name="notes" cols="40" rows="5" maxlength="250" value="${accountTypeInstance?.notes}"/>
</div>

