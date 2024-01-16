<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="cm" class="ctrl.MemberBean" />
	<jsp:useBean id="memberDTO" class="model.MemberDTO" />
	<%-- <%@page isErrorPage="true" %>  <%@page errorPage="mypage.jsp" %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USER INFO</title>
</head>
<body>

<!--  // 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.  -->
<% if (session.getAttribute("nickname") == null) { %>
 <!--    out.println("<script>alert('세션종료~');</script>");
	 response.sendRedirect("logout.jsp"); 
	   와 ㅡ,,,,,,여기선 왜 스크립트가 안먹냐 java코드로 하니까 됩니다!!!!!!!ㅜㅜㅜㅜㅜㅜㅜ
	 userInfo.jsp에선 js코드로 써도 잘만되던데 ,,,,,,,,,,,,,,,,,ㅜㅜㅜㅜㅜㅜㅜㅜㅜ 가아니라..
	 session에 저장된 정보가 null이 된 순간에 null을 memberDTO에 넣어서  null 값을 반환하기 때문에
	 memberDTO.getProfile()를 화면에 가져오는 시점에서 바로 에러가 일어난다. 따라서 null이 아닐떄만!
	 memberDTO.getProfile()을 화면에 가져올 수 있도록 처리를 해주자! 너무어렵다 -->
	    <script>
		alert('세션 종료 !!!');
		location.href="logout.jsp";
		</script>  
<% 	} %>

<%
// seesion.getAttribute"(nickname)"은 object 타입이기때문에 string으로 캐스팅!
cm.setNickname((String)session.getAttribute("nickname"));
memberDTO=cm.myInfo();
%>	 
<% if (session.getAttribute("nickname")!=null) { %>
프로필 사진 :<a><img src="<%=memberDTO.getProfile()%>" style="width:200px; height:200px;"> </a><br>
닉네임 : <%=memberDTO.getNickname()%> <button type="button">
  <img src="https://cdn-icons-png.flaticon.com/512/2541/2541991.png" style="width:10px; height:10px;"alt="닉네임변경" onclick="openUpdateNicknamePopUp()" >
</button> <br>
아이디 : <%=memberDTO.getId()%> <br>
비밀번호 : <%=memberDTO.getPw()%> <button type="button">
  <img src="https://cdn-icons-png.flaticon.com/512/2541/2541991.png" style="width:10px; height:10px;"alt="비밀번호변경" onclick="openUpdatePasswordPopUp()" >
</button> <br>
전화번호 : <%=memberDTO.getPh()%> <button type="button">
  <img src="https://cdn-icons-png.flaticon.com/512/2541/2541991.png" style="width:10px; height:10px;"alt="폰넘버 변경" onclick="openUpdatePhonenumberPopUp()" >
</button> <br>
등급 : <%=memberDTO.getGrade()%> <br>
<% } %>

내가 쓴 글 조회 <br>
<!-- #은 최상위 루트를 가리켜서 페이지가 없거나 index.jsp가 나온다. -->
<!-- 리턴값이 true이면 href로 연결된 링크로 이동하고 false이면 이동을 하지 않는다. -->
<!-- 무조건 팝업을 띄울것이기 떄문에 false! -->
<a href="#" onclick="return openWithdrawPopUp();">회원탈퇴</a>



 	<!-- <a><img src="https://media.bunjang.co.kr/images/crop/796975615_w320.jpg"</a>  -->
 <script>
	function openWithdrawPopUp() {
		// 함수 동작 테스트 
		//alert("팝업 테스트");
		
		//window.open("[팝업을 띄울 파일명 path]", "[별칭]", "[팝업 옵션]")
		 window.open("withdrawPopup.jsp", "withdrawPopup", "width=450, height=250, top=150, left=200");
		return false;
	}
</script>

 <script>
	function openUpdateNicknamePopUp() {
		 window.open("updateNicknamePopup.jsp", "updateNicknamePopup", "width=450, height=250, top=150, left=200");
		return false;
	}
</script>

 <script>
	function openUpdatePasswordPopUp() {
		 window.open("updatePasswordPopup.jsp", "updatePasswordPopup", "width=450, height=250, top=150, left=200");
		return false;
	}
</script>

 <script>
	function openUpdatePhonenumberPopUp() {
		 window.open("updatePhonenumberPopup.jsp", "updatePhonenumberPopup", "width=450, height=250, top=150, left=200");
		return false;
	}
</script>
 
 
 

</body>
</html>