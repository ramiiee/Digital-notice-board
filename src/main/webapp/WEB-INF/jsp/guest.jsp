<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
    width: 100%;
    padding: 12px 20px;
    margin: -1px 0;
    display: inline-block;
    border: 1px solid #ccc;
	border-radius: 15px 15px 0px 0px;
    box-sizing: border-box;
	
}

input[type=password] {
    width: 100%;
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
    width: 100%;
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
    padding: 230px;
	
}

.input1 {
	border-radius: 150px 50px 30px 5px:
	
}

.input3 {
border-radius: 0px 0px 0px 0px:
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
<body>


<div class="container">
	<h3>Login</h3>
	<form method="post" action="/guestlogin">
	    <input type="text" class="input1" placeholder="Enter Username" name="emailid" required/>
   		<input type="password" class="input2" placeholder="Enter Password" name="password" required/>
    	<button type="submit" value="login">Login</button>
    
	</form>
	<br>
	<h4>SignUp</h4>
	<form method="post" action="/guestregistration">
	    <input type="text" class="input1" placeholder="Enter Username" name="emailid" required/>
   		<input type="password" class="input2" placeholder="Enter Password" name="newpassword" required/>
    	<input type="text" class="input3" placeholder="Enter PhoneNumber" name="phonenumber"/>
        <button type="submit" value="login">Login</button>
    	<!--  <input type="submit" name="createaccount" value="Create Account"> -->
	</form>
	
	    
    
  </div>

 


</body>
</html>





