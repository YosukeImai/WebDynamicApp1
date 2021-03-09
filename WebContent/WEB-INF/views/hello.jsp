<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// Servletのデータ受け取り
	request.setCharacterEncoding("UTF8");
	String name = (String) request.getAttribute("name");
%>
<!DOCTYPE html>
<html>
 <head>
 <title>Hello, World!!</title>
 </head>
 <body>
 <% out.println("<p>Hello "+name+"</p>"); %>
 </body>
 </html>