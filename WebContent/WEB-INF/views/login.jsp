<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<title>Login</title>
</head>
<body>
	<div class="main-content">
		<div class="content">
			<div>ログイン</div>
			<form action="login" method="post" id="loginForm">
				<input type="hidden" name="hashPassword" id="hashPass" />
				<dl class="input">
					<dt>user id:</dt>
					<dd>
						<input type="text" name="login-id" placeholder="input user id" />
					</dd>
					<dt>Password:</dt>
					<dd>
						<input type="password" name="password" id="textPass"placeholder="input password" />
					</dd>
				</dl>
				<div>
					<input type="button" value="送信" onClick="pushBtn()" />
				</div>
				<div class="error-msg">
					<c:if test="${errorFlg}">${loginErrorMsg}</c:if>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/login-menu-event.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/sha256.js"></script>
</body>
</html>