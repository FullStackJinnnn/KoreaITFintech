package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// controller.jsp 의 코드를 옮겨올예정!

		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String action = uri.substring(cp.length());
//		System.out.println(action);
//		System.out.println("로그@@@@@@@@@");
//		System.out.println(action);

		ActionForward forward = null;
		if (action.equals("/main.do")) { // ◀ if(action.equals("main")){
			forward = new MainAction().execute(request, response);
		} else if (action.equals("/join.do")) {
			forward = new JoinAction().execute(request, response);
		} else if (action.equals("/joinPage.do")) {
			forward = new ActionForward();
			forward.setPath("join.jsp");
			forward.setRedirect(true);
			// response.sendRedirect("join.jsp");
		} else if (action.equals("/logout.do")) {
			forward = new LogoutAction().execute(request, response);
		} else if (action.equals("/testPage.do")) {

		} else if (action.equals("/myPage.do")) {
			System.out.println("로그2?");
			// forward = new JoinAction().execute(request, response);
//			forward = new ActionForward();
//			forward.setPath("myPage.jsp");
//			forward.setRedirect(true);
			forward = new MypageAction().execute(request, response);
		} else if (action.equals("/loginPage.do")) {
			forward = new ActionForward();
			forward.setPath("login.jsp");
			forward.setRedirect(true);
		} else if (action.equals("/login.do")) {
			forward = new LoginAction().execute(request, response);
		} else if (action.equals("/replySelectOne.do")) {
			forward = new ReplySelectOneAction().execute(request, response);
		} else if (action.equals("/replyInsert.do")) {
			forward = new ReplyInsertAction().execute(request, response);
		} else if (action.equals("/replyUpdate.do")) {
			forward = new ReplyUpdateAction().execute(request, response);
		} else if (action.equals("/replyDelete.do")) {
			forward = new ReplyDeleteAction().execute(request, response);
		} else if (action.equals("/changeName.do")) {
			forward = new ChangeNameAction().execute(request, response);
		} else if (action.equals("/memberDelete.do")) {
			forward = new MemberDeleteAction().execute(request, response);
		} else {

		}

		if (forward == null) {
			// 에러 상황
		}

		if (forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
			// pageContext.forward(forward.getPath());
		}

	}

}
