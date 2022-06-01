package com.example.adminmodel.controller.product;

import com.example.adminmodel.entity.Product;
import com.example.adminmodel.model.MySqlProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProductServlet extends HttpServlet {
    private MySqlProductModel mySqlProductModel;

    @Override
    public void init() throws ServletException {
        mySqlProductModel = new MySqlProductModel();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/views/product/create.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; chartset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String detail = req.getParameter("detail");
        Double price = 0.0;
        if(req.getParameter("price") != null && req.getParameter("price") != "") {
            price = Double.parseDouble(req.getParameter("price"));
        }
        String thumbnail = req.getParameter("thumbnail");
        String manufactureEmail = req.getParameter("manufactureEmail");
        String manufacturePhone = req.getParameter("manufacturePhone");
        Product product = new Product("Product 3335552", "description", "detail", 10000, "src/image/product.png", "admin@gmail.com", "0123456789");
        if(product.isValid()) {
            mySqlProductModel.save(product);
            resp.sendRedirect("/list");
        }else {
            req.setAttribute("errors", product.getErrors());
            req.setAttribute("product", product); // set lai product de luu ga tri
            req.getRequestDispatcher("/product/create.jsp").forward(req,resp);
        }
    }
}
