<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
	<title>sessionView</title>
</head>
<body>
<h1>
	sessionView
</h1>

<!-- session 출력 -->
<hr>

name : ${sessionScope.name} <br/>
age : ${sessionScope.age} <br/>
grade : ${sessionScope.grade} <br/>
<hr>
<a href="/grade-delete">1. grade 값만 삭제</a>
</body>
</html>
