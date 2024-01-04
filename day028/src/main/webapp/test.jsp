<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<!-- HTML 주석 -->
<%-- JSP 주석 --%>
<h1><%= new java.util.Date() %></h1>  
<%
//<%@ 지시어
//<%= 표현식
//<% 스크립트립
//java.util은 자동임포트가 되지않는다 자바처럼... 지시어 작성란쪽에 적어줘야함.
%>


<% //이표시를 하면 자바영역이된다!!!!!!!!
	//상단의 page가붙어있는곳은 page 지시어이다.
	//page에대한 정보를알려줌 
	//자바랭귀지 사용가능 인코딩 등등..
	// 모든 jsp첫줄에 들어간다.
	//.jst는 내부에 JAVA코드를 가지기때문에 반드시 컴파일 해야함!
	//test.jsp -> test_jsp.java
		//★★★★★★★서블릿(Servlet)★★★★★★★★
		//원래 서버프로그래밍을 서블릿으로했다. 원래 서블릿으로 웹개발했었다.
		//원래....자바코드안에서 HTML을 작성해서 웹을 만들었어야했다...
		//매우매우매우X10^99 불편했다...
		//HTML 안에서 자바를 작성해보자! 반대로
		//->이게바로 JSP ㅇㅅㅇ bb 완전 굿 혁신이다!
		// 결론) Servlet 과 JSP는 사실 같다. JSP파일을 컴파일하면 Servlet 파일이 된다 :D
		//수많은비전공자가 JSP만 배우는데 Servlet도알아야한다 일하다보면 만남 멘탈나감!
		//서블릿이란?
		// not POJO 인 클래스를 의미
		// POJO 클래스 종류
		// 		: String, Scanner, Random, Math....
		//		: Student, Member, Product, Point...
		//		지금까지 우리가 사용한 클래스는 다 POJO 였음!
		//		Plain Old JAVA Object -> 기본의 옛날 자바객체~
		// NOT POJO 인 클래스
		//		: 서블릿, 리스너, 필터
		//		리스너와 필터는 서블릿을 상속받은 클래스이다.
		//
	out.println("<h1>스크립트릿</h1>");
	//웹 페이지 코드내에서
	//JAVA를 사용하려고 탄생한 서버 프로그래밍 언어
	//system.out -> 자바콘솔에 띄워달라는 뜻 이제는 웹에다 띄우기 때문에
	//쓰지않는다
	//이표현식은 out.println을 생략할 수 있게 해주는 태그이다
	%>


</body>
</html>