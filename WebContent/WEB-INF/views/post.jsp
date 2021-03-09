<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<title>${user.name}</title>
</head>
<body>
	<div class="main-content">
		<form action="addPost" method="post" id="postForm">
			<dl class="input">
				<dt>Title:</dt>
				<dd>
					<input type="text" name="title" size ="50" placeholder="input title" />
				</dd>
				<dt>Content:</dt>
				<dd>
					<textarea name="content" id="content" cols="50" rows="10"
						placeholder="input content"></textarea>
				</dd>
			</dl>
			<input type="button" value="Add" onClick="pushAddNewBtn()"/>
			<div class="error-msg">
				<c:if test="${errorFlg}">${loginErrorMsg}</c:if>
			</div>
		</form>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/post-event.js"></script>
</body>
</html>