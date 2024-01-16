package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDAO;
import model.dto.MemberDTO;


public class UploadAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ActionForward forward=new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(false);
		
		request.setCharacterEncoding("UTF-8");
		
		MemberDAO mDAO=new MemberDAO();
		MemberDTO memberDTO=new MemberDTO();
		
		 // 해당 폴더에 이미지를 저장시킨다

 	 	 String uploadDir =this.getClass().getResource("").getPath();
 	 	 System.out.println("uploadDir : " + uploadDir);

		 uploadDir = uploadDir.substring(1,uploadDir.indexOf(".metadata"))+"uploadFolder";
		 
		 System.out.println("절대경로 : " + uploadDir + "<br/>"); 
		 request.setAttribute("uploadDir", uploadDir);
	 

		

		// 총 100M 까지 저장 가능하게 함

		int maxSize = 1024 * 1024 * 100;

		String encoding = "UTF-8";

		

		// 사용자가 전송한 파일정보 토대로 업로드 장소에 파일 업로드 수행할 수 있게 함

		MultipartRequest multipartRequest

		= new MultipartRequest(request, uploadDir, maxSize, encoding,

				new DefaultFileRenamePolicy());

		

               // 중복된 파일이름이 있기에 fileRealName이 실제로 서버에 저장된 경로이자 파일

               // fineName은 사용자가 올린 파일의 이름이다

		// 이전 클래스 name = "file" 실제 사용자가 저장한 실제 네임

		String fileName = multipartRequest.getOriginalFileName("file");

		// 실제 서버에 업로드 된 파일시스템 네임

		String fileRealName = multipartRequest.getFilesystemName("file");
		
		memberDTO.setFileName(fileName);
		memberDTO.setFileRealName(fileRealName);
		
	

		// 디비에 업로드 메소
		//new fileDAO().upload(fileName, fileRealName);
		boolean flag = mDAO.insert(memberDTO); 
		if (flag) {
			request.setAttribute("memberDTO", memberDTO);
		} else {
			
		}

		System.out.println("파일명 : " + fileName + "<br>");

		System.out.println("실제파일명 : " + fileRealName + "<br>");
		return forward;
	}

}
