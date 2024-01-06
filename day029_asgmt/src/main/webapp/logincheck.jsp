<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="cm" class="ctrl.MemberBean" />
<jsp:setProperty name="cm" property="*" />
<!-- 이 setProperty는 home에서 보낸 id랑 pw를 cm객체에 set 해준것이다! 
페이지끼리의 데이터 전달시에 사용하는 것 인가보다-->

<!-- MemberBean의 login() 메서드에서 MemberBean 객체를 만든 후에 
그 객체를 cm에게 대입해도 되지만, DTO가 전달하는 가방 처럼 쓰이는 게 맞는 것 같아서
DTO를 사용해 사용자가 입력한 id,pw를 가지고있는 사람의 "nickname"만 가져왔다. 
MemberDAO의 쿼리문 참고-->
<jsp:useBean id="mDTO" class="model.MemberDTO" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 체크</title>
</head>
<body>

<%

if(cm.login()!=null){ 
	mDTO=cm.login();
	//로그인 하는 순간 세션은 10초만 유지됩니다.
	//10초가 끝나면 자동으로 로그아웃되고 세션이 초기화 됩니다.
	//따라서 로그인 이후 기능들을 사용할 수 없습니다.
	//다른 창으로 이동하게 되면 세션유지가 계속 초기화된다!
	//ex) 로그인 후 마이페이지를 왔다갔다하면 세션 종료가 안됨.
	//따라서 로그인 후 아무것도 안하면 5초간 유지.
		session.setAttribute("nickname", mDTO.getNickname());
		session.setMaxInactiveInterval(20); //1분간 아이디 유지
		out.println("<script>alert('로그인은 5초간 유지됩니다.');</script>");

%>
<script>location.href="main.jsp";</script>

<% } else {%>
<script>
	alert('로그인실패');
	history.go(-1);
</script> 
<% } %>


</body>
</html>