package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ReplyDAO;
import model.dto.ReplyDTO;
import script.Script;

public class ReplySelectOneAction implements Action{
 
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ActionForward forward=new ActionForward();
		forward.setPath("reply.jsp");
		forward.setRedirect(false);
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		ReplyDAO rDAO=new ReplyDAO();
		ReplyDTO rDTO=new ReplyDTO();
		rDTO.setRid(Integer.parseInt(request.getParameter("rid")));
		rDTO=rDAO.selectOne(rDTO);
		
		if(rDTO != null) {
			request.setAttribute("rDTO", rDTO);
		}
		else {
		}
		
		return forward;
	}
	

}
