<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <jsp:useBean id="cm" class="ctrl.MemberBean" />
     <jsp:setProperty name="cm" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴 확인 팝업창</title>
</head>

<body>
<%-- 알아두면 좋은거 onunload="closePopup()" 
-> 'x'를 눌러도 '확인'버튼과 동일하게 작동되도록 해줌 --%>
<% if (session.getAttribute("nickname") == null) { %>
		<script>alert('세션 종료 !!!')
		location.href="logout.jsp"
		</script>
<%} %>

<%
cm.setNickname((String)session.getAttribute("nickname"));

if(cm.withdraw()) { %>
 	
	<script>
	window.close();
	opener.parent.location="logout.jsp";
	alert('잘가라~! :D');
	
	
	</script>
	session.invalidate();
	
<% } else {%> 
	<%=cm.getMsg() %>
<% } %>
<script>
	function closePopup() {
		//자신(팝업)을 종료한다.
		self.close();
	}
</script>

<br><br>정말 탈퇴하시겠습니까?<br><br>
비밀번호를 입력해주세요.
<form method="POST" >
	<input type="password" name="pw" required><br>
	<input type="submit" value="확인" >
</form>
<input type="button" value="취소" onclick="closePopup()">
	
	
	 <script>
	  document.getElementById('cmMsg').hidden = false;
	  </script>
</body>
</html>