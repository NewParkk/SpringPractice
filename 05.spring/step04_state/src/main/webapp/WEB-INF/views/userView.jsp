<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
	<title>userView</title>
</head>
<body>
<h1>
	userView
</h1>

<!-- user 출력 -->
ename : ${user.ename} <br/>
level : ${user.level} <br/>
<hr>

session-ename : ${sessionScope.user.ename} <br/>
session-level : ${sessionScope.user.level} <br/>
<hr>
<a href="/user-delete">user 삭제</a>
</body>
</html>
