package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ReplyDAO;
import model.dto.ReplyDTO;

public class ReplyInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward=new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true);
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		ReplyDAO rDAO=new ReplyDAO();
		ReplyDTO rDTO=new ReplyDTO();
		rDTO.setWriter((String)session.getAttribute(("mid")));
		rDTO.setContent(request.getParameter("content"));
		System.out.println(rDTO);
		boolean flag=rDAO.insert(rDTO);
		if (flag) {
			
		}
		else {
			
		}
		
		return forward;
	}

}
