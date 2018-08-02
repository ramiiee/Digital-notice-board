<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<style>
body {font-family: "Lato", sans-serif;}

div.tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}


div.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
    font-size: 17px;
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
    border: 1px solid #ccc;
    border-top: none;
}
</style>
</head>
<body>

<div class="tab">
    <button class="tablinks" onclick="openPage(event, 'Menu')">Menu</button>
  <button class="tablinks" onclick="openPage(event, 'Upload')">Upload</button>
  <button class="tablinks" onclick="openPage(event, 'Unofficial')">Unofficial</button>
  <button class="tablinks" onclick="openPage(event, 'Official')">Official</button>
  <button class="tablinks" onclick="openPage(event, 'Pinned')">Pinned</button>
</div>
<div id="Menu" class="tabcontent">
  <h3>Menu</h3>
  
</div>

<div id="Upload" class="tabcontent">
  <h3>Upload</h3>
  <p>Upload the posters!!</p>
  
<div>
	<form method="POST" action="/upload" enctype="multipart/form-data" id="usrform" >
    	<input type="file" name="file" /><br/><br/>
    	<input type="submit" value="Submit" />
    </form>
	
</div>


<!-- div>

	<c:forEach items="${imagejsonpi}" var="person">
        <p>
            ${person.name}
            <img src="./images/${person.name}" alt="face" width="250" height="250">
            
            <a href="/like?imagename=${person.name}" onclick="myFunction()" id="demo">like</a>
           
           <p id="${person.name}">${person.likes}</p>
          
          
          <a href="/favsave?username=<%=session.getAttribute("currentuser")%>&imagename=${person.name}">favorite</a>
          
          <button id="${person.name}" name="button" type="button" onclick="location.href='/join?imagename=${person.name}'">join</button>
          <h4> 
em vasthale endhi endukante ipatdhaka null vundi kabatti....${person.description}  </h4>
          
          
          <h2>  ${person.likes} </h2>
            
        		
			
    </c:forEach>
    
    
</div -->
  
</div>

<div id="Unofficial" class="tabcontent">
  <h3>Unofficial</h3>
  <p>Unofficial posters!!</p>
</div>

<div id="Official" class="tabcontent">
  <h3>Official</h3>
  <p>Official posters!!</p> 
</div>

<div id="Pinned" class="tabcontent">
  <h3>Pinned</h3>
  <p>Pinned posters!!</p>
</div>

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
</script>     

<body>
  
<% request.getSession(true);%>





<script>  
function increase(id){
	var a=id;
	var x = document.getElementById(a).innerHTML;
	x++;
	document.getElementById(a).innerHTML = x; 
	
}  
function myFunction(){
	document.getElementById("demo").style.color = "red";
	if(document.getElementById(a).innerHTML=="red"){
		
	}
}
</script>


</body>
</html>