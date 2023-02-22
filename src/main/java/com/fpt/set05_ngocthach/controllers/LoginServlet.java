package com.fpt.set05_ngocthach.controllers;

import com.fpt.set05_ngocthach.models.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/login.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setUserName(userName).setPassword(password);

        if(userName.equals("fpt") && password.equals("aptech")){
            var session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/list");
        }else {
            req.getServletContext().getRequestDispatcher("/login.jsp").include(req, resp);
            resp.getWriter().write("Invalid username or password");
        }
    }
}
