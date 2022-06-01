package com.example.adminmodel.controller.product;

import com.example.adminmodel.entity.Product;
import com.example.adminmodel.model.MySqlProductModel;
import com.example.adminmodel.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateProductServlet extends HttpServlet {
    private ProductModel productModel;

    @Override
    public void init() throws ServletException {
        productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int id = Integer.parseInt(req.getParameter("id"));
        Product product = productModel.findById(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/admin/views/product/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
