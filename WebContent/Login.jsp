<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="User" method="POST">

UserName:<input type="text" name="UserName" required/>
<br/><br/>

Password:<input type="password" name="Password" required/>
<br/><br/>

<input type="submit" value="Login" name="doLogin"/>
</form >

<h3 style="color:red;">${message}</h3>



</body>
</html>