<%@ page import="entities.StatementFrequency" %>



<div class="fieldcontain ${hasErrors(bean: statementFrequencyInstance, field: 'code', 'error')} ">
	<label for="code">
		<g:message code="statementFrequency.code.label" default="Code" />
		
	</label>
	<g:textField name="code" maxlength="3" value="${statementFrequencyInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: statementFrequencyInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="statementFrequency.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${statementFrequencyInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: statementFrequencyInstance, field: 'titleInt', 'error')} ">
	<label for="titleInt">
		<g:message code="statementFrequency.titleInt.label" default="Title Int" />
		
	</label>
	<g:textField name="titleInt" value="${statementFrequencyInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: statementFrequencyInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="statementFrequency.notes.label" default="Notes" />
		
	</label>
	<g:textArea name="notes" cols="40" rows="5" value="${statementFrequencyInstance?.notes}"/>
</div>

