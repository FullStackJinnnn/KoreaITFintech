<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿 사용</title>
</head>
<body>

<%!
	int i = 10000;

%>


<%if(true){
	i=0;
	System.out.print(i);%>

<script>
document.write(4 * 5);
console.log("왕");
</script>
<% } else { %>

<script>
document.write(100);
</script>
 <% }%> 

 <script>
console.log("i출력~");
<h1><%=i%></h1>
</script>

<%
	// JAVA 코드 공간
	for(int i=1;i<=5;i++){
		out.println(i+" <br>");
	}
%>

<hr>

<%
	for(int i=1;i<=5;i++){ //자바공간
%>
		<%=i%> <br> <!-- HTML공간 -->
<%
	} //자바공간
%>


</body>
</html>