package com.example.adminmodel.controller.product;

import com.example.adminmodel.entity.Category;
import com.example.adminmodel.entity.Product;
import com.example.adminmodel.model.MySqlCategoryModel;
import com.example.adminmodel.model.MySqlProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CreateProductServlet extends HttpServlet {
    private MySqlProductModel productModel;
    private MySqlCategoryModel categoryModel;

    @Override
    public void init() throws ServletException {
        productModel = new MySqlProductModel();
        categoryModel = new MySqlCategoryModel();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories =  categoryModel.findAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/admin/views/product/create.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; chartset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String detail = req.getParameter("detail");
        Double price = 0.0;
        if(req.getParameter("price") != null && req.getParameter("price") != "") {
            price = Double.parseDouble(req.getParameter("price"));
        }
        String thumbnail = req.getParameter("thumbnail");
        Product product = new Product( categoryId ,name, description,detail, price,  thumbnail);
       if(product.isValid()) {
            productModel.save(product);
            resp.sendRedirect("/products/list");
        }else {
           List<Category> categories =  categoryModel.findAll();
           req.setAttribute("categories", categories);
            req.setAttribute("errors", product.getErrors());
            req.setAttribute("product", product); // set lai product de luu ga tri
            req.getRequestDispatcher("/admin/views/product/create.jsp").forward(req,resp);
        }
    }
}
