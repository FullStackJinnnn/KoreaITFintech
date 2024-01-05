<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <jsp:useBean id="mMODEL" class="member.memberBean"/>
	 <jsp:setProperty name="mMODEL" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입~</title>
</head>
<body>
<%
	String mId=request.getParameter("mId");
	String mPw=request.getParameter("mPd");
	String mNickname=request.getParameter("mNickname");
	mMODEL.setmId(mId);
	mMODEL.setmId(mPw);
	mMODEL.setmId(mNickname);
%>

	<h1>REGISTER</h1>
	<form method="POST" action="registerconfirm.jsp">
	<input type="email" name="mId" placeholder="이메일" required><br> 
	<input type="password" name="mPw" placeholder="비밀번호" required><br> 
	<input type="text" name="mName" placeholder="이름" ><br> 
	<input type="text" name="mNickname" placeholder="닉네임" required><br> 
	<input type="text" name="mBirthday" placeholder="생년월일" ><br> 
	<input type="text" name="mPhonenumber" placeholder="핸드폰번호" ><br><br> 
	프로필 사진 <input type="file" name="mProfilepicture" placeholder="프로필사진" ><br><br>
	<!-- <input type="submit" value="회원가입">  -->
	<input type="submit" value="회원가입"> 
	</form>
	

</body>
</html>