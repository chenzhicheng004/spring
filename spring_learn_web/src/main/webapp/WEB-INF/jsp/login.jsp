<!DOCTYPE html>
<%@page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
		<title>首页</title>
	</head>
	<body>
		<c:if test="${!empty error}">
	        <font color="red"><c:out value="${error}" /></font>
		</c:if>
		<form action="<c:url value="loginCheck.html"/>" method="post">
			用户名
			<input type="text" name="username">
			<br>
			密码
			<input type="password" name="password">
			<br>
			<input type="submit" value="登陆" />
			<input type="reset" value="重置" />
		</form>
	</body>
</html>