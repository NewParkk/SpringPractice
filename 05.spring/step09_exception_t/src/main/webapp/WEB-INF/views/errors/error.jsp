<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Error</title>
</head>
<body>
<h1>
	Error Page  
</h1>

<P> 에러메세지 : ${exception.message} </P>

</body>
</html>