package controller.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.front.Action;
import controller.front.ActionForward;
import model.member.MemberDAO;
import model.member.MemberDTO;

public class CheckPwAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward forward = new ActionForward();

		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		//비밀번호 변깅시 비밀번호 확인에서 로그인로직 재활용
		HttpSession session = request.getSession();
		memberDTO.setMemberID((String)session.getAttribute("member"));
		memberDTO.setMemberPW(request.getParameter("checkPw"));
		memberDTO.setSearchCondition("로그인");
		System.out.println(memberDTO+"memberDTO[로그]");
		memberDTO = memberDAO.selectOne(memberDTO);

		if (memberDTO != null) {

			forward.setPath("changePwPage.do");
			forward.setRedirect(true);
			System.out.println(forward + "forward[로그]");

		} else {

			forward.setPath("error/alertPage.jsp");
			forward.setRedirect(true);
			request.setAttribute("msg", "비밀번호를 잘못 입력하였습니다!");
		}

		return forward;
	}

}
