package com.example.adminmodel.controller.shoppingcart;

import com.example.adminmodel.entity.ShoppingCart;
import com.example.adminmodel.model.MySqlProductModel;
import com.example.adminmodel.model.ProductModel;
import com.example.adminmodel.util.ShoppingCartHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveCartServlet extends HttpServlet {
    private ProductModel productModel;
    public RemoveCartServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer productId = Integer.parseInt(req.getParameter("productId"));
            ShoppingCartHelper shoppingCartHelper = new ShoppingCartHelper(req);
            ShoppingCart shoppingCart = shoppingCartHelper.getCart();
        } catch (Exception e){
            resp.getWriter().println(e.getMessage());
        }
    }
}
