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
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; chartset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        int categoryId = Integer.parseInt(req.getParameter("category"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String detail = req.getParameter("detail");
        Double price = Double.parseDouble(req.getParameter("price"));
        String thumbnail = req.getParameter("thumbnail");
        String manufactureEmail = req.getParameter("manufactureEmail");
        String manufacturePhone = req.getParameter("manufacturePhone");
        Product product = new Product( categoryId, name, description,detail, price,  thumbnail);
        if(productModel.update(id, product)) {
            resp.sendRedirect("/products/list");
        }
    }
}
