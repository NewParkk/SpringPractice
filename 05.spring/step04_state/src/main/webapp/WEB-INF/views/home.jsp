<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Cookie, Session
</h1>

<% 
	Cookie cookie = new Cookie("id", "dev");
	cookie.setMaxAge(60 * 60);
	response.addCookie(cookie);
	
	session.setAttribute("name", "spring");
	session.setAttribute("age", 32);
%>


<a href="/cookie-test">1. Cookie-Test</a>
[1.cookie]
(쿠키 생성)링크 클릭 -> / cookie-test -> cookieView.jsp
<hr>

<a href="/session-test1">2. Session-Test</a>
[2.session]
(세션) 생성)링크 클릭 -> / session-test1 -> sessionView.jsp
<hr>

<a href="/session-test2?id=dev&age=25">3. Session-Test</a> 
[3.session]
(세션 생성)링크 클릭 -> /session-test2?id=dev&age=25
->
@ModelAttribute - User => model 저장후
-> userView.jsp
</body>
</html>
