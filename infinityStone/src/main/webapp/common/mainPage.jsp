<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>CHAL KAG</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="../assets/css/main.css" />
		
	<noscript>
		<link rel="stylesheet" href="../assets/css/noscript.css" />
	</noscript>
	
</head>

<body class="is-preload">
	<!-- Wrapper -->
		
	<div id="wrapper">
		<!-- Header -->
		<header id="header">
			<a href="../main.do" class="logo">CHAL KAG</a>
		</header>
		
		
		
		<!-- Nav -->
		<nav id="nav">
			<ul class="links">
				<%if(session.getAttribute("member")!=null){ // 로그인 상태 메뉴%>
				<li><a href="../sellBoardSelectAllPage.do">UsedTrade</a></li>
				<li><a href="../cameraReviewSelectAllPage.do">CameraReview</a></li>
				<li><a href="../freeBoardSelectAllPage.do">FreeBoard</a></li>
				<li><a href="../logout.do">LOGOUT</a></li>
				<li><a href="../myPage.do">MYPAGE</a></li>
				<%	
				}else // 로그아웃 상태 메뉴
				{
				%>
				<li><a href="../sellBoardSelectAllPage.do">Used Trade</a></li>
				<li><a href="../cameraReviewSelectAllPage.do">Camera Review</a></li>
				<li><a href="../freeBoardSelectAllPage.do">Free Board</a></li>
				<li><a href="../loginPage.do">LOGIN</a></li>
				<li><a href="../joinPage.do">SIGN IN</a></li>
				<%}%>
			</ul>
		</nav>
	</div>
	<!-- Main -->
	<div id="main">

		<!-- Featured Post -->
		<article class="post featured">
			<header class="major">
				<h3>The moment the shutter sound echoes, <br>here is where creation and emotion converge.
					</h3>
				<a href="#" class="image main"><img src="../images/mainImage.png" alt="" /></a>
			</header>

		</article>
	</div>

</body>

</html>