<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>음식 주문</title>
</head>
<body>
<h2>음식 주문</h2>
<form action="order.do" method="post">
	음식명 <input type="text" name="name"><br>
	수량 <input type="text" name="quantity"><br>
	전화번호 <input type="text" name="phone"><br>
	<input type="submit" value="전송">
</form>
</body>
</html>