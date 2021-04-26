<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" 
                uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout.css" type="text/css">
</head>
<body>
<div class="page-main-style">
	<h2>글쓰기</h2>
	<form:form action="insert.do" commandName="boardVO">
		<ul>
			<li>
				<label for="writer">작성자</label>
				<form:input path="writer"/>
				<form:errors cssClass="error-color" path="writer"/>
			</li>
			<li>
				<label for="title">제목</label>
				<form:input path="title"/>
				<form:errors cssClass="error-color" path="title"/>
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<form:password path="passwd"/>
				<form:errors cssClass="error-color" path="passwd"/>
			</li>
			<li>
				<label for="content">내용</label>
				<form:textarea path="content"/>
				<form:errors cssClass="error-color" path="content"/>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="등록">
			<input type="button" value="홈으로"
			        onclick="location.href='list.do'">
		</div>
	</form:form>
</div>
</body>
</html>




