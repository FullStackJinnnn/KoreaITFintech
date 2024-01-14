<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- enctype은 파입 업로드에서 무조건 사용되어야한다 -->
<%MemberDTO mDTO = (MemberDTO)request.getAttribute("mDTO"); %>
	<form action="upload.do" method="post" enctype="multipart/form-data">

		파일 : <input type="file" name="file"><br>
	

		<input type="submit" value="업로드"><br>
		</form>
		
	 	<%if (mDTO!=null) {%>  
	 	<script>
		location.reload(true)
		</script>
		절대경로 : <%=request.getAttribute("uploadDir")%>
		파일명 : <%=mDTO.getFileName()%>
		실제파일명 :  <%=mDTO.getFileRealName()%>
		 <% }%> 
		

</body>
</html>