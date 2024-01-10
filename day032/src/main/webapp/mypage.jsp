<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="model.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
<%MemberDTO mDTO = (MemberDTO)request.getAttribute("mDTO"); %>
	
 	아이디 : <%=mDTO.getMid()%>  <br>
	이름 : <%=mDTO.getName()%> <br><br>
	 
<form action="changeName.do" method="POST">
<input type="hidden" name="action" value="changeName">
변경할 이름 : <input type=text name="name"> <br> 
<input type="submit" value="이름 변경">
</form>

<a href="memberDelete.do">회원탈퇴</a>

<hr>

<a href="main.do">메인으로 돌아가기</a>

</body>
</html>