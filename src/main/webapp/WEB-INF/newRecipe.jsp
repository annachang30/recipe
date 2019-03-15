<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Recipe</title>
</head>
<body>
	<h1> Enter Ingredients</h1>
		<form:form action="/recipes/new" method="post" modelAttribute="recipeObj">
	        <form:label path="firstIng">Ingredient 1:</form:label>
	        <form:errors path="firstIng"/>
	        <form:textarea path="firstIng"/>
	    </p>
   	    <p>
	        <form:label path="secondIng">Ingredient 2:</form:label>
	        <form:errors path="secondIng"/>
	        <form:textarea path="secondIng"/>
	    </p>
	    
	    <input type="submit" value="Surprise me!"/>
	</form:form>  
</body>
</html>