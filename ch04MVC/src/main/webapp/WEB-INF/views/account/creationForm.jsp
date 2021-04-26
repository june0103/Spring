<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" 
                 uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>
</head>
<body>
<!-- form:form 커스텀 태그는 method를 명시하지 않으면 기본값으로 post로 인식 -->
<form:form action="create.do" commandName="vo">
	아이디 <form:input path="id"/>
	<form:errors path="id"/><br>
	이름 : <form:input path="name"/>
	<form:errors path="name"/><br>
	주소 : <form:input path="address"/>
	<form:errors path="address"/><br>
	<input type="submit" value="전송">
</form:form>
</body>
</html>


