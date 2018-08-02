<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<style type="text/css">
	.w3-btn{width:150px;}
	</style>

</head>

<body bgcolor="#ADADAD">
	<center>
		<h3>Description</h3>
		<img src="./images/${imagename}" width="350" height="400">
		<h2>${description}</h2>
	</center>
	
	<center>
		<button class="w3-button w3-black w3-round-large" onclick="location.href='/join?imagename=${imagename}'" id="myBtn" style="visibility:${buttonornot};">JOIN</button>
	</center>

</body>
</html>






