<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.dto.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	// getParameter() 해서 setXxx() 를 진행할때에 인코딩깨짐
	// 얘 전(10번 라인 전)에 수행해야함!!!!!
%>
<jsp:useBean class="model.dao.ReplyDAO" id="rDAO" />
<jsp:useBean class="model.dto.ReplyDTO" id="rDTO" />
<jsp:useBean class="model.dao.MemberDAO" id="mDAO" />
<jsp:useBean class="model.dto.MemberDTO" id="mDTO" />
<jsp:setProperty name="mDTO" property="*" />
<jsp:setProperty name="rDTO" property="*" />
<%
	String action=request.getParameter("action");
	if(action.equals("main")){
		ArrayList<ReplyDTO> rdatas=rDAO.selectAll(rDTO);
		request.setAttribute("rdatas", rdatas);
		
		ArrayList<MemberDTO> mdatas=mDAO.selectAll(mDTO);
		request.setAttribute("mdatas", mdatas);
	
		pageContext.forward("main.jsp");
		// 새로운 요청 : GET
		// 기존 요청 정보를 모두 삭제시킴
		// 리다이렉트 방식
		// ↓
		// 기존 요청 정보를 유지하는 요청 방식을 사용해야한다!!!!!
		// 포워드 방식
	}
	else if(action.equals("join")){
		
		boolean flag=mDAO.insert(mDTO);
		if(flag){
			response.sendRedirect("controller.jsp?action=main");
		}
		else{
			out.println("<script>alert('ID 중복 등으로 인해 회원가입에 실패하셨습니다!');history.go(-1);</script>");
		}
	}
	else if(action.equals("joinPage")){
		response.sendRedirect("join.jsp"); // V -> C ->  V
	}
	
	
	else if(action.equals("logout")){
	session.invalidate();
	response.sendRedirect("login.jsp");
		// 로그아웃
	}
	else if(action.equals("mypage")){
		mDTO.setMid((String)session.getAttribute("mid"));
		mDTO.setSearchCondition("userinfo");
		mDTO=mDAO.selectOne(mDTO);
		request.setAttribute("mDTO", mDTO);
	
		pageContext.forward("mypage.jsp");

		// 마이페이지로 이동
	}
	
	
	else if(action.equals("login")){
		mDTO.setSearchCondition("login");
		mDTO=mDAO.selectOne(mDTO);
		if(mDTO!=null){
		 	session.setAttribute("mid",mDTO.getMid());
			session.setAttribute("member",mDTO.getName()); 
			response.sendRedirect("controller.jsp?action=main");
			
		}
		else{
			out.println("<script>alert('로그인실패!');history.go(-1);</script>");
		}
	}
	
	else if(action.equals("loginPage")){
		response.sendRedirect("login.jsp");
		// 로그인 페이지로 이동
	}
	else if(action.equals("updateName")) {
		// 이름 변경
		mDTO.setMid((String)session.getAttribute("mid"));
		boolean flag=mDAO.update(mDTO);
		if(flag){
			//변경된 DTO 다시 보내기~ 안그러면 <%=mDTO.getName() 에러난다...ㅡㅡ!!!
			request.setAttribute("mDTO", mDTO);
			out.println("<script>alert('이름 변경완료:D');</script>");
		}
		else{
			out.println("<script>alert('FAIL');history.go(-1);</script>");
		}
		pageContext.forward("mypage.jsp");
	}
	else if(action.equals("withdraw")){
		// 회원 탈퇴
		mDTO.setMid((String)session.getAttribute("mid"));
		boolean flag=mDAO.delete(mDTO);
		if(flag){
			out.println("<script>alert('탈퇴완료');</script>");
			session.invalidate();
			response.sendRedirect("controller.jsp?action=main");
			
		}
		else{
			out.println("<script>alert('FAIL');history.go(-1);</script>");
		}
	}
	
	else if(action.equals("replySelectOne")){
		rDTO.setRid(Integer.parseInt(request.getParameter("Rid")));
		rDTO=rDAO.selectOne(rDTO);
		request.setAttribute("rDTO", rDTO);
		pageContext.forward("reply.jsp");
		
		// 댓글 상세 페이지로 이동
	}
	else if(action.equals("replyInsert")){
		String member=request.getParameter("action");
		System.out.println(rDTO);
		boolean flag=rDAO.insert(rDTO);
		if(flag){
			request.setAttribute("rDTO", rDTO);
			//response.sendRedirect("controller.jsp?action=main");
			pageContext.forward("controller.jsp?action=main");
		}
		else{
			out.println("<script>alert('글 작성 실패!');history.go(-1);</script>");
		}
		// 댓글추가
	}
	else{
		// 이상한 요청
		// 에러처리해야함!
	}
%>