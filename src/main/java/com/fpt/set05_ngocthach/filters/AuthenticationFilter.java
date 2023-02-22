package com.fpt.set05_ngocthach.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter(urlPatterns = "/*")

public class AuthenticationFilter implements Filter {
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // Nếu tham số là true sẽ luôn khởi tạo 1 session mới
        HttpSession session = request.getSession(false);

        boolean isLoginPage = request.getRequestURI().contains("/login.jsp");

        boolean isServletLoginUrl = request.getRequestURI().contains(request.getContextPath() + "/login") || request.getRequestURI().endsWith(request.getContextPath() + "/");
        boolean isLogin = (session != null && session.getAttribute("user") != null);

        // Nếu đã login và cố tình vào lại trang login
        if(isLogin && (isLoginPage || isServletLoginUrl)) {
//            request.getRequestDispatcher("/list").forward(servletRequest, servletResponse);
            response.sendRedirect(request.getContextPath() + "/list");
        }else if(!isLogin && !(isLoginPage || isServletLoginUrl)) {
            // Nếu chưa Login, mà có sẵn link cố tình truy cập
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
