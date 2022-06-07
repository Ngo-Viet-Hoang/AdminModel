package com.example.adminmodel.controller.category;

import com.example.adminmodel.entity.Category;
import com.example.adminmodel.entity.Product;
import com.example.adminmodel.entity.entityEnum.ProductStatus;
import com.example.adminmodel.model.CategoryModel;
import com.example.adminmodel.model.MySqlCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class DeleteCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;

    @Override
    public void init() throws ServletException {
        categoryModel = new  MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int categoryId = Integer.parseInt(req.getParameter("id"));
        Category category = categoryModel.findById(categoryId);
        category.setProductStatus(ProductStatus.DELETE);
        category.setDeletedAt(LocalDateTime.now());
        if(categoryModel.update(categoryId, category)) {
            resp.sendRedirect("/categories/list");
        }
    }
}
