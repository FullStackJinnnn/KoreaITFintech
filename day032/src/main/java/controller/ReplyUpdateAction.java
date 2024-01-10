package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ReplyDAO;
import model.dto.ReplyDTO;

public class ReplyUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward=new ActionForward();
		forward.setPath("reply.jsp");
		forward.setRedirect(false);
		request.setCharacterEncoding("UTF-8");
		
		ReplyDAO rDAO=new ReplyDAO();
		ReplyDTO rDTO=new ReplyDTO();
		rDTO.setRid(Integer.parseInt(request.getParameter("rid")));
		rDTO.setContent(request.getParameter("content"));
		boolean flag=rDAO.update(rDTO);
		if (flag) {
			rDTO=rDAO.selectOne(rDTO);
			request.setAttribute("rDTO", rDTO);
		}
		else {
			
		}
		return forward;
	}

}
