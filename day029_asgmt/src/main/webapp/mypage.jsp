<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="cm" class="ctrl.MemberBean" />
	<jsp:useBean id="mDTO" class="model.MemberDTO" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--  // 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.  -->

	
<% // seesion.getAttribute"(nickname)"은 object 타입이기때문에 string으로 캐스팅!
cm.setNickname((String)session.getAttribute("nickname"));
mDTO=cm.myInfo();
%>	
프로필 사진 : <%=mDTO.getProfile()%>  <br>
닉네임 : <%=mDTO.getNickname()%> <input type="submit" value="변경"> <br>
아이디 : <%=mDTO.getId()%> <br>
비밀번호 : <%=mDTO.getPw()%> <input type="submit" value="변경"> <br> 
전화번호 : <%=mDTO.getPh()%><input type="submit" value="변경"> <br>
내가 쓴 글 조회 <br>
<!-- #은 최상위 루트를 가리켜서 페이지가 없거나 index.jsp가 나온다. -->
<!-- 리턴값이 true이면 href로 연결된 링크로 이동하고 false이면 이동을 하지 않는다. -->
<!-- 무조건 팝업을 띄울것이기 떄문에 false! -->
<a href="#" onclick="return openPopUp();">회원탈퇴</a>

 
 <script>
	function openPopUp() {
		// 함수 동작 테스트 
		//alert("팝업 테스트");
		
		//window.open("[팝업을 띄울 파일명 path]", "[별칭]", "[팝업 옵션]")
		 window.open("withdrawPopup.jsp", "withdrawPopup", "width=450, height=250, top=150, left=200");
		return false;
	}
	
</script>
 
 
 

</body>
</html>