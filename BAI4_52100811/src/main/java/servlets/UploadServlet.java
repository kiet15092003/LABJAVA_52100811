package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


@WebServlet(value = "/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class UploadServlet extends HttpServlet {
    private boolean isExtensionFile(String fileName) {
        String[] extensions = new String[]{ "txt", "doc", "docx", "jpg", "png", "pdf", "rar", "zip" };
        boolean flag = false;
        for (int i=0;i<extensions.length;i++) {
            if (fileName.toLowerCase().contains(extensions[i])){
                flag = true;
                break;
            }
        }
        return flag;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String name = req.getParameter("name");
            Part part = req.getPart("fileUpload");
            String checkOverride = req.getParameter("override");
            String realpath = req.getServletContext().getRealPath("/uploads");
            String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            PrintWriter out = resp.getWriter();
            if (!isExtensionFile(filename)){
                out.print("Unsupported file extension");
                return;
            }
            if (Files.exists(Paths.get(realpath+"/"+filename))){
                if (checkOverride==null){
                    out.print("File already exists");
                    return;
                }
                part.write(realpath + "/" + filename);
                out.print("File has been overriden");
            } else{
                part.write(realpath + "/" + filename);
                out.print("File has been uploaded");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
