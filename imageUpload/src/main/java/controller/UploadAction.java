package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDAO;
import model.dto.MemberDTO;

public class UploadAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        ActionForward forward = new ActionForward();
        forward.setPath("main.do");
        forward.setRedirect(false);

        request.setCharacterEncoding("UTF-8");

        MemberDAO mDAO = new MemberDAO();
        MemberDTO memberDTO = new MemberDTO();

        // 해당 폴더에 이미지를 저장시킨다
        String uploadDir = this.getClass().getResource("").getPath();
        System.out.println("uploadDir : " + uploadDir);

        uploadDir = uploadDir.substring(1, uploadDir.indexOf(".metadata")) + "UploadFolder";

        System.out.println("절대경로 : " + uploadDir + "<br/>");
        request.setAttribute("uploadDir", uploadDir);

        // 총 100M 까지 저장 가능하게 함
        int maxSize = 1024 * 1024 * 100;
        String encoding = "UTF-8";

        // 사용자가 전송한 파일 정보를 토대로 업로드 장소에 파일 업로드 수행할 수 있게 함

		MultipartRequest multipartRequest

		= new MultipartRequest(request, uploadDir, maxSize, encoding,

				new CustomFileRenamePolicy("3"));

        // 중복된 파일 이름이 있기에 fileRealName이 실제로 서버에 저장된 경로이자 파일
        // fileName은 사용자가 올린 파일의 이름
        // 이전 클래스 name = "file" 실제 사용자가 저장한 실제 네임
        String fileName = multipartRequest.getOriginalFileName("file");
        String fileName1 = multipartRequest.getFilesystemName("file");


        // 디비에 업로드 메소드
        boolean flag = mDAO.insert(memberDTO);
        if (flag) {
            request.setAttribute("memberDTO", memberDTO);
        } else {

        }

        System.out.println("파일명 : " + fileName + "<br>");
        System.out.println("파일저장명 : " + fileName1 + "<br>");

        return forward;
    }

}

class CustomFileRenamePolicy extends DefaultFileRenamePolicy {

    private String newFileName;

    public CustomFileRenamePolicy(String newFileName) {
        this.newFileName = newFileName;
    }

    @Override
    public File rename(File file) {
    	String extension = extractExtension(file.getName());
        String newName = (newFileName != null) ? newFileName + extension : file.getName();
        File newFile = new File(file.getParent(), newName);

        if (newFile.exists()) {
            // 동일한 이름의 파일이 이미 존재하면 덮어쓰기
            newFile.delete();
        }

        return newFile;
    }
    
    private static String extractExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex);
        } else {
            return ""; // 확장자가 없는 경우 빈 문자열 반환
        }
    }
}

