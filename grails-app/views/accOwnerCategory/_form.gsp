<%@ page import="entities.AccOwnerCategory" %>



<div class="fieldcontain ${hasErrors(bean: accOwnerCategoryInstance, field: 'categoryType', 'error')} required">
	<label for="categoryType">
		<g:message code="accOwnerCategory.categoryType.label" default="Category Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="categoryType" name="categoryType.id" from="${entities.CategoryType.list()}" optionKey="id" required="" value="${accOwnerCategoryInstance?.categoryType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accOwnerCategoryInstance, field: 'code', 'error')} ">
	<label for="code">
		<g:message code="accOwnerCategory.code.label" default="Code" />
		
	</label>
	<g:textField name="code" maxlength="6" value="${accOwnerCategoryInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accOwnerCategoryInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="accOwnerCategory.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${accOwnerCategoryInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accOwnerCategoryInstance, field: 'titleInt', 'error')} ">
	<label for="titleInt">
		<g:message code="accOwnerCategory.titleInt.label" default="Title Int" />
		
	</label>
	<g:textField name="titleInt" value="${accOwnerCategoryInstance?.titleInt}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accOwnerCategoryInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="accOwnerCategory.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${accOwnerCategoryInstance?.notes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accOwnerCategoryInstance, field: 'accOwner', 'error')} required">
	<label for="accOwner">
		<g:message code="accOwnerCategory.accOwner.label" default="Acc Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="accOwner" name="accOwner.id" from="${entities.AccOwner.list()}" optionKey="id" required="" value="${accOwnerCategoryInstance?.accOwner?.id}" class="many-to-one"/>
</div>

