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
<hr>

id : ${user.id} <br/>
age : ${user.age} <br/>
<hr>
<a href="/user-delete">user 삭제</a>
</body>
</html>
