<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>



td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 20%;
}

tr:nth-child(even) {
    background-color: #dddddd;
}



</style>

</head>
<body>

<table>
  
    <tr>
      <th>Unique views</th>
    </tr>
  
    <tr>
      <td>${uniqueviews}</td>
    </tr>
 </table>
 <br><br><br>
 <table>
 	
 	<tr>
 	<th>View Count</th>
 	</tr>
 	
    <tr>
      <td>${viewcount}</td>
    </tr>
 </table>
 <br><br><br>
 <table>
 	<tr>
    	<th>Number of Registrations</th>
    </tr>
    
      <c:forEach items="${registered}" var="person">
    	<tr>
     		 <td>${person.username}<br></td>
    	</tr>
    </c:forEach>
  </tbody>
</table>




 





</body>
</html>