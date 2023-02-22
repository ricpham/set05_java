package com.fpt.set05_ngocthach.controllers;

import com.fpt.set05_ngocthach.services.IProductService;
import com.fpt.set05_ngocthach.services.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    IProductService productService = new ProductService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String[] ids = req.getParameterValues("ids");
            for (String id: ids) {
                productService.deleteProduct(id);
            }
            resp.sendRedirect(req.getContextPath() + "/list");
        }catch (Exception ex) {
            req.setAttribute("error", ex.getMessage());
            req.getServletContext().getRequestDispatcher("/WEB-INF/failed.jsp").forward(req, resp);
            ex.printStackTrace();
        }


    }
}
