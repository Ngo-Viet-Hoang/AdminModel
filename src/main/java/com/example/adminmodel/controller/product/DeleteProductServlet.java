package com.example.adminmodel.controller.product;

import com.example.adminmodel.entity.Product;
import com.example.adminmodel.entity.entityEnum.ProductStatus;
import com.example.adminmodel.model.MySqlProductModel;
import com.example.adminmodel.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class DeleteProductServlet extends HttpServlet {
    private ProductModel productModel;

    @Override
    public void init() throws ServletException {
        productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("id"));
        Product product = productModel.findById(productId);
        product.setProductStatus(ProductStatus.DELETE);
        product.setDeletedAt(LocalDateTime.now());
        if(productModel.update(productId, product)) {
            resp.sendRedirect("/products/list");
        }
    }

}
