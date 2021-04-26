<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<%@ taglib prefix="form" 
                 uri="http://www.springframework.org/tags/form" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="login.form.title"/></title>
</head>
<body>
<h2><spring:message code="login.form.title"/></h2>
<form:form action="login.do" commandName="login">
	<form:errors element="div"/>
	<ul>
		<li>
			<label for="userId">
			<spring:message code="login.form.id"/></label>
			<form:input path="userId"/>
			<form:errors path="userId"/>
		</li>
		<li>
			<label for="password">
				<spring:message code="login.form.password"/>
			</label>
			<form:password path="password"/>
			<form:errors path="password"/>
		</li>
	</ul>
	<div>
		<form:button><spring:message code="login.form.submit"/></form:button>
	</div>
</form:form>
</body>
</html>



