<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
   <br><br>
   <img alt="더미 이미지 데이터 01" src="images/test01.jpg"> <br><br>
   <img alt="더미 이미지 데이터 02" src="images/test02.jpg"> <br><br>
   <button id="btn">버튼</button>
<script type="text/javascript">
   $(document).ready(function(){
      $("#btn").on("click",function(){
      
         $.ajax({
            type : "POST",
            url : "apple.do",
            data : { 'banana' : '바나나' , 'kiwi' : 123 },
            dataType : 'text',
            success : function(data){
               console.log(data); // 사과 가 출력됨
               
               if(data=='사과'){
                  $("body").append("<img alt='더미 이미지 데이터' src='images/test03.jpg'>");
               }
            },
            error : function(error){
               console.log('에러발생!');
               console.log('에러의 종류 : '+error);
            }
         });
         
      });
   });
</script>
</body>
</html>