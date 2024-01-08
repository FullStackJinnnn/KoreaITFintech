<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
     <jsp:useBean id="cm" class="ctrl.MemberBean" />
     <jsp:setProperty name="cm" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>닉네임변경 팝업창</title>
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
//페이지 새로고쳐서 닉네임 변경 적용이 바로되는건 모르겠음
cm.setNickname((String)session.getAttribute("nickname"));
if(cm.updateNickname()) { %>
	<script>
	window.close();
	alert('닉네임 변경 완료 :D');
	</script>
	
<% } else {%> 
	<%=cm.getMsg() %>
<% } %>


<br><br>변경하실 닉네임을 입력해주세요.<br>

<form method="POST">
	<input type="text" name="updateNickname" required><br>
	<input type="submit" value="확인" >
</form>
<input type="button" value="취소" onclick="window.close()">

</body>
</html>