package com.fpt.set05_ngocthach.controllers;

import com.fpt.set05_ngocthach.services.IProductService;
import com.fpt.set05_ngocthach.services.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = {"/list", "/list/*"})
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IProductService productService = new ProductService();

        req.setAttribute("productList", productService.getAll());
        req.getServletContext().getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);

    }
}
