<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="cm" class="ctrl.MemberBean" />
<jsp:setProperty name="cm" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME SWEET HOME</title>
</head>
<body>

	<h1>LOGIN</h1>
<% 
	if(session.isNew()){
		out.println("<script>alert('세션 생성! 로그인하면 세션 10초간 유지 ');</script>");
		
		// 기본 제공 시간 30분 (맞음!)
	}
%>
	<form method="POST" action="logincheck.jsp">
		<input type="text" name="id" placeholder="아이디" required><br>
		<input type="password" name="pw" placeholder="비밀번호" required><br>
		<br> <input type="submit" value="로그인">
	</form>
	<form method="POST" action="register.jsp">
		<input type="submit" value="회원가입">
	</form>




</body>
</html>