<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.member.*"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="stone"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>마이페이지</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css" />
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/jquery.scrollex.min.js"></script>
<script src="../assets/js/jquery.scrolly.min.js"></script>
<script src="../assets/js/browser.min.js"></script>
<script src="../assets/js/breakpoints.min.js"></script>
<script src="../assets/js/util.js"></script>
<script src="../assets/js/main.js"></script>

<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
<style>
input::-webkit-input-placeholder {
	font-family: "Source Sans Pro", Helvetica, sans-serif;
}

a {
	font-family: "Source Sans Pro", Helvetica, sans-serif;
}

.fields {
	/* text-align: center; */
	
}

.field button {
	display: inline-block; /* 버튼을 인라인 블록 요소로 설정 */
}

/* .action>button {
	text-align: right;
} */
.photo {
	width: 300px;
	height: 350px;
	border: 3px solid black;
	overflow: hidden;
}

/* 텍스트박스 길이 조정 스타일 추가 */
.field input[type="text"] {
	display: inline-block; /* 텍스트박스를 인라인 블록 요소로 설정 */
	width: 60%; /* 100%로 조정하거나 필요에 맞게 너비 설정 */
	font-weight: bold; /* 글자를 진하게 표시하는 스타일 추가 */
}
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
		<%
		MemberDTO memberDTO = (MemberDTO) request.getAttribute("memberDTO");
		%>
		<section>
			<div class="fields">
				<h1 style="font-size: 150px; text-align: center;">MyPage</h1>
				<!-- 프사 -->
	<!-- 			<form action="imageUpload.do" -->
				<div class="field">
					<div class="photo">
						<img alt="이미지 01"
							src="${pageContext.request.contextPath}/mimg/<%=memberDTO.getProfile()%>">
					</div>
					<div>
						<input type="file" name="이미지선택">
							style="display: flex; margin-top: 10px;">이미지 선택</button>
					</div>
				</div>



				<!-- 아이디 -->
				<div class="field"> 
					<label for="myPageID"></label> <input type="text" name="myPageID"
						id="myPageID" value="<%=memberDTO.getMemberID()%>" readonly />
				</div>

				<!-- 이름 -->
				<div class="field">
					<label for="myPageName"></label> <input type="text"
						name="myPageName" id="myPageName" value="<%=memberDTO.getName()%>"
						readonly />
				</div>

				<!-- 닉네임 -->
				<div class="field">
					<form id="changeNickname" method="post" action="changeNickname.do">
						<label for="myPageNickname"></label> <input type="text"
							name="myPageNickname" id="myPageNickname"
							value="<%=memberDTO.getNickname()%>" required /> <input
							type="submit" value="닉네임 변경" style="margin-left: 30px;" />
					</form>
				</div>


				<!-- 번호 변경페이지로 이동 -->
				<div class="field">
					<label for="myPagePh"></label> <input type="text" name="myPagePh"
						id="myPagePh" value='<%=memberDTO.getPh()%>' readonly />
					<button type="button" style="margin-left: 30px;"
						onclick="location.href='${pageContext.request.contextPath}/changePh.do'">전화번호
						변경</button>
				</div>
				<script>
    document.addEventListener('DOMContentLoaded', function() {
        var phoneNumberElement = document.getElementById('myPagePh');
        if (phoneNumberElement) {
            // 페이지 로딩 후 전화번호 엘리먼트를 찾고, 가운데 4자리를 '*'로 대체
            phoneNumberElement.value = maskPhoneNumber('<%=memberDTO.getPh()%>');
        }
    });

    function maskPhoneNumber(phoneNumber) {
        // 전화번호 형식이 "010-1111-2222"이라 가정
        var parts = phoneNumber.split('-');
        if (parts.length === 3) {
            // 가운데 4자리를 '*'로 대체
            parts[1] = '****';
            // 새로운 전화번호 조합
            return parts.join('-');
        } else {
            // 형식에 맞지 않는 경우 그대로 반환
            return phoneNumber;
        }
    }
</script>

				<div class="field" style="text-align: left; margin-top: 10px;">
					<div class="actions">
						<!-- 내 작성글로 이동 버튼 -->
						 <button type="button" style="margin-right: 10px;" onclick="location.href='#'">내 작성글로 가기</button>

						<!-- 비밀번호 변경 버튼 -->
						<button type="button" onclick="location.href='${pageContext.request.contextPath}/checkPwPage.do'">비밀번호 변경</button>
					</div>
				</div>

				<div class="field"
					style="display: flex; justify-content: space-between; margin-top: 30px;">
					<div>
						<button type="button"
							onclick="location.href='${pageContext.request.contextPath}/main.do'">변경
							완료</button>
					</div>
					<div style="text-align: right;">
						<button type="button"
							onclick="location.href='${pageContext.request.contextPath}/deleteAccount.do'">회원
							탈퇴</button>
					</div>
				</div>

			</div>
		</section>
	</div>
</body>

</html>