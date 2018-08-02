<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title> E-NoticeBoard</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="home.css">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<style>
	
	.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #000000;
    overflow-x: hidden;
    transition: 0.3s;
    padding-top: 60px;
}

.sidenav a {

    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #FFFF00;
    display: block;
    transition: 0.3s;
}

.sidenav a:hover, .offcanvas a:focus{
    color: #FFFF00;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
div.tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
    height: 58px;
}


div.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 85px;
    transition: 0.3s;
    font-size: 24px;
}
div.tab1 button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 85px;
    transition: 0.3s;
    font-size: 24px;
}
div.tab2 button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 85px;
    transition: 0.3s;
    font-size: 24px;
}

div.tab3 button {
    background-color: green;
    float: right;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 30px;
    transition: 0.3s;
    font-size: 24px;
    
}

div.tab button:hover {
    background-color: #ddd;
}


div.tab button.active {
    background-color: #ccc;
}


.tabcontent {
    display: none;
    padding: 6px 12px;
    /*border: 1px solid #ccc;*/
    
    border-top: none;
}


body{
	position: relative;
	background: linear-gradient(to bottom right, white, #FFFFFF);
	height: 4000px;
}

a:link {
	color: #1b6192;
    text-decoration: none;
}

a:visited {
	color: #1b6192;
    text-decoration: none;
}

a:hover {
	color: #1b6192;
    text-decoration: underline;
}

a:active {
	color: #1b6192;
    text-decoration: none;
}

p6{
	color: #1b6192;
	font-family: verdana;
	font-size: 15px;
	word-spacing: 10px;
}

div.gallery{
	top: 40px;
	float: left;
	margin: 10px;
	background: white;
	width: 340px;
	height: 300px;
	border-radius: 3px/3px;
	padding-left: 0px;
	padding-right: 0px;
	padding-top: 0px;
	-webkit-box-shadow:0 3px 8px rgba(0,0,0,.25);
	overflow: hidden;
}


div.gallery button{
	background-color: white;
	border: none;
	color: black;
	width: 36px;
	height: 24px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 22px;
	margin: 0px 10px;
	cursor: pointer;
	border-radius: 0px;
	outline: none;
}


div.gallery title{
	padding: 5px;
	color: #1b6192;
	font-family: verdana;
	font-size: 20px;
	word-spacing: 0px;

}
div.gallery img{
	display: block;
	max-width: 100%;
	max-height: 100%;
	height: 230px;
	margin: 5px 4px;	
	margin-left: 0px;
	margin-right: 0px;
	z-index: -1;	
}

#color1{
	border-style: solid;
	border-color: red;
}

#color2{

	border-style: solid;
	border-color: black;

}

	
	</style>

</head>

<body>
 
 <% request.getSession(true);%>
 
<div class="tab">
  <button class="tablinks" onclick="openPage1(event, 'Menu',0)"> <span style="font-size:26px;cursor:pointer" onclick="openNav()">&#9776;Menu</span></button>
  <div class="tab1">
  <button class="tablinks" onclick="openPage(event, 'Official',1)" id="defaultOpen" ><span style="color: white">Official</span></button>
  <button class="tablinks" onclick="openPage(event, 'Pinned',2)">Pinned</button>
  <button class="tablinks" onclick="openPage(event, 'Unofficial',3)" >Unofficial</button>
</div>
<div class="tab3">
<button class="tablinks" onclick="openPage(event, 'Upload',4)">Upload</button>
</div>
</div>

<div id="Menu" class="tabcontent">

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="/home">Home</a>
  <a href="/favshow">Favourites</a>
  <a href="/analytics">Analytics</a>
  <a href="/logout">Logout</a>
</div>
</div>

<div id ="main">
<div id="Official" class="tabcontent">
  
  
  
<div>

  <c:forEach items="${imagejsonpi1}" var="person">
  	<div class="gallery" >
  		 
  		 
  		 <a target="_blank" href="/description?imagename=${person.name}">
    		<img src="./images/${person.name}" class="w3-round-large" alt="image1" width="350" height="200px">
  		</a> 
  		
  		
  		<button id="demo" name="button" type="button" onclick="location.href='/like?imagename=${person.name}'"><i class="fa fa-heart" alt="Submit" style="color: #ff4000"></i></button>
  		
  		 ${person.likes} 
  		
  		<button id="${person.name}" 
  		name="button" type="button" onclick="location.href='/favsave?username=<%=session.getAttribute("currentuser")%>&imagename=${person.name}'"><i class="fa fa-star" alt="Submit" style="color: #ff4000"></i></button>
  		
  		 
  	</div>
        
    </c:forEach>
    
    
</div>

</div>

<div id="Pinned" class="tabcontent">
  
  <div>

  <c:forEach items="${imagejsonpi2}" var="person">
  	<div class="gallery">
  		 
  		 
  		 <a target="_blank" href="/description?imagename=${person.name}">
    		<img src="./images/${person.name}" class="w3-round-large" alt="image1" width="350" height="200px">
  		</a> 
  		
  		 <!--  h4>${person.description}</h4>-->
  		
  		
  		<button id="demo" name="button" type="button" onclick="location.href='/like?imagename=${person.name}'"><i class="fa fa-heart" alt="Submit" style="color: #ff4000"></i></button>
  		
  		 ${person.likes} 
  		
  		<button id="${person.name}" 
  		name="button" type="button" onclick="location.href='/favsave?username=<%=session.getAttribute("currentuser")%>&imagename=${person.name}'"><i class="fa fa-star" alt="Submit" style="color: #ff4000"></i></button>
  		
  		 
  	</div>
        
    </c:forEach>
    
    
</div>
  
  
  
</div>

<div id="Unofficial" class="tabcontent">
  
  <div>

  <c:forEach items="${imagejsonpi3}" var="person">
  	<div class="gallery"   >
  		 
  		 
  		 <a target="_blank" href="/description?imagename=${person.name}">
    		<img src="./images/${person.name}" class="w3-round-large" alt="image1" width="350" height="200px">
  		</a> 
  		
  		
  		<button id="demo" name="button" type="button" onclick="location.href='/like?imagename=${person.name}'"><i class="fa fa-heart" alt="Submit" style="color: #ff4000"></i></button>
  		
  		
  		 ${person.likes} 
  		
  		
  		<button id="${person.name}" 
  		name="button" type="button" onclick="location.href='/favsave?username=<%=session.getAttribute("currentuser")%>&imagename=${person.name}'"><i class="fa fa-star" alt="Submit" style="color: #ff4000"></i></button>
  		
  		 
  	</div>
        
    </c:forEach>
    
    
    
</div>
</div>

<div id="Upload" class="tabcontent">
    
    <div>
  <form method="POST" action="/upload" enctype="multipart/form-data" id="usrform" >
      <input type="file" name="file" /><br/><br/>
      
  
  <input type="radio" name="gender" value="visible" checked> I need a button for registration<br>
  <input type="radio" name="gender" value="hidden"> I don't need a button as there is no registration<br>
    
  <textarea rows="4" cols="50" name="comment" form="usrform">Enter text here</textarea>
  <br> 
   <input type="submit" value="Submit" /> 
      
  </form>
    
    
</div>
</div>

</div>


<script>
function openPage1(evt, pageName, pagenumber){
	
	document.getElementById(pageName).style.display = "block";
    evt.currentTarget.className += " active";
    
	
}

function openPage(evt, pageName, pagenumber) {
	
	
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    //tabcontent[1].style.display="block";
    
    //if(pageumber==0){
    //tabcontent[pagenumber].style.display="block";
    //}
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(pageName).style.display = "block";
    evt.currentTarget.className += " active";
    
    
    /*
    tabcontent[pagenumber].style.display="block";
    document.getElementById(pagename).style.display="block";*/
    
}
document.getElementById("defaultOpen").click();
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft = "0";
}

</script>  





<script type="text/javascript">
var i1=i2=i3=0;
var j1=j2=j3=0;
function increase11()
{i1++;
document.getElementById('likeButton1').innerHTML= i1;}
function increase12()
{j1++;
document.getElementById('commentButton1').innerHTML= j1;}

function increase21()
{i2++;
document.getElementById('likeButton2').innerHTML= i2;}
function increase22()
{j2++;
document.getElementById('commentButton2').innerHTML= j2;}

function increase31()
{i3++;
document.getElementById('likeButton3').innerHTML= i3;}
function increase32()
{j3++;
document.getElementById('commentButton3').innerHTML= j3;}

</script>












</body>
</html>