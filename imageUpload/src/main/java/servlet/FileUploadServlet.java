package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/FileUploadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
                 maxFileSize = 5 * 1024 * 1024,
                 maxRequestSize = 5 * 5 * 1024 * 1024)
public class FileUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            // 파일 업로드 처리
            Collection<Part> parts = request.getParts();
            for (Part part : parts) {
                String fileName = getFileName(part);
                part.write(getUploadPath() + File.separator + fileName);
                
                // 업로드 성공 시 이미지 URL을 응답으로 전송
                out.print("{\"imageUrl\": \"" + getServletContext().getContextPath() + "/uploads/" + fileName + "\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("{\"error\": \"업로드 실패\"}");
        }
    }

    // 파일 이름 추출
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    // 업로드 경로 가져오기
    private String getUploadPath() {
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        return uploadPath;
    }
}
