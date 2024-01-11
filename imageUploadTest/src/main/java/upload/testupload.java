package upload;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class testupload
 */
@WebServlet("/test/upload")
public class testupload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public testupload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset = EUC-KR");
		
		
		RequestDispatcher dis = request.getRequestDispatcher("/upload/form.jsp"); 
		dis.forward(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String path = "C:\\Users\\hennie\\Desktop\\eclipes\\webworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img\\";

		
		int size = 100 * 1024 * 1024; // 100M

		
		MultipartRequest multipart = new MultipartRequest(request, path, size, "EUC-KR", new DefaultFileRenamePolicy());

		String title = multipart.getParameter("title");
		System.out.println("title" + title);


		String fname = multipart.getOriginalFileName("file");
		System.out.println("fname" + fname);
		

		File f = multipart.getFile("file");

		
		String ffname = f.getName();
 	
	
		File dir = new File (path); 

		String [] flist = dir.list();

		request.setAttribute("flist", flist);
		
		RequestDispatcher dis = request.getRequestDispatcher("/upload/list.jsp"); 
		dis.forward(request, response);
		
	}

}