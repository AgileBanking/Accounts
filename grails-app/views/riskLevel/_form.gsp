<%@ page import="entities.RiskLevel" %>



<div class="fieldcontain ${hasErrors(bean: riskLevelInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="riskLevel.title.label" default="Title" />
		
	</label>
	<g:textField name="title" maxlength="40" value="${riskLevelInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: riskLevelInstance, field: 'titleInt', 'error')} ">
	<label for="titleInt">
		<g:message code="riskLevel.titleInt.label" default="Title Int" />
		
	</label>
	<g:textField name="titleInt" maxlength="40" value="${riskLevelInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: riskLevelInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="riskLevel.notes.label" default="Notes" />
		
	</label>
	<g:textArea name="notes" cols="40" rows="5" maxlength="250" value="${riskLevelInstance?.notes}"/>
</div>

