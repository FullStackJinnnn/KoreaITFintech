<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="stone" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../assets/css/main.css" />
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/jquery.scrollex.min.js"></script>
<script src="../assets/js/jquery.scrolly.min.js"></script>
<script src="../assets/js/browser.min.js"></script>
<script src="../assets/js/breakpoints.min.js"></script>
<script src="../assets/js/util.js"></script>
<script src="../assets/js/main.js"></script>

<noscript>
	<link rel="stylesheet" href="../assets/css/noscript.css" />
</noscript>
<style>
<style>
input::-webkit-input-placeholder {
	font-family: "Source Sans Pro", Helvetica, sans-serif;
}

a {
	font-family: "Source Sans Pro", Helvetica, sans-serif;
}

.fields {
	text-align: center;
}

.field {
	margin-bottom: 10px;
}
</style>
</style>
</head>

<body class="is-preload">

	<!-- Wrapper -->

	<div id="wrapper">
		<!-- Header -->
		<header id="header">
			<a href="index.jsp" class="logo">CHAL KAG</a>
		</header>



		<!-- Nav -->
		<nav id="nav">
			<ul class="links">
				<%
				if (session.getAttribute("member") != null) { // 로그인 상태 메뉴
				%>
				<li><a href="sellBoardSelectAllPage.do">UsedTrade</a></li>
				<li><a href="cameraReviewSelectAllPage.do">CameraReview</a></li>
				<li><a href="freeBoardSelectAllPage.do">FreeBoard</a></li>
				<li><a href="logout.do">LOGOUT</a></li>
				<li><a href="myPage.do">MYPAGE</a></li>
				<%
				} else // 로그아웃 상태 메뉴
				{
				%>
				<li><a href="sellBoardSelectAllPage.do">Used Trade</a></li>
				<li><a href="cameraReviewSelectAllPage.do">Camera Review</a></li>
				<li><a href="freeBoardSelectAllPage.do">Free Board</a></li>
				<li><a href="loginPage.do">LOGIN</a></li>
				<li><a href="joinPage.do">SIGN IN</a></li>
				<%
				}
				%>
			</ul>
		</nav>
	</div>

	<div id="footer">
		<section>
				
				
	<script>
    // 비밀번호 일치 확인 VIEW에서 진행
    window.onload = function() {
        document.changePw.onsubmit = function(event) {
            if (document.changePw.newPw.value !== document.changePw.newPwCheck.value) {
                alert("비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
                return false; // 폼 제출의 기본 동작 중지
            }
        }
    };
</script>
					<!-- 액션 꼭 수정해!!!!!!!!!!!!!!!!!!!! -->
			<form id="changePw" name="changePw" method="post" action="../changePw.do"
				onsubmit="return validateForm()">
				<div class="fields">
					<h1 style="font-size: 20px; margin-left : 20px;">비밀번호 변경</h1>
					<!-- 변경할 비밀번호 -->
					<div class="field">
						<label for="newPw"></label> <input type="text" name="newPw"
							id="newPw" placeholder="변경할 비밀번호를 입력해주세요" required />
					</div>

					<!-- 변경할 비밀번호 확인 -->
					<div class="field">
						<label for="newPwCheck"></label> <input type="text" name="newPwCheck"
							id="newPwCheck" placeholder="비밀번호를 다시 한 번 확인해주세요" required />
					</div>

					<!--  확인버튼 -->
					<div class="field">

						<div class="actions" style="text-align: center; margin-top: 10px;">
							<input type="submit" value="비밀번호 변경" style="width: 250px;" />
						</div>
					</div>
				</div>
			</form>
		</section>
	</div>
</body>

</html>