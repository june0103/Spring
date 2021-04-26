<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/hello.do">HelloController</a><br>
<a href="${pageContext.request.contextPath}/search/internal.do?query=kim&p=2">SearchController - /search/internal.do?query=kim&p=2</a><br>
<a href="${pageContext.request.contextPath}/search/external.do">SearchController - /search/external.do</a><br>
<a href="${pageContext.request.contextPath}/article/newArticleForm.do">NewArticleController</a><br>
<a href="${pageContext.request.contextPath}/order/order.do">OrderController</a><br>
<a href="${pageContext.request.contextPath}/cookie/make.do">CookieController - make.do</a><br>
<a href="${pageContext.request.contextPath}/cookie/view.do">CookieController - view.do</a><br>
<a href="${pageContext.request.contextPath}/search/main.do">GameSearchController</a><br>
<a href="${pageContext.request.contextPath}/account/create.do">CreateAccountController</a><br>
<a href="${pageContext.request.contextPath}/login/login.do">LoginController</a><br>
<a href="${pageContext.request.contextPath}/report/submitReport.do">SubmitReportController</a><br>
<a href="${pageContext.request.contextPath}/member/write.do">MemberWriteController</a><br>
아래 링크를 눌러서 로케일을 지정한 후 로그인 하시오.<br>
<a href="${pageContext.request.contextPath}/changeLanguage.do?lang=ko">/changeLanguage.do?lang=ko</a><br>
<a href="${pageContext.request.contextPath}/changeLanguage.do?lang=en">/changeLanguage.do?lang=en</a><br>
<a href="${pageContext.request.contextPath}/login2/login.do">LoginController(국제화)</a><br>
<a href="${pageContext.request.contextPath}/pageJsonReport.do">PageReportController</a><br>








</body>
</html>