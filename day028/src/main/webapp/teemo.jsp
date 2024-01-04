<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="tm" class="lol.TeemoBean" />

<jsp:setProperty name="tm" property="*" />
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>티모 아이디 중복확인</title>
</head>
<body>


	<%
	String mid = request.getParameter("mid");
	tm.checkID(mid);
	
	if (request.getMethod().equals("POST")) {
		if (mid.equals("teemo")) {
			   out.println("<script>");
			    out.println("alert('중복된 아이디 입니다!!!');");
			    out.println("</script>");
		}
	}
	%>




	<form name="joinForm" method="POST">
		<h2>
			ID:<input type="text" name="mid">
		</h2>
		<input type="submit" value="중복확인">
	</form>

	<hr>
	<h2>

	
		<%-- <jsp:getProperty name="tm" property="db" /> --%>
		
		<jsp:getProperty name="tm" property="msg"/>
			<hr>
		
		DB에 들어간 아이디: <jsp:getProperty name="tm" property="db"/>
	</h2>


	<!-- 	<script type="text/javascript"> 

window.onload =function(){
	document.joinForm.onsubmit = function(){
if(!joinForm.mid.value){
	alert('아이디를 입력해주세요!');
	joinForm.mid.focus();
	return false;
}
</script>
 -->

</body>
</html>

