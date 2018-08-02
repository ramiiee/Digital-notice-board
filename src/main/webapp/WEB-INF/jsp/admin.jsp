<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



    <c:forEach items="${imagejson}" var="person">
        <p>
            <td>${person.name}</td>
            <img src="./images/${person.name}" alt="face" width="250" height="250">
       <form action="/approve?imagename1=${person.name}&description=${person.description}" method="get">
			 
			<input type="text" name="imagename1" value="${person.name}" style="visibility:hidden;">
			<input type="text" name="description" value="${person.description}" style="visibility:hidden;">
			<input type="radio" name="category" value="1" checked>Official<br>
  			<input type="radio"  name="category" value="2"> Pinned<br>
			<input type="radio"  name="category" value="3"> unofficial<br>		
			<input type="submit" name="submit" value="Approve">
			
			
		</form>
	
        
        
              
 <button onclick="location.href='/disapprove?imagename1=${person.name}'">Disapprove</button>
        
           
         </p>		
			
    </c:forEach>




</body>
</html>