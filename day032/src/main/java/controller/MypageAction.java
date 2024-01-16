package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDAO;
import model.dto.MemberDTO;

public class MypageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그 1");
		// TODO Auto-generated method stub
		ActionForward forward=new ActionForward();
		forward.setPath("mypage.jsp");
		forward.setRedirect(false);
		System.out.println(forward);
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		MemberDAO mDAO=new MemberDAO();
		MemberDTO memberDTO=new MemberDTO();
		memberDTO.setMid((String)session.getAttribute("mid"));
		memberDTO.setSearchCondition("userinfo");
		memberDTO=mDAO.selectOne(memberDTO);
		if(memberDTO != null) {
			request.setAttribute("memberDTO", memberDTO);
			//response.sendRedirect("controller.jsp?action=main");
		}
		//endRedirect() 에서 클라이언트가 이동할 페이지 정보를 response 객체의 헤더값에 넣어둔 뒤 계속 로직을 이어서 수행하기 때문입니다. 
//		위의 코드를 사용했는데
//		자바스크립트 알림창을 띄우기 전 자바 코드가 먼저 실행 되면서 redirect가 실행되기 때문에 이미 다른 페이지로 이동한 상태라 제대로 동작하지 않아 alert를 띄울 수 없던 것!
		else {
			//response를하던 sendredirect를 하던 둘중에 하나만 해야한다.
//			에러 내용을 봐서는 단말에 response 를 한 후 다시 sendRedirect 를 한 걸로 보이네요. 아시다시피 http 프로토콜은 request 1 번에 response 1번으로 통신이 이루어지고 connection 을 끊어버리는 stateless 프로토콜입니다. 결론은 response 만 하시던가 sendRedirect 만 하시던가 둘 중에 하나만 선택해서 하세요.
//			forward.setRedirect(false);
//			Script.alert(response, "로그인실패");
	
			//System.out.println("<script>alert('로그인에 실패했습니다...');history.go(-1);</script>");
		}
		
		return forward;
	}
	

}



