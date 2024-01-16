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
<jsp:useBean class="model.dto.MemberDTO" id="memberDTO" />
<jsp:setProperty name="memberDTO" property="*" />
<jsp:setProperty name="rDTO" property="*" />
<%
	String action=request.getParameter("action");
	if(action.equals("main")){
		ArrayList<ReplyDTO> rdatas=rDAO.selectAll(rDTO);
		request.setAttribute("rdatas", rdatas);
		
		ArrayList<MemberDTO> mdatas=mDAO.selectAll(memberDTO);
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
		
		boolean flag=mDAO.insert(memberDTO);
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
		memberDTO.setMid((String)session.getAttribute("mid"));
		memberDTO.setSearchCondition("userinfo");
		memberDTO=mDAO.selectOne(memberDTO);
		request.setAttribute("memberDTO", memberDTO);
	
		pageContext.forward("mypage.jsp");

		// 마이페이지로 이동
	}
	
	
	else if(action.equals("login")){
		memberDTO.setSearchCondition("login");
		memberDTO=mDAO.selectOne(memberDTO);
		if(memberDTO!=null){
		 	session.setAttribute("mid",memberDTO.getMid());
			session.setAttribute("member",memberDTO.getName()); 
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
		memberDTO.setMid((String)session.getAttribute("mid"));
		System.out.println(memberDTO);
		boolean flag=mDAO.update(memberDTO);
		if(flag){
			
			//변경된 DTO 다시 보내기~ 안그러면 <%=memberDTO.getName() 에러난다...ㅡㅡ!!!
			request.setAttribute("memberDTO", memberDTO);
			out.println("<script>alert('이름 변경완료:D');</script>");
		}
		else{
			out.println("<script>alert('FAIL');history.go(-1);</script>");
		}
		pageContext.forward("mypage.jsp");
	}
	else if(action.equals("withdraw")){
		// 회원 탈퇴
		memberDTO.setMid((String)session.getAttribute("mid"));
		boolean flag=mDAO.delete(memberDTO);
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
	/* 	String member=request.getParameter("action");
		System.out.println(rDTO); */
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
	else if(action.equals("replyUpdate")){
		rDTO=rDAO.selectOne(rDTO);
		boolean flag=rDAO.update(rDTO);
		if(flag){
			request.setAttribute("rDTO", rDTO);
			pageContext.forward("reply.jsp");
			//response.sendRedirect("controller.jsp?action=main");
		}
		else{
			out.println("<script>alert('글 변경 실패!');history.go(-1);</script>");
		} 
	}
		else if(action.equals("replyDelete")){
			rDTO.setRid(Integer.parseInt(request.getParameter("Rid")));
			boolean flag=rDAO.delete(rDTO);
			if(flag){
				response.sendRedirect("controller.jsp?action=main");
			}
			else{
				out.println("<script>alert('글 삭제 실패!');history.go(-1);</script>");
			}
			
		// 댓글추가
	}
	else{
		// 이상한 요청
		// 에러처리해야함!
	}
%>