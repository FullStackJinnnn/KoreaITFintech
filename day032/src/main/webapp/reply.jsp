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
<%
String mid=(String)session.getAttribute("mid");
request.setAttribute("rid",rDTO.getRid());
if((mid != null) && (mid.equals(rDTO.getWriter()))){
	 //로그인상태이고 본인이 작성한 글이 맞으면 출력
%>	
	댓글번호 : <%=rDTO.getRid()%> <br>
	<%-- 작성자 : <%=rDTO.getName()%> <br> --%>
	내용 : <%=rDTO.getContent()%> <br>
<form action="replyUpdate.do" method="POST">
	<input type="hidden" name="rid" value="<%=rDTO.getRid()%>">
	변경할 내용 : <input type="text" name="content" required placeholder="댓글 내용 입력"> <br>
	<input type="submit" value="내용 변경">
</form>
<a href="replyDelete.do?rid=<%=rDTO.getRid()%>">댓글 삭제</a>
<hr>

<% 
} else {
%>
	댓글번호 : <%=rDTO.getRid()%> <br>
 	작성자 : <%=rDTO.getName()!=null? rDTO.getName() : "탈퇴한 회원입니다."%> <br>
	내용 : <%=rDTO.getContent()%> <br>
<% 
	} 
%>
<br>
<a href="main.do">메인으로 돌아가기</a>
</body>
</html>