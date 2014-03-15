<%@ page import="entities.CategoryType" %>



<div class="fieldcontain ${hasErrors(bean: categoryTypeInstance, field: 'code', 'error')} ">
	<label for="code">
		<g:message code="categoryType.code.label" default="Code" />
		
	</label>
	<g:textField name="code" maxlength="6" value="${categoryTypeInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: categoryTypeInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="categoryType.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${categoryTypeInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: categoryTypeInstance, field: 'titleInt', 'error')} ">
	<label for="titleInt">
		<g:message code="categoryType.titleInt.label" default="Title Int" />
		
	</label>
	<g:textField name="titleInt" value="${categoryTypeInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: categoryTypeInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="categoryType.notes.label" default="Notes" />
		
	</label>
	<g:textArea name="notes" cols="40" rows="5" maxlength="250" value="${categoryTypeInstance?.notes}"/>
</div>

