<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글쓰기</title>
</head>
<body>
<h2>글쓰기</h2>
<form action="newArticle.do" method="post">
	제목 : <input type="text" name="title"><br>
	이름 : <input type="text" name="name"><br>
	내용 : <textarea rows="5" cols="30" name="content"></textarea>
	<br>
	<input type="submit" value="전송">
</form>
</body>
</html>