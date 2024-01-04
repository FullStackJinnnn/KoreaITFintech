package calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1=Integer.parseInt(request.getParameter("num1"));
		String op=request.getParameter("op");
		int num2=Integer.parseInt(request.getParameter("num2"));
		
		
		//test2랑 프로세스가 똑같다.
		//new -> set -> 계산 -> get
		//int result=calc(num1,num2,op);
		
		CalcBean cb = new CalcBean();
		cb.setNum1(num1);
		cb.setNum2(num2);
		cb.setOp(op);
		cb.calc();
		
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		out.println("결과 :" + cb.getResult());
	}
	
	
	/*
	public int calc(int num1, int num2, String op) {
		int result=0;
		if(op.equals("+")) {
			result=num1+num2;
		}
		else {
			result=num1-num2;
		}
		return result;
	}
	*/
	
	//★개발자의 최고 목표는 "유지 보수~ "
	//★"모듈화"가 기본입니다!!! :D
	// jsp 에서 모두처리 OUT
	// Bean 에서 처리 ->>>> Bean을 활용하는 방식이 웹의 표준이다!!!!!!
	// Servlet 에서 처리 OUT

}
