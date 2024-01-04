<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재밌는 첫번째 실습~</title>
</head>
<body>
	<%  
	int result = 0;
	//요청정보는 request라는 객체에 저장되어있다.
	//웹에서의 모든 데이터는 String 타입!!! parseInt로 Integer로 바꿔준다. 
	//처음 화면을 볼때 num1이 없다 -> null값으로 인식함
	//따라서 포스트 요청이 들어오면 그때 해달라고 알려줘야함
	//처음 페이지를 보여달라는 요청은 GET (디폴트 요청)
	if (request.getMethod().equals("POST")) { //포스트 요청하기
		int num1 = Integer.parseInt(request.getParameter("num1")); //리턴타입 String
		String op = request.getParameter("op");
		int num2 = Integer.parseInt(request.getParameter("num2"));
		// String op=request.getParameter("opppp")처럼 잘못쓰면 
		//★★★★★에러는 안나고 데이터가 안간다 그냥 ★★★ 어렵당 
		// String op=null; 이되어버림
		//500대는~ 백엔드 에러 ~ 100% 
		//404는 프론트 에러~ 
		if (op.equals("+")) {
			result = num1 + num2;
		} else {
			result = num1 - num2;
		}
	}
	%>
	<!-- jsp는 서버프로그래밍 언어니까 데이터를 주고받을 수 밖에 없는데
사용자가 데이터를 줄때는 대부분 form을 쓴다 -->
	<!-- 오늘은 자기 자신에게 전달~ -->
	<!-- 데이터 품어서 주기 POST~ 대부분 form은 POST 쓴다 -->
	<form method="POST">
		<input type="text" name="num1">
		<select name="op">
			<option>+</option>
			<option>-</option>
		</select> <input type="text" name="num2"> 
		<input type="submit" value="계산하기">
	</form>

	<hr>

	<h2>
		계산결과 :
		<%=result%></h2>





</body>
</html>