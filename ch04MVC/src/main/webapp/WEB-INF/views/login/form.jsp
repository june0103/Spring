<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" 
                 uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<h2>로그인</h2>
<form:form action="login.do" commandName="loginVO">
    <!-- 기본적으로 span 태그에 에러메시지를 명시하는데 div 태그로 명시하기 위해
         element 속성 사용 -->
	<form:errors element="div"/>
	아이디 : <form:input path="userId"/>
	<form:errors path="userId"/>
	<br>
	비밀번호 : <form:password path="password"/>
	<form:errors path="password"/>
	<br>
	<input type="submit" value="전송">
</form:form>
</body>
</html>




