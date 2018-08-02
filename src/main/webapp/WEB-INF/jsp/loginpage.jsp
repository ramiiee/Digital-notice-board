<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<style>
<head>
<h3>Welcome guys!</h3>
<title>Document</title>
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Pacifico">
</head>
form {
    border: 3px solid #f1f1f1;
	
}

input[type=text]  {
    width: 50%;
    padding: 12px 20px;
    margin: -1px 0;
    display: inline-block;
    border: 1px solid #ccc;
	border-radius: 15px 15px 0px 0px;
    box-sizing: border-box;
	
}

input[type=password] {
    width: 50%;
    padding: 12px 20px;
    margin: -1px 0;
    display: inline-block;
    
	border: 1px solid #ccc;
	border-radius: 0px 0px 0px 0px;
    box-sizing: border-box;
	
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 0px 0;
    border: none;
    cursor: pointer;
    width: 50%;
}

button:hover {
    opacity: 0.8;
}



.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}


img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 300px;
    
	
}

.input1 {
	border-radius: 150px 50px 30px 5px:
	

}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }

}

</style>
<head>


</head>
<body>


  <div class="container" style="text-align:center;">
   <form action="/welcome" method="post" >
   <h2>Notice Board</h2>
     <input type="text" class="input1" placeholder="Enter Username" name="username" required>
     <input type="password" class="input2" placeholder="Enter Password" name="password" required>   
     <button type="submit" value="login">Login</button>
    </form>
  		<a href="/guest" style="text-align:center">Guest User</a>  
  </div>
  
  

 
</form>

</body>
</html>




