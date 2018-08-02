

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="home.css">
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
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
    transition: 0.5s;
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
    background-color: #64485C;
	height:58px;
}


div.tab button {
    background-color: #64485C;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 12px;
    transition: 0.3s;
    font-size: 24px;
}
div.tab1 button {
    background-color: #64485C;
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
    float: right;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 85px;
    transition: 0.3s;
    font-size: 24px;
}



div.tab button:hover {
    background-color: #83677B;
}


div.tab button.active {
    background-color: #83677B;
}


.tabcontent {
    display: none;
    padding: 6px 12px;
    /*border: 1px solid #ccc;*/
    border-top: none;
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


div.gallery img{
	display: block;
	max-width: 100%;
	max-height: 100%;
	height: 300px;
	margin: 5px 4px;	
	margin-left: 0px;
	margin-right: 0px;
	z-index: -1;
		
}













</style>

<body>
 
<div class="tab">
  <button class="tablinks" onclick="openPage(event, 'Menu')"> <span style="font-size:28px;cursor:pointer" onclick="openNav()">&#9776;Menu</span></button>
  <div class="tab1">
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
<br><br>
    
    </div>
    
    <c:forEach items="${analyticsjson}" var="person">
    <div class="gallery" >
    
    
         <a href="/analyticsdetails?imagename=${person.imagename}&username=${person.username}">
            <img src="./images/${person.imagename}" alt="face" width="100%" height="100%" class="w3-round-large">
         </a>
    	
			</div>
    </c:forEach>
    





<script>
function openPage(evt, pageName) {

    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(pageName).style.display = "block";
    evt.currentTarget.className += " active";
}
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft = "0";
}

</script>  

</body>
</html>






















