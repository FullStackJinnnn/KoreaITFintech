<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% request.setCharacterEncoding("UTF-8"); %>
    	 <jsp:useBean id="cm" class="ctrl.MemberBean"/>
	 <jsp:setProperty name="cm" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입~</title>
</head>
<body>

<% 

if(cm.register()) { 
	%>
   <script>
   //alert는 페이지가 하나 넘어간 것 이므로 history(-1)을하면 alert창 나온 이전으로 돌아간다.
   alert('회원가입 성공! :D');
   history.go(-2);
   </script>
 <% } else { 
 %>
      <script>
      document.getElementById('cmMsg').hidden = true; 
     </script>
<% }%>  
	
	
	
	<h1>REGISTER</h1>
	<form method="POST">
	<input type="email" name="id" placeholder="이메일" required><br> 
	<input type="password" name="pw" placeholder="비밀번호" required><br> 
	<input type="text" name="name" placeholder="이름" required><br> 
	<input type="text" name="nickname" placeholder="닉네임" required><br> 
	<input type="text" name="birthday" placeholder="생년월일" ><br> 
	<input type="text" name="ph" placeholder="핸드폰번호" ><br>
	<input type="text" name="profile" placeholder="프로필사진" ><br> 
	<input type="submit" value="회원가입" >
	</form>
	<!--회원가입을 버튼을 눌러 실패했을때 회원가입 페이지내에서 실패했다는 
	메세지를 출력해주기 위해서 HTML에 cm.getMsg를 미리 출력해두고 
	스크립트를 사용해서 숨겨놨습니다. 이후에 cm.register() 값을 확인해서
	실패하면 숨겨짐을 해제하여 cm.getMsg를 가져오고, 아니라면 alert를 띄운후에
	로그인 화면으로 돌아갑니다.-->
	
	  <div id="cmMsg"><%=cm.getMsg()%> </div>
	 <script>
	  document.getElementById('cmMsg').hidden = false;
	  </script> 
</body>
</html>