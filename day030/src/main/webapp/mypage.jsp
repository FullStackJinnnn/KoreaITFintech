<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="model.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
<%MemberDTO memberDTO = (MemberDTO)request.getAttribute("memberDTO"); %>
	
 	아이디 : <%=memberDTO.getMid()%>  <br>
	이름 : <%=memberDTO.getName()%> <br><br>
	 
<form action="controller.jsp" method="POST">
<input type="hidden" name="action" value="updateName">
변경할 이름 : <input type=text name="name"> <br> 
<input type="submit" value="이름 변경">
</form>

<a href="controller.jsp?action=withdraw">회원탈퇴</a>

<hr>

<a href="controller.jsp?action=main">메인으로 돌아가기</a>

</body>
</html>