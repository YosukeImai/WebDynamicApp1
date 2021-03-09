<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index.css">
<title>Top Page</title>
</head>
<body>
	<div id="top-content">
		<div id="user-name">${user.name}</div>
		<form method="POST">
			<input type="hidden" name="user" id="user" value="${user}"/>
			<input type="submit" value="Add" formaction="addPost" class="top-btn"id="addBtn"/>
			 <input type="submit"value="logout" formaction="logout" class="top-btn" id="logoutBtn"/>
		</form>
	</div>
	<div class="main-content">
		<c:forEach var="post" items="${posts}">
			<div class="post-box">
				<div class="post-title" onclick="clickTitle()">${post.title}</div>
				<div class="post-created-time">${post.createdTime}</div>
				<div class="post-content">${post.content}</div>
				<form method="POST">
					<input type="submit" value="Delete" formaction="deletePost"
						class="post-btn" id="deleteBtn" />
				</form>
			</div>
		</c:forEach>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/home-event.js"></script>
</body>
</html>