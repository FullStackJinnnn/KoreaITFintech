<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.dto.*,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<style type="text/css">
	 .info {
		width: 250px;
	} 
	a{
    text-decoration: none;
	}
</style>
</head>
<body>

<%

	String mid=(String)session.getAttribute("mid");
	if(mid != null){ // 로그인 상태
		
%>
<script>
 document.querySelector('body').style.backgroundColor = 'orange';
	 </script>
		<a href="logout.do">로그아웃</a> | <a href="myPage.do">마이페이지</a>

<%
	}
	else{ // 로그아웃 상태
	
	
%>
		<a href="loginPage.do">로그인</a> | <a href="joinPage.do">회원가입</a>
<%
	}
%>

<hr>

<ul>
	<%
		ArrayList<ReplyDTO> rdatas=(ArrayList<ReplyDTO>)request.getAttribute("rdatas");
		if(rdatas.size()<=0){
			out.println("출력할 댓글이 없습니다!");
		}
		else{
			for(ReplyDTO data:rdatas){
	%>
			<li><a href="replySelectOne.do?rid=<%=data.getRid()%>"><%=data.getRid()%>번 댓글 <%= data.getName() != null ? data.getName() + "님이 작성" : "탈퇴한 회원입니다" %></a></li>
	<%
			}
		}
	%>
</ul>

<hr>

		<form action="replyInsert.do" method="POST">
			
			<%
				if(mid != null){
			%>	
		<!-- 	오호 hidden으로 value를 보내서 set해줄수도 있구나 ~_~ -->
			<input type="text" name="content" required placeholder="댓글 내용 입력"> <br>
			<input type="hidden" name="writer" value="<%=mid%>" >
				
				
				<input type="submit" value="댓글추가">
			<%		
				}
				else{ // 로그아웃 상태라면
			%>
				<input class="info" type="text" name="content" disabled value="댓글을 작성하시려면 로그인하세요."> <br>
			<%
				}
			%>
		
		</form>

<hr>

<ul>
	<%
		ArrayList<MemberDTO> mdatas=(ArrayList<MemberDTO>)request.getAttribute("mdatas");
		if(mdatas.size()<=0){
			out.println("출력할 회원이 없습니다!");
		}
		else{
			for(MemberDTO data:mdatas){
	%>
				<li><%=data.getName()%>님</li>
	<%
			}
		}
	%>
</ul>

</body>
</html>