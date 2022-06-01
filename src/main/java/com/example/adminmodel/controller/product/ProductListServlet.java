package com.example.adminmodel.controller.product;

import com.example.adminmodel.entity.Product;
import com.example.adminmodel.model.MySqlProductModel;
import com.example.adminmodel.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductListServlet extends HttpServlet {

    private ProductModel productModel;

    @Override
    public void init() throws ServletException {
        productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productModel.findAll();
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/admin/views/product/list.jsp").forward(req, resp);
    }
}
