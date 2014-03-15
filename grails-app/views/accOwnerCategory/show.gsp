
<%@ page import="entities.AccOwnerCategory" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'accOwnerCategory.label', default: 'AccOwnerCategory')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-accOwnerCategory" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-accOwnerCategory" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list accOwnerCategory">
			
				<g:if test="${accOwnerCategoryInstance?.categoryType}">
				<li class="fieldcontain">
					<span id="categoryType-label" class="property-label"><g:message code="accOwnerCategory.categoryType.label" default="Category Type" /></span>
					
						<span class="property-value" aria-labelledby="categoryType-label"><g:link controller="categoryType" action="show" id="${accOwnerCategoryInstance?.categoryType?.id}">${accOwnerCategoryInstance?.categoryType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnerCategoryInstance?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="accOwnerCategory.code.label" default="Code" /></span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${accOwnerCategoryInstance}" field="code"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnerCategoryInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="accOwnerCategory.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${accOwnerCategoryInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnerCategoryInstance?.titleInt}">
				<li class="fieldcontain">
					<span id="titleInt-label" class="property-label"><g:message code="accOwnerCategory.titleInt.label" default="Title Int" /></span>
					
						<span class="property-value" aria-labelledby="titleInt-label"><g:fieldValue bean="${accOwnerCategoryInstance}" field="titleInt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnerCategoryInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="accOwnerCategory.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${accOwnerCategoryInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnerCategoryInstance?.recStatus}">
				<li class="fieldcontain">
					<span id="recStatus-label" class="property-label"><g:message code="accOwnerCategory.recStatus.label" default="Rec Status" /></span>
					
						<span class="property-value" aria-labelledby="recStatus-label"><g:fieldValue bean="${accOwnerCategoryInstance}" field="recStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnerCategoryInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="accOwnerCategory.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${accOwnerCategoryInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnerCategoryInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="accOwnerCategory.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${accOwnerCategoryInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${accOwnerCategoryInstance?.accOwner}">
				<li class="fieldcontain">
					<span id="accOwner-label" class="property-label"><g:message code="accOwnerCategory.accOwner.label" default="Acc Owner" /></span>
					
						<span class="property-value" aria-labelledby="accOwner-label"><g:link controller="accOwner" action="show" id="${accOwnerCategoryInstance?.accOwner?.id}">${accOwnerCategoryInstance?.accOwner?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:accOwnerCategoryInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${accOwnerCategoryInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
