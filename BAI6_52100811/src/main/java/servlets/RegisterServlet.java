package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String birthday = req.getParameter("birthday");
        String birthtime = req.getParameter("birthtime");
        String gender = req.getParameter("gender");
        String country = req.getParameter("country");
        String[] favorite_ide = new String[]{req.getParameter("favorite_ide[]")};
        String toeic = req.getParameter("toeic");
        String message = req.getParameter("message");
        resp.setContentType( "text/html" );
        String url = "";
        for (int i=0;i<favorite_ide.length;i++){
            url += favorite_ide[i] + ",";
        }
        resp.sendRedirect( "pages/registerOutput.jsp?name="+name+"&"+
                "email="+email+"&" + "birthday="+birthday+"&"
        +"birthtime="+birthtime+"&"+"gender="+gender+"&"+
                "country="+country+"&"+"toeic="+toeic+"&"+
                "message="+message+"&"+
                "favorite_ide="+url);
    }
}
