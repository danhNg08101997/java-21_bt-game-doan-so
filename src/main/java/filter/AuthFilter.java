package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter đã được kích hoạt - Cần nhấn checkbox để đăng nhập");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if (!req.getServletPath().startsWith("/login")) {
            System.out.println("Filter đang kiểm tra Login");
            if (req.getSession().getAttribute("email") != null && req.getSession().getAttribute("password") != null) {
                System.out.println("Filter cho phép đăng nhập có lưu session");
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                System.out.println("Chưa đăng nhập Filter chuyển đến login page");
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        } else {
            System.out.println("Login page");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
    }
}
