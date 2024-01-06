<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="POST" action="mypage.jsp">
	<input type="submit" value="마이페이지"> 
	</form>
	   <h1><%= session.getAttribute("nickname") %>님 <small>반갑습니다.</small></h1>
      <a href="logout.jsp">로그아웃</a>
	
</body>
</html>