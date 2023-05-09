package controller;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "loginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rememberCheck = req.getParameter("checkboxLoginName");

        boolean isSuccess = userService.checkLogin(email, password);
        if (isSuccess && rememberCheck != null ) {
            HttpSession session = req.getSession();
            session.setAttribute("email", email);
            session.setAttribute("password", password);
            session.setMaxInactiveInterval(30);

            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/");
        }else if (isSuccess){
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/");
        }
        else {
            System.out.println("Login Fail");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
