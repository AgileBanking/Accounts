<%@ page import="entities.AccountStatus" %>



<div class="fieldcontain ${hasErrors(bean: accountStatusInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="accountStatus.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" maxlength="40" required="" value="${accountStatusInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountStatusInstance, field: 'titleInt', 'error')} required">
	<label for="titleInt">
		<g:message code="accountStatus.titleInt.label" default="Title Int" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titleInt" maxlength="40" required="" value="${accountStatusInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountStatusInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="accountStatus.notes.label" default="Notes" />
		
	</label>
	<g:textArea name="notes" cols="40" rows="5" maxlength="250" value="${accountStatusInstance?.notes}"/>
</div>

