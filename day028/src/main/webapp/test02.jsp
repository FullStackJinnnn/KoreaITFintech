<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="cb" class="calc.CalcBean"/>
<%-- new 를 대신하는 JSP 코드 useB
an~ 클래스에는 클래스명 id는 객체명-->	
	<!-- calc.CalcBean cb=new calc.CalcBean(); -->	
	<!-- 여기서 기본생성자를 사용해야하기 때문에 웹에서 기본생성자를 쓰고 자바로도 기본생성자로 연습을 한 것 이다. -->
 --%>

<jsp:setProperty name="cb" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두번 쨰 실습~</title>
</head>
<body>

<%cb.calc();%>

	<form method="POST">
		<input type="text" name="num1"> <select name="op">
			<option>+</option>
			<option>-</option>
		</select> <input type="text" name="num2"> <input type="submit"
			value="계산하기">
	</form>

	<hr>

	<h2>계산결과 : <jsp:getProperty name="cb" property="result"/></h2>
	<!-- JSP에서 getter를 부르는 태그!! cb의 result속성을 getter로 가져온다~ -->




</body>
</html>