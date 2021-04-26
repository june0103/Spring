<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게임 검색 엔진</title>
</head>
<body>
<h2>게임 검색</h2>
<form action="game.do" method="get">
	<select name="type">
		<option value="1">전체</option>
		<option value="2">아이템</option>
		<option value="3">캐릭터</option>
	</select>
	<input type="text" name="query">
	<input type="submit" value="검색">
</form>
</body>
</html>