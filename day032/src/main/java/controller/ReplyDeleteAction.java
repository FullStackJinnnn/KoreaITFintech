package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ReplyDAO;
import model.dto.ReplyDTO;

public class ReplyDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ActionForward forward=new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true);
		
		HttpSession session = request.getSession();
		ReplyDAO rDAO=new ReplyDAO();
		ReplyDTO rDTO=new ReplyDTO();
		rDTO.setRid(Integer.parseInt(request.getParameter("rid")));
		boolean flag=rDAO.delete(rDTO);
		if(flag) {
	
		}

		else {
		
		
		}
		return forward;
	}
	

}


