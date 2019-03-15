<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Recipes</title>
	<script src="recipe.js" type="text/javascript"></script>
</head>
<body>
	<h1> Welcome!</h1>
	
	<h4>What ingredients would you like to cook with?</h4>
	
	<h4>See below all recipes you can make with your ingredients:</h4>
	
<%-- 	<c:forEach var="i" items="${data}" varStatus="oo">
		${i.get("image")}
	</c:forEach> --%>
	

	<c:forEach begin="0" end="${food.length() -1}" var="index">
		<p>${food.getJSONObject(index).get("id")}</p>
		<p>${food.getJSONObject(index).get("title")}"</p>
     	<img src="${food.getJSONObject(index).get("image")}">
     	<a href="/recipeID/${food.getJSONObject(index).get('id')}">Link to recipe here</a>

 	     	</c:forEach>
	
</body>
</html>