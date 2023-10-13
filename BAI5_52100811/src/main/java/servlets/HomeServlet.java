package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@WebServlet(value = "/")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> parameterNames = req.getParameterNames();
        if (parameterNames.hasMoreElements()){
            String page = req.getParameter("page");
            if (page == null || (!page.equals("contact") && !page.equals("help") && !page.equals("about"))) {
                resp.setContentType("text/plain");
                PrintWriter out = resp.getWriter();
                out.println("Welcome to our website");
                out.close();
            } else{
                String viewName = page + ".jsp";
                String viewUrl = "/pages/" + viewName;
                getServletContext().getRequestDispatcher(viewUrl).forward(req, resp);
            }
        } else {
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
