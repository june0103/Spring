<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" 
                 uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
<form:form action="write.do" commandName="vo">
	아이디 <form:input path="id"/>
	<form:errors path="id"/><br>
	비밀번호 <form:password path="password"/>
	<form:errors path="password"/><br>
	이름 <form:input path="name"/>
	<form:errors path="name"/><br>
	생년월일 <form:input path="birth"/>
	<form:errors path="birth"/><br>
	나이 <form:input path="age"/>
	<form:errors path="age"/><br>
	이메일 <form:input path="email"/>
	<form:errors path="email"/><br>
	<form:button>전송</form:button>
</form:form>
</body>
</html>




