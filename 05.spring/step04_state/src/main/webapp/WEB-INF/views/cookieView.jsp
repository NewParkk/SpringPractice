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

<!-- 쿠키 출력 -->

<hr>
<!-- 그냥 cookie출력시 tomcat에서 자동생성된 쿠키와 내가만든 쿠키 2가지 -->
${cookie.id} - ${cookie.id.name} - ${cookie.id.value} 
</body>
</html>
