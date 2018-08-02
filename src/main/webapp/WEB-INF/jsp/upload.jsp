<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<body>
  
<% request.getSession(true);%>




<h1>Spring Boot file upload example</h1>
<div>
	<form method="POST" action="/upload" enctype="multipart/form-data" id="usrform" >
    	<input type="file" name="file" /><br/><br/>
    	<input type="submit" value="Submit" />
    	
    	
    	
	</form>
	<textarea rows="4" cols="50" name="comment" form="usrform">
Enter text here...</textarea>
</div>


<div>

	<c:forEach items="${imagejsonpi}" var="person">
        <p>
            ${person.name}
            <img src="./images/${person.name}" alt="face" width="250" height="250">
            
            <a href="/like?imagename=${person.name}" onclick="myFunction()" id="demo">like</a>
           <!--  <h1> ${imagelikes} </h1> -->
           <p id="${person.name}">${person.likes}</p>
          <!-- <button id="${person.name}" name="button" type="button"  onclick="location.href='/like?imagename=${person.name}'" onclick="increase(id)" >like</button>-->
          
          <a href="/favsave?username=<%=session.getAttribute("currentuser")%>&imagename=${person.name}">favorite</a>
          <!-- formaction="/like?imagename=${person.name}" -->
          <button id="${person.name}" name="button" type="button" onclick="location.href='/join?imagename=${person.name}'">join</button>
          <h4> 
em vasthale endhi endukante ipatdhaka null vundi kabatti....${person.description}  </h4>
          
          
          <h2>  ${person.likes} </h2>
            
        </p>		
			
    </c:forEach>
    
    
</div>

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