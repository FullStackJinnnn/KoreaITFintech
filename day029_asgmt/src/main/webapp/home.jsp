<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME SWEET HOME</title>
</head>
<body>

	<h1>LOGIN</h1>

	<form method="POST" action="main.jsp">
		<input type="text" name="mid" placeholder="아이디" required><br> 
		<input type="text" name="mpw" placeholder="비밀번호"required> <br><br>
		<input type="submit" value="로그인">  
	</form>	
	<form method="POST" action="register.jsp">
		<input type="submit" value="회원가입"> 
	</form>
		
		


</body>
</html>