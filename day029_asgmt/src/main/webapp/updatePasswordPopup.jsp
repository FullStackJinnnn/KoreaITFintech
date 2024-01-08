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

if(cm.updatePw()==1) { %>
 	
	<script>
	window.close();
	opener.parent.location="logout.jsp";
	alert('비번 변경완료 :D');
	
	
	</script>
	session.invalidate();
	
<% } else if (cm.updatePw()==0) {%> 
	<script>
	alert('현재 비밀번호 틀림 :D');
	</script>
<% } %>

	<script>
    // 유효성 검증 예정 
    // 비밀번호 일치 확인 VIEW에서 진행
    window.onload = function() {
        document.frm.onsubmit = function() {
            if(document.frm.updatePw.value !== document.frm.pwChk.value) {
                alert("비밀번호 일치여부를 확인하세요")
                return false;
            }
        }
    }
</script>

</head>
<body>
    <form name="frm" method="post">
        <p>현재 비밀번호 :  <input type="password" name="pw" required></p>
        <p>비밀번호 : <input type="password" name="updatePw" required></p>
        <p>비밀번호 확인 : <input type="password" name="pwChk" required></p>
	<input type="submit" value="확인" >
</form>
<input type="button" value="취소" onclick="window.close()">
	
	
	 <script>
	  document.getElementById('cmMsg').hidden = false;
	  </script>
</body>
</html>