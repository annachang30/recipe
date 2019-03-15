<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Recipe Detail</title>
</head>
	<c:forEach begin="0" end="${detail.length() -1}" var="index">
		<h1>${detail.getJSONObject(index).get("title")}</h1>
		<p>${detail.getJSONObject(index).get("id")}</p>
		<img src="${food.getJSONObject(index).get("image")}">
		<h3>Ready in:</h3> <p>${detail.getJSONObject(index).get("readyInMinutes")} Minutes!</p>
		<h3>Instructions:</h3>
		<p>${detail.getJSONObject(index).get("instructions")}</p>
		
 
 
	</c:forEach>


</body>
</html>