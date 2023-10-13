package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private HashMap<String,String> userList;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userList = new HashMap<>();
        userList.put("user1","abc1");
        userList.put("user2","abc2");
        userList.put("user3","abc3");
        userList.put("user4","abc4");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (!userList.containsKey(username) || userList.get(username).equals(password)){
            printWriter.print(" Name/Password match");
        } else{
            printWriter.print("Name/Password does not match");
        }
    }
}
