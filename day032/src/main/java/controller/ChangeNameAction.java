package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDAO;
import model.dto.MemberDTO;
import script.Script;

public class ChangeNameAction implements Action{
	 
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ActionForward forward=new ActionForward();
		forward.setPath("mypage.jsp");
		forward.setRedirect(false);
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		MemberDAO mDAO=new MemberDAO();
		MemberDTO mDTO=new MemberDTO();
		mDTO.setMid((String)session.getAttribute("mid"));
		mDTO.setName(request.getParameter("name"));
		boolean flag=mDAO.update(mDTO);
		if(flag) {
			request.setAttribute("mDTO", mDTO);
		}
	
		else {

		}
		return forward;
	}
	

}
