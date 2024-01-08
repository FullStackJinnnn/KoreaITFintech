<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 상세 페이지</title>
</head>
<body>
<%ReplyDTO rDTO = (ReplyDTO)request.getAttribute("rDTO"); %>
	댓글번호 : <%=rDTO.getRid()%> <input readonly> <br>
	작성자 : <%=rDTO.getWriter()%><input disabled> <br>
	내용 : <%=rDTO.getContent()%><input> <br>
<form action="controller.jsp" method="POST">
	<input type="hidden" name="action" value="updateName">
	변경할 내용 : <input type=text name="name"> <br> 
	<input type="submit" value="내용 변경">
</form>

<a href="컨트롤러">댓글 삭제</a>

<hr>

<a href="controller.jsp?action=main">메인으로 돌아가기</a>

</body>
</html>