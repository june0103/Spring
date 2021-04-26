<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" 
                  uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리포트 등록 폼</title>
</head>
<body>
<h2>리포트 등록</h2>
<form:form action="submitReport.do" enctype="multipart/form-data"
                                    commandName="report">
<ul>
	<li>
		<label for="subject">제목</label>
		<form:input path="subject"/>
		<form:errors path="subject"/>
	</li>
	<li>
		<label for="reportFile">리포트 파일</label>
		<input type="file" id="reportFile" name="reportFile">
		<form:errors path="reportFile"/>
	</li>
</ul>          
<div>
	<input type="submit" value="리포트 전송">
</div>                          
</form:form>
</body>
</html>


