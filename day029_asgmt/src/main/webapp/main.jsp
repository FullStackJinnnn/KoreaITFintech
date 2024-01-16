<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if (session.getAttribute("nickname") == null) {%>
		<script>
		document.write(session.getAttribute("nickname"));
		alert('세션 종료 !!!');
		session.invalidate();
		/* location.href="logout.jsp"; */
		</script>
	<%} %>
	<!-- //"POST" 로 전달할 경우 마이페이지에서 닉네임 변경 후 새로고침시 에러발생 -->
	<button onclick="location.href='mypage.jsp'">마이페이지</button>
	 
	  <h1><%= session.getAttribute("nickname") %>님 <small>반갑습니다.</small></h1>   <a href="logout.jsp">로그아웃</a>
	  <br><br>
	  게시글 : 카메라 무료나눔 없나요 ㅠ       - <a href="userInfo.jsp?userName=사진찍는팬더">사진찍는팬더</a>
     
	
</body>
</html>

<%-- <% // seesion.getAttribute"(nickname)"은 object 타입이기때문에 string으로 캐스팅!
cm.setNickname((String)session.getAttribute("nickname"));
memberDTO=cm.myInfo();
%>	 --%>