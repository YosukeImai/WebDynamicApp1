<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! int count=2; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh"content="<%=count%>; URL=${url}">
<title>ページ遷移</title>
</head>
<body>
<div>このページは<%=count%>秒後に自動で遷移します</div>
</body>
</html>